package com.jsd.basicfoodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsd.basicfoodorder.entity.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long>{

}
