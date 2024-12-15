package com.example.demo.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTagsRequest {
	
	private Integer tagId;
	private int customerId;
	private String tagName;
	private Date createdAt;

}
