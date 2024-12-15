package com.example.demo.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactMethodsRequest {

	private Integer methodId;
	private int customerId;
	private String methodType;
	private String detail;
	private boolean isPrimary;
	private Date updatedAt;

}
