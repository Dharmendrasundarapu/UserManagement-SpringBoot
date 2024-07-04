package com.pro1.UserManagementservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro1.UserManagementservice.Entity.User;
import com.pro1.UserManagementservice.dto.response.UserResponse;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

}
