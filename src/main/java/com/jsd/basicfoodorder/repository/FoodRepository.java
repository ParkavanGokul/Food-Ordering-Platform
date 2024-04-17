package com.jsd.basicfoodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsd.basicfoodorder.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
    
}
