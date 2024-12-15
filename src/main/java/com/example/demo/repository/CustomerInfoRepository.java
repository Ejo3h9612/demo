package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.CustomerInfoEntity;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfoEntity, Integer> {

	@Query(value = """
	        SELECT 
	            ci.customer_id AS customerId,
	            ci.customer_name AS customerName,
	            ci.customer_tax_id AS customerTaxId,
	            cm.method_type AS methodType,
	            cm.detail AS contactDetail,
	            cm.is_primary AS isPrimary,
	            ct.tag_name AS tagName
	        FROM 
	            customer_info ci
	        LEFT JOIN 
	            contact_methods cm ON ci.customer_id = cm.customer_id
	            AND cm.is_primary = true
	        LEFT JOIN 
	            customer_tags ct ON ci.customer_id = ct.customer_id
	            AND ct.created_at = (
	                SELECT MIN(created_at)
	                FROM customer_tags sub_ct
	                WHERE sub_ct.customer_id = ci.customer_id
	            )
	        ORDER BY 
	            ci.customer_id
	        """, nativeQuery = true)
		List<Object[]> findCustomerDetails();
}
