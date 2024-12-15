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
@Table(name = "Contact_methods")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactMethodsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "method_id")
	private Integer methodId;
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "method_type")
	private String methodType;
	
	@Column(name = "detail")
	private String detail;
	
	@Column(name = "is_primary")
	private boolean isPrimary;
	
	@Column(name = "updated_at")
	private Date updatedAt;

}
