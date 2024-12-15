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

import com.example.demo.entity.ContactMethodsEntity;
import com.example.demo.request.ContactMethodsRequest;
import com.example.demo.service.ContactMethodService;

@RestController
@RequestMapping("/api/contactMethod")
public class ContactMethodController {

    @Autowired
    private ContactMethodService contactMethodService;
    
    // 查詢所有聯絡方式 (根據 customerId)
    @GetMapping("/customer/{customerId}")
    public List<ContactMethodsEntity> getContactMethodsByCustomerId(@PathVariable int customerId) {
        return contactMethodService.getContactMethodsByCustomerId(customerId);
    }

    // 查詢單一聯絡方式 (根據 methodId)
    @GetMapping("/{methodId}")
    public ResponseEntity<ContactMethodsEntity> getContactMethod(@PathVariable int methodId) {
        return contactMethodService.getContactMethod(methodId);
    }

    // 新增聯絡方式
    @PostMapping
    public ResponseEntity<ContactMethodsEntity> addContactMethod(@RequestBody ContactMethodsRequest contactMethodsRequest) {
        return contactMethodService.addContactMethod(contactMethodsRequest);
    }

    // 更新聯絡方式
    @PutMapping("/{methodId}")
    public ResponseEntity<ContactMethodsEntity> updateContactMethod(
            @PathVariable int methodId, 
            @RequestBody ContactMethodsRequest contactMethodsRequest) {

        return contactMethodService.updateContactMethod(methodId, contactMethodsRequest);
    }

    // 刪除聯絡方式
    @DeleteMapping("/{methodId}")
    public ResponseEntity<Void> deleteContactMethod(@PathVariable int methodId) {
        return contactMethodService.deleteContactMethod(methodId);
    }
}
