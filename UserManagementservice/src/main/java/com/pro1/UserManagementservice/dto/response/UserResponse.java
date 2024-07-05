package com.pro1.UserManagementservice.dto.response;

public class UserResponse {
	Long id;
	String name;
	String email;
	String dob;

	
public UserResponse() {
	
		
	}

	public UserResponse(Long id,String name,String email,String dob ) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.dob=dob;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getdob() {
		return dob;
	}

	public void setdob(String dob) {
		this.dob = dob;
	}
		
				
				
}






