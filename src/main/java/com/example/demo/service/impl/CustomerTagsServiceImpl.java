package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerTagsEntity;
import com.example.demo.mapper.CustomerTagsMapper;
import com.example.demo.repository.CustomerTagsRepository;
import com.example.demo.request.CustomerTagsRequest;
import com.example.demo.service.CustomerTagsService;

@Service("CustomerTagsService")
public class CustomerTagsServiceImpl implements CustomerTagsService {

	@Autowired
	private CustomerTagsRepository customerTagsRepository;

	@Autowired
	private CustomerTagsMapper customerTagsMapper;
	
	@Override
	public List<CustomerTagsEntity> getCustomerTagsByCustomerId(int tagid) {
		return customerTagsRepository.findByCustomerId(tagid);
	}

	@Override
	public ResponseEntity<CustomerTagsEntity> getCustomerTag(int tagid) {
		return customerTagsRepository.findById(tagid)
				.map(contact -> new ResponseEntity<>(contact, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@Override
	public ResponseEntity<CustomerTagsEntity> addCustomerTag(CustomerTagsRequest customerTagsRequest) {
		CustomerTagsEntity customerTagsEntity = customerTagsMapper.toEntity(customerTagsRequest);
		
		if (customerTagsEntity.getCustomerId() <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 必須提供有效的 customerId
        }
        
		CustomerTagsEntity savedContactMethod = customerTagsRepository.save(customerTagsEntity);
        return new ResponseEntity<>(savedContactMethod, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<CustomerTagsEntity> updateCustomerTag(int tagid, CustomerTagsRequest customerTagsRequest) {
		
		CustomerTagsEntity customerTagsEntity = customerTagsMapper.toEntity(customerTagsRequest);

		return customerTagsRepository.findById(tagid)
                .map(existingContact -> {
                    existingContact.setTagName(customerTagsEntity.getTagName());
                    CustomerTagsEntity updatedContact = customerTagsRepository.save(existingContact);
                    return new ResponseEntity<>(updatedContact, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@Override
	public ResponseEntity<Void> deleteCustomerTag(int tagid) {
		return customerTagsRepository.findById(tagid)
                .map(contact -> {
                	customerTagsRepository.delete(contact);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
