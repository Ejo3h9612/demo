package com.example.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTagsDTO {
	
	private Integer tagId;
	private int customerId;
	private String tagName;
	private Date createdAt;

}
