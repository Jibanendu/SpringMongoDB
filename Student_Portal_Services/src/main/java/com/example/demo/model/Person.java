package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
	@Id
	String id;
	String emailAddress;
	String password;
	String role;
	
	public Person() {
		super();
	}

	public Person(String emailAddress, String password, String role) {
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
		return "Person [id=" + id + ", emailAddress=" + emailAddress
				+ ", password=" + password + ", role=" + role + "]";
	}
	
	
}
