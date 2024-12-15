package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerTagsEntity;

@Service("CustomerTagsService")
public interface CustomerTagsService {

	List<CustomerTagsEntity> getCustomerTagsByCustomerId(int tagid);

	ResponseEntity<CustomerTagsEntity> getCustomerTag(int tagid);

	ResponseEntity<CustomerTagsEntity> addCustomerTag(CustomerTagsEntity customerTagsEntity);
	
	ResponseEntity<CustomerTagsEntity> updateCustomerTag(int tagid, CustomerTagsEntity customerTagsEntity);
	
	ResponseEntity<Void> deleteCustomerTag(int tagid);
}
