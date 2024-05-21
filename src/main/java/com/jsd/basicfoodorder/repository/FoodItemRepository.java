package com.jsd.basicfoodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsd.basicfoodorder.entity.FoodItem;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long>{

}
