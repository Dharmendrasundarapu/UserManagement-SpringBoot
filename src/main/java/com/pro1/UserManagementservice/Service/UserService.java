package com.pro1.UserManagementservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.pro1.UserManagementservice.Entity.User;
import com.pro1.UserManagementservice.dto.request.UserRequest;
import com.pro1.UserManagementservice.dto.response.UserResponse;

public interface UserService {
	
	 public UserResponse save(UserRequest UserRequest);
	 public List<UserResponse> findAll();
	 public UserResponse findById(long id);
     public UserResponse findByEmailAndPassword(String email,String password);
     public void deleteById(Long id);
}
