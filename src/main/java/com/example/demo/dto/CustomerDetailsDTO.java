package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailsDTO {
	
    private Integer customerId;
    private String customerName;
    private String customerTaxId;
    private Integer methodId;
    private String methodType;
    private String contactDetail;
    private boolean isPrimary;
    private Integer tagId;
    private String tagName;
    
}

