package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ContactMethodsEntity;

@Service("ContactMethodService")
public interface ContactMethodService {

	List<ContactMethodsEntity> getContactMethodsByCustomerId(int methodId);

	ResponseEntity<ContactMethodsEntity> getContactMethod(int methodId);

	ResponseEntity<ContactMethodsEntity> addContactMethod(ContactMethodsEntity contactMethodsEntity);
	
	ResponseEntity<ContactMethodsEntity> updateContactMethod(int methodId, ContactMethodsEntity contactMethodsEntity);
	
	ResponseEntity<Void> deleteContactMethod(int methodId);
	
}
