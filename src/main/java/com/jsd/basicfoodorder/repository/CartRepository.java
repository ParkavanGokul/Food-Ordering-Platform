package com.jsd.basicfoodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsd.basicfoodorder.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    
}
