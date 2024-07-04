package com.pro1.UserManagementservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro1.UserManagementservice.Entity.User;
import com.pro1.UserManagementservice.Service.UserService;
import com.pro1.UserManagementservice.dto.request.UserRequest;
import com.pro1.UserManagementservice.dto.response.UserResponse;

@RestController
@RequestMapping("/reg")
public class UserControl {
	@Autowired
    private	UserService userService;
	
	@PostMapping
	public String Registration( @RequestBody UserRequest userRequest) {
	    userService.save(userRequest);
	    return "Registration Success";
	}
     @GetMapping
     public List<UserResponse> findAll(){
    	 return userService.findAll();
     }
     @GetMapping("/email/{email}/{password}")
     public ResponseEntity<?> findByEmail(@PathVariable String email,@PathVariable String password) {
    	 UserResponse userResponse=userService.findByEmail(email);
    	 if( userResponse.getPassword().equals(password)) {
    		 return  ResponseEntity.ok(userResponse);
    	 }
    	 else {
    		 return  ResponseEntity.status(401).body("Invalid credentials");
    	 }
     }
     @PutMapping
     public UserResponse updateUserDetails(@RequestBody UserRequest userRequest) {
    	return  userService.save(userRequest);
     }
     @DeleteMapping
     public String deleteById(long id) {
    	 userService.deleteById(id);
    	 return "Successfully deleted";
     }
}
