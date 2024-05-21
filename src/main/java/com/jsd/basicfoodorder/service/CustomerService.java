package com.jsd.basicfoodorder.service;

import java.util.List;
//import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.jsd.basicfoodorder.entity.Cart;
import com.jsd.basicfoodorder.entity.Customer;
import com.jsd.basicfoodorder.entity.Food;
import com.jsd.basicfoodorder.entity.Order;

@Component
public interface CustomerService {
																							//Customer actions on Customer entity
    Customer addCustomer(Customer customer);
    Customer getCustomerById(Long cutomerId);
    Customer updateCustomerById(Long cutomerId, Customer customer);
    void removeCustomerById(Long customerId);
    
    																						//Customer actions on Food entity
    List<Food> getAllFoods();
    Optional<Food> getFoodById(Long foodId);
    
    																						//Customer actions on Cart entity
    Cart addFoodToCart(Long customerId, Long foodId, int quantity);							//need review.Changed from void to Cart type
    List<Food> getAllFoodsInCart(Long customerId);								
//void setQuantityOfEachFoods(Long customerId, int foodQuantity);
    void removeFoodFromCart(Long customerId, Long foodId);
    																						//Customer actions on Order entity
    Order placeOrder(Long customerId);
// List<Order> viewAllMyOrders(Long customerId);
    Order viewOrderById(Long customerId, Long orderId);
    void cancelOrderById(Long customerId, Long orderId);
}


/*
public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer getCustomerById(Long id);
    Customer updateCustomerById(Long id, Customer customerDetails);
    void removeCustomerById(Long id);
    List<Customer> getAllCustomers();
    
    List<Food> getAllFoodsForCustomer(Long customerId);
    Cart addFoodToCart(Long customerId, Long foodId, int quantity);
    List<Food> getAllFoodsInCart(Long customerId);
    void setQuantityOfEachFoods(Long customerId, Map<Long, Integer> foodQuantityMap);
    void removeFoodFromCart(Long customerId, Long foodId);
    
    Order placeOrder(Long customerId);
    List<Order> viewAllMyOrders(Long customerId);
    Order viewOrderById(Long customerId, Long orderId);
    void cancelOrderById(Long customerId, Long orderId);
}
*/
