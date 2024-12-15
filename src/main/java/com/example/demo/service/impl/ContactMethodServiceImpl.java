package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ContactMethodsEntity;
import com.example.demo.repository.ContactMethodsRepository;
import com.example.demo.service.ContactMethodService;

@Service("ContactMethodService")
public class ContactMethodServiceImpl implements ContactMethodService {

	@Autowired
	private ContactMethodsRepository contactMethodsRepository;

	@Override
	public List<ContactMethodsEntity> getContactMethodsByCustomerId(int methodId) {
		return contactMethodsRepository.findByCustomerId(methodId);
	}

	@Override
	public ResponseEntity<ContactMethodsEntity> getContactMethod(int methodId) {
		return contactMethodsRepository.findById(methodId)
				.map(contact -> new ResponseEntity<>(contact, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@Override
	public ResponseEntity<ContactMethodsEntity> addContactMethod(ContactMethodsEntity contactMethodsEntity) {
		if (contactMethodsEntity.getCustomerId() <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 必須提供有效的 customerId
        }
        
        ContactMethodsEntity savedContactMethod = contactMethodsRepository.save(contactMethodsEntity);
        return new ResponseEntity<>(savedContactMethod, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ContactMethodsEntity> updateContactMethod(int methodId, ContactMethodsEntity contactMethodsEntity) {
		return contactMethodsRepository.findById(methodId)
                .map(existingContact -> {
                    existingContact.setMethodType(contactMethodsEntity.getMethodType());
                    existingContact.setDetail(contactMethodsEntity.getDetail());
                    existingContact.setPrimary(contactMethodsEntity.isPrimary());
                    ContactMethodsEntity updatedContact = contactMethodsRepository.save(existingContact);
                    return new ResponseEntity<>(updatedContact, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@Override
	public ResponseEntity<Void> deleteContactMethod(int methodId) {
		return contactMethodsRepository.findById(methodId)
                .map(contact -> {
                    contactMethodsRepository.delete(contact);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
