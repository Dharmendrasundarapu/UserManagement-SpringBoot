package com.pro1.UserManagementservice.Service;

import java.util.List;

import com.pro1.UserManagementservice.Entity.User;
import com.pro1.UserManagementservice.dto.request.UserRequest;
import com.pro1.UserManagementservice.dto.response.UserResponse;

public interface UserService {
	
	 public UserResponse save(UserRequest UserRequest);
	 public List<UserResponse> findAll();
     public UserResponse findByEmail(String email);
     public void deleteById(long id);
}
