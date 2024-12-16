package com.example.demo.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ContactMethodsEntity;
import com.example.demo.mapper.ContactMethodsMapper;
import com.example.demo.repository.ContactMethodsRepository;
import com.example.demo.request.ContactMethodsRequest;
import com.example.demo.service.ContactMethodService;

@Service
public class ContactMethodServiceImpl implements ContactMethodService {

	private ContactMethodsRepository contactMethodsRepository;

    private ContactMethodsMapper contactMethodsMapper;
	
    ContactMethodServiceImpl(ContactMethodsRepository contactMethodsRepository, ContactMethodsMapper contactMethodsMapper) {
    	this.contactMethodsRepository = contactMethodsRepository;
    	this.contactMethodsMapper = contactMethodsMapper;
    }
    
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
	public ResponseEntity<ContactMethodsEntity> addContactMethod(ContactMethodsRequest contactMethodsRequest) {
		
		ContactMethodsEntity contactMethodsEntity = contactMethodsMapper.toEntity(contactMethodsRequest);
		if (contactMethodsEntity.getCustomerId() <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        ContactMethodsEntity savedContactMethod = contactMethodsRepository.save(contactMethodsEntity);
        return new ResponseEntity<>(savedContactMethod, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ContactMethodsEntity> updateContactMethod(int methodId, ContactMethodsRequest contactMethodsRequest) {
		
		ContactMethodsEntity contactMethodsEntity = contactMethodsMapper.toEntity(contactMethodsRequest);

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
