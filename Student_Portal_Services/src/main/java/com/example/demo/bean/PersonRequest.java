package com.example.demo.bean;

public class PersonRequest {
	
	private String emailAddress;
	private String password;
	private String role;
	
	
	public PersonRequest() {
		super();
	}


	public PersonRequest(String emailAddress, String password, String role) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
		this.role = role;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "PersonRequest [emailAddress=" + emailAddress + ", password="
				+ password + ", role=" + role + "]";
	}

}
