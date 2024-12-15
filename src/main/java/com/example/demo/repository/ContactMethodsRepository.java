package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ContactMethodsEntity;

public interface ContactMethodsRepository extends JpaRepository<ContactMethodsEntity, Integer> {

	List<ContactMethodsEntity> findByCustomerId(int customerId);
}
