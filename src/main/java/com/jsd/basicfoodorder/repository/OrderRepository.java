package com.jsd.basicfoodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsd.basicfoodorder.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}

