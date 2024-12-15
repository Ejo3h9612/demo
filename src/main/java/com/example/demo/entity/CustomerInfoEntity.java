package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "customer_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfoEntity {

	@Id
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "customer_tax_id")
	private String customerTaxId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "created_at")
	private Date createDat;
	
	@Column(name = "updated_at")
	private Date updateDat;

}
