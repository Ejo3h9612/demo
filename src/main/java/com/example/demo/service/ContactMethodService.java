package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ContactMethodsEntity;
import com.example.demo.request.ContactMethodsRequest;

@Service
public interface ContactMethodService {

	List<ContactMethodsEntity> getContactMethodsByCustomerId(int methodId);

	ResponseEntity<ContactMethodsEntity> getContactMethod(int methodId);

	ResponseEntity<ContactMethodsEntity> addContactMethod(ContactMethodsRequest contactMethodsRequest);
	
	ResponseEntity<ContactMethodsEntity> updateContactMethod(int methodId, ContactMethodsRequest contactMethodsRequest);
	
	ResponseEntity<Void> deleteContactMethod(int methodId);
	
}
