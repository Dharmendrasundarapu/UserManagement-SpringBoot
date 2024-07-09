package com.pro1.UserManagementservice.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pro1.UserManagementservice.Applicationconstants.Constants;
import com.pro1.UserManagementservice.Entity.User;
import com.pro1.UserManagementservice.dto.request.UserRequest;
import com.pro1.UserManagementservice.dto.response.OrderResponse;
import com.pro1.UserManagementservice.dto.response.UserResponse;
import com.pro1.UserManagementservice.handler.NoEmailAndPassword;
import com.pro1.UserManagementservice.handler.NoSuchId;
import com.pro1.UserManagementservice.handler.UserExists;
import com.pro1.UserManagementservice.repo.UserRepository;

@Service
public  class UserService1 implements UserService  {
	
   @Autowired
  private UserRepository userRepository;
   @Autowired
   private RestTemplate restTemplate;
   
   public UserResponse save(UserRequest UserRequest) {
	   Optional<User> UserExist=userRepository.findByEmailAndPassword(UserRequest.getEmail(),UserRequest.getPassword());
	   if(UserExist.isPresent()) {
		   throw new UserExists(Constants.USER_ALREADY_EXISTS);
	   }
	   else {
	   User user=new User();
	   BeanUtils.copyProperties(UserRequest, user);
	   
	   user=userRepository.save(user);
	   
	   UserResponse userResponse =new UserResponse();
	   BeanUtils.copyProperties(user, userResponse);
	   return userResponse;
	   }
	 
   }

@Override
public List<UserResponse> findAll() {
	return  userRepository.findAll().stream().map(this::convertEntityToResponse ).collect(Collectors.toList());
	
//	 List<User> user= userRepository.findAll() ;
//	 List<UserResponse> userrespo=new ArrayList<UserResponse>();
//	 for(User u:user) {
//		 UserResponse userResponse=new UserResponse();
//		 BeanUtils.copyProperties(u, userrespo);
//		 userrespo.add(userResponse);
//		 
//	 }
//	 return userrespo;
	 
	}
 

public UserResponse findById(long id) {
	User user=userRepository.findById(id).orElseThrow(()->new NoSuchId(Constants.INVALID_ID));
	return convertEntityToResponse(user);
}

@Override
public UserResponse findByEmailAndPassword(String email,String password) {
	User user=userRepository.findByEmailAndPassword(email,password).orElseThrow(()->new NoEmailAndPassword(Constants.INAVLID_CREDENTIALS));
	return convertEntityToResponse(user);
}
@Override
  public void deleteById(Long id) {
	 userRepository.deleteById(id);
  }
public List<OrderResponse> getUserOrders(String email, String password) {
    UserResponse userResponse = findByEmailAndPassword(email, password);
    
    	
        String url = "http://localhost:8080/orders/userId/" + userResponse.getId();
        ResponseEntity<List<OrderResponse>> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<OrderResponse>>() {}
        );
        
        return response.getBody();
    
}
   public UserResponse convertEntityToResponse(User user) {
	   UserResponse userResponse=new UserResponse();
	   BeanUtils.copyProperties(user, userResponse);
	   return userResponse;
   }
  
}
