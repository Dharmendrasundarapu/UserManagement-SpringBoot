package com.pro1.UserManagementservice.dto.request;

public class UserRequest {
	Long id;
	String name;
	String password;
	String email;
	String dob;

	
public UserRequest() {
	
		
	}

	public UserRequest(Long id,String name,String password,String email,String dob ) {
		this.id=id;
		this.name=name;
		this.password=password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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




