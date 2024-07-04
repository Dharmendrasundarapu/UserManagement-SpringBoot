package com.pro1.UserManagementservice.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pro1.UserManagementservice.Entity.User;
import com.pro1.UserManagementservice.dto.request.UserRequest;
import com.pro1.UserManagementservice.dto.response.UserResponse;
import com.pro1.UserManagementservice.handler.NoSuchId;
import com.pro1.UserManagementservice.handler.ResourceNotAvailableException;
import com.pro1.UserManagementservice.repo.UserRepository;

@Service
public  class UserService1 implements UserService  {
	
   @Autowired
  private UserRepository userRepository;
   
   public UserResponse save(UserRequest UserRequest) {
	   User user=new User();
	   BeanUtils.copyProperties(UserRequest, user);
	   user=userRepository.save(user);
	   
	   UserResponse userResponse =new UserResponse();
	   BeanUtils.copyProperties(user, userResponse);
	   return userResponse;
	 
   }

@Override
public List<UserResponse> findAll() {
	List<User> user=userRepository.findAll();
	List<UserResponse> userRespo=new ArrayList<UserResponse>();
	for(User users:user) {
		 UserResponse userResponse =new UserResponse();
		 BeanUtils.copyProperties(users, userResponse);
		 userRespo.add(userResponse);
	}
	return userRespo ;
}
public UserResponse findById(long id) {
	User user=new User();
	Optional<User> userOpt=userRepository.findById(id);
	if(userOpt.isPresent())
	{
		user=userOpt.get();
	}
	else
	{
		throw new NoSuchId("No such Id");
	}
	return convertEntityToResponse(user);
}

@Override
public UserResponse findByEmail(String email) {
	User user=null;
	Optional<User> userOpt=userRepository.findByEmail(email);
	if(userOpt.isPresent()) {
		user=userOpt.get();
	}
	else {
		throw new ResourceNotAvailableException("Resource not available");
	}
	return convertEntityToResponse(user);
}

@Override
  public void deleteById(Long id) {
	 userRepository.deleteById(id);
  }
   public UserResponse convertEntityToResponse(User user) {
	   UserResponse userResponse=new UserResponse();
	   BeanUtils.copyProperties(user, userResponse);
	   return userResponse;
   }
  
}
