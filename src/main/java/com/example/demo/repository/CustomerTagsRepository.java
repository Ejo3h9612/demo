package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CustomerTagsEntity;

public interface CustomerTagsRepository  extends JpaRepository<CustomerTagsEntity, Integer> {

	List<CustomerTagsEntity> findByCustomerId(int customerId);
}
