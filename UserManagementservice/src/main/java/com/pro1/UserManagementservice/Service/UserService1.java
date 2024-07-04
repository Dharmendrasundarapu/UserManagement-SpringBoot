package com.pro1.UserManagementservice.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro1.UserManagementservice.Entity.User;
import com.pro1.UserManagementservice.dto.request.UserRequest;
import com.pro1.UserManagementservice.dto.response.UserResponse;
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

@Override
public UserResponse findByEmail(String email) {
	User user=userRepository.findByEmail(email);
	UserResponse userResponse=new UserResponse();
	BeanUtils.copyProperties(user, userResponse);
	return  userResponse;
}

@Override
  public void deleteById(long id) {
	 userRepository.deleteById(id);
  }


   
   
   
}
