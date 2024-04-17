package com.jsd.basicfoodorder.service;

import java.util.List;

import com.jsd.basicfoodorder.entity.Admin;
import com.jsd.basicfoodorder.entity.Customer;
import com.jsd.basicfoodorder.entity.Food;
import com.jsd.basicfoodorder.entity.Order;

public interface AdminService {
	
    Admin addAdmin(Admin admin);											//Admin's actions on Admin entity
    Admin getAdminById(Long adminId);
    Admin updateAdminById(Long adminId, Admin admin);
    void removeAdminById(Long adminId);
    
    List<Customer> getAllCustomers();										//Admin's actions on Cutomer entity
    Customer getCustomerById(Long customerId);
    void removeCustomerById(Long customerId);
    
    List<Food> getAllFoods();												//Admin's actions on Food entity
    Food addFood(Food food);
    Food getFoodById(Long foodId);
    Food updateFoodById(Long foodId, Food food);
    void removeFoodById(Long foodId);
    
    List<Order> getAllOrders();												//Admin's actions on Order entity
    Order getOrderById(Long orderId);
    //void removeOrderById(Long orderId);
}
