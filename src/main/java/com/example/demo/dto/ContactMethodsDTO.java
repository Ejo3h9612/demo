package com.example.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactMethodsDTO {

	private Integer methodId;
	private int customerId;
	private String methodType;
	private String detail;
	private boolean isPrimary;
	private Date updatedAt;

}
