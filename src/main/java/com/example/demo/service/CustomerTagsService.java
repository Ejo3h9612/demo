package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerTagsEntity;
import com.example.demo.request.CustomerTagsRequest;

@Service("CustomerTagsService")
public interface CustomerTagsService {

	List<CustomerTagsEntity> getCustomerTagsByCustomerId(int tagid);

	ResponseEntity<CustomerTagsEntity> getCustomerTag(int tagid);

	ResponseEntity<CustomerTagsEntity> addCustomerTag(CustomerTagsRequest customerTagsRequest);
	
	ResponseEntity<CustomerTagsEntity> updateCustomerTag(int tagid, CustomerTagsRequest customerTagsRequest);
	
	ResponseEntity<Void> deleteCustomerTag(int tagid);
}
