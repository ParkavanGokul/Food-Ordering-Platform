package com.jsd.basicfoodorder.controller;

import com.jsd.basicfoodorder.entity.Cart;
import com.jsd.basicfoodorder.entity.Customer;
import com.jsd.basicfoodorder.entity.Food;
import com.jsd.basicfoodorder.entity.Order;
import com.jsd.basicfoodorder.serviceimplementation.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return ResponseEntity.ok(newCustomer);
    }

    @GetMapping("/getCustomer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable Long customerId, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomerById(customerId, customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/removeCustomer/{customerId}")
    public ResponseEntity<Void> removeCustomerById(@PathVariable Long customerId) {
        customerService.removeCustomerById(customerId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllFoods")
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> foods = customerService.getAllFoods();
        return ResponseEntity.ok(foods);
    }

    @PostMapping("/addFoodToCart/{customerId}/{foodId}/{quantity}")
    public ResponseEntity<Cart> addFoodToCart(@PathVariable Long customerId, @PathVariable Long foodId, @PathVariable int quantity) {
        Cart cart = customerService.addFoodToCart(customerId, foodId, quantity);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/removeFoodFromCart/{customerId}/{foodId}")
    public ResponseEntity<Void> removeFoodFromCart(@PathVariable Long customerId, @PathVariable Long foodId) {
        customerService.removeFoodFromCart(customerId, foodId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/placeOrder/{customerId}")
    public ResponseEntity<Order> placeOrder(@PathVariable Long customerId) {
        Order order = customerService.placeOrder(customerId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/viewOrder/{customerId}/{orderId}")
    public ResponseEntity<Order> viewOrderById(@PathVariable Long customerId, @PathVariable Long orderId) {
        Order order = customerService.viewOrderById(customerId, orderId);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/cancelOrder/{customerId}/{orderId}")
    public ResponseEntity<Void> cancelOrderById(@PathVariable Long customerId, @PathVariable Long orderId) {
        customerService.cancelOrderById(customerId, orderId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getFoodById/{foodId}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long foodId) {
        Optional<Food> food = customerService.getFoodById(foodId);
        return food.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getAllFoodsInCart/{customerId}")
    public ResponseEntity<List<Food>> getAllFoodsInCart(@PathVariable Long customerId) {
        List<Food> foods = customerService.getAllFoodsInCart(customerId);
        return ResponseEntity.ok(foods);
    }
}

