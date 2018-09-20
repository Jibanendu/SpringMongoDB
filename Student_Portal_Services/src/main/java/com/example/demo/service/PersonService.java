package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.utility.EncryptDecryptUtility;

@Service
public class PersonService {
   
	@Autowired
	private PersonRepository personRepository;
	
	//Create User
	public Person create(String emailAdress,String password, String role) {
		EncryptDecryptUtility encrypt = new EncryptDecryptUtility();
		String encryptPassword = encrypt.encrypt(password);
		return personRepository.save(new Person(emailAdress, encryptPassword, role));
	}
	
	public Person getByEmailAddress(String emailAddress) {
	return personRepository.findByEmailAddress(emailAddress);
 }
}
