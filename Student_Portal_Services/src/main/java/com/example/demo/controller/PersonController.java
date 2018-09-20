package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.PersonRequest;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.example.utility.EncryptDecryptUtility;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(value ="/create",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody PersonRequest person) {
		
		Person p = personService.create(person.getEmailAddress(), person.getPassword(), person.getRole());
		return p;
	}
	
	@RequestMapping(value ="/login",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public PersonRequest login(@RequestBody PersonRequest person) {
		
		PersonRequest personRequest = new PersonRequest();
		Person p = personService.getByEmailAddress(person.getEmailAddress());
		if(p!=null)
		{
			String password= p.getPassword();
			EncryptDecryptUtility decryptUtil = new EncryptDecryptUtility();
			String decryptedPassword= decryptUtil.decrypt(password);
			String loginPassword = person.getPassword();
			if(loginPassword.equalsIgnoreCase(decryptedPassword))
			{
				personRequest.setEmailAddress(p.getEmailAddress());
				personRequest.setRole(p.getRole());
				return personRequest;
			}
			else
			{
				personRequest.setEmailAddress(person.getEmailAddress());
				personRequest.setPassword("Invalid Password");
				personRequest.setRole("");
				return personRequest;
			}
		}
		else
		{
			personRequest.setEmailAddress("Invalid Email");
			personRequest.setPassword("");
			personRequest.setRole("");
			return personRequest;
		}
		
		
	}
	
}
