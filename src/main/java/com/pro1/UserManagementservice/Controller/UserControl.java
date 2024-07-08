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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro1.UserManagementservice.Applicationconstants.Constants;
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
	    return  "Registartion Success";
	}
     @GetMapping
     public List<UserResponse> findAll(){
    	 return userService.findAll();
     }
     @PostMapping("/login")
     public String Login( @RequestParam("email")  String email,@RequestParam("password") String password) {
    		userService.findByEmailAndPassword(email,password);
    	    return  "Login Success";
     }
     @PutMapping
     public String updateUserDetails(@RequestBody UserRequest userRequest) {
         userService.save(userRequest);
         return "Updated successfully";
     }
     @DeleteMapping("/{id}")
     public String deleteById(@PathVariable Long id) {
    	 UserResponse userResponse=userService.findById(id);
    	 userService.deleteById(id);
    	 return "SuccessFully Deleted";
    	 
     }
}
