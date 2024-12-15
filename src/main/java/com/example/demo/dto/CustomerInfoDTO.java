package com.example.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfoDTO {

	private int customerId;
	private String customerTaxId;
	private String customerName;
	private Date createDat;
	private Date updateDat;

}
