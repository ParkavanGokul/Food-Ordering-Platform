package com.jsd.basicfoodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsd.basicfoodorder.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    
}
