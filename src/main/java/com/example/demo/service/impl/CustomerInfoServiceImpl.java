package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDetailsDTO;
import com.example.demo.repository.CustomerInfoRepository;
import com.example.demo.service.CustomerInfoService;

@Service("CustomerInfoService")
public class CustomerInfoServiceImpl implements CustomerInfoService {

	@Autowired
    private CustomerInfoRepository customerInfoRepository;
    
	
	@Override
	public List<CustomerDetailsDTO> findCustomerDetails() throws Exception {
		List<Object[]> results = customerInfoRepository.findCustomerDetails();
		
		 return results.stream().map(row -> new CustomerDetailsDTO(
			        ((Integer) row[0]).intValue(), // customerId
			        (String) row[1],                 // customerName
			        (String) row[2],                 // customerTaxId
			        null, 
			        (String) row[3],                 // methodType
			        (String) row[4],                 // contactDetail
			        row[5] != null ? (Boolean) row[5] : false,                // isPrimary
			        null, 
			        (String) row[6]                  // tagName
			    )).collect(Collectors.toList());
			}

}
