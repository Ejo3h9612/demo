package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CustomerTagsEntity;
import com.example.demo.request.CustomerTagsRequest;
import com.example.demo.service.CustomerTagsService;

@RestController
@RequestMapping("/api/customerTags")
public class CustomerTagsController {

    @Autowired
    private CustomerTagsService customerTagsService;
    
    // 查詢所有標籤 (根據 customerId)
    @GetMapping("/customer/{customerId}")
    public List<CustomerTagsEntity> getCustomerTagsByCustomerId(@PathVariable int customerId) {
        return customerTagsService.getCustomerTagsByCustomerId(customerId);
    }

    // 查詢單一標籤 (根據 methodId)
    @GetMapping("/{methodId}")
    public ResponseEntity<CustomerTagsEntity> getCustomerTag(@PathVariable int methodId) {
        return customerTagsService.getCustomerTag(methodId);
    }

    // 新增標籤
    @PostMapping
    public ResponseEntity<CustomerTagsEntity> addCustomerTag(@RequestBody CustomerTagsRequest customerTagsRequest) {
        return customerTagsService.addCustomerTag(customerTagsRequest);
    }

    // 更新標籤
    @PutMapping("/{methodId}")
    public ResponseEntity<CustomerTagsEntity> updateCustomerTag(
            @PathVariable int methodId, 
            @RequestBody CustomerTagsRequest customerTagsRequest) {

        return customerTagsService.updateCustomerTag(methodId, customerTagsRequest);
    }

    // 刪除標籤
    @DeleteMapping("/{methodId}")
    public ResponseEntity<Void> deleteCustomerTag(@PathVariable int methodId) {
        return customerTagsService.deleteCustomerTag(methodId);
    }
}
