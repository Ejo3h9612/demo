package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Customer_tags")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTagsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id")
	private Integer tagId;
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "tag_name")
	private String tagName;
	
	@Column(name = "created_at")
	private Date createdAt;

}
