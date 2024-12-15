package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDetailsDTO;
import com.example.demo.service.CustomerInfoService;

@RestController
@RequestMapping("/api/customerInfo")
public class CustomerInfoController {

    @Autowired
    private CustomerInfoService customerInfoService;
    
    @GetMapping
    public List<CustomerDetailsDTO> getAllUsers() throws Exception{
    	return customerInfoService.findCustomerDetails();
    }

}