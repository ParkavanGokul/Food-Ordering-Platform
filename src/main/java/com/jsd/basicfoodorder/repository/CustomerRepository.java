package com.jsd.basicfoodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsd.basicfoodorder.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
