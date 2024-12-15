package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDetailsDTO;

@Service("CustomerInfoService")
public interface CustomerInfoService {

	List<CustomerDetailsDTO> findCustomerDetails() throws Exception;

}
