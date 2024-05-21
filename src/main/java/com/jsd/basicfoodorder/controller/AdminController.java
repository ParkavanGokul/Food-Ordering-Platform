package com.jsd.basicfoodorder.controller;

import com.jsd.basicfoodorder.entity.Admin;
import com.jsd.basicfoodorder.entity.Customer;
import com.jsd.basicfoodorder.entity.Food;
import com.jsd.basicfoodorder.entity.Order;
import com.jsd.basicfoodorder.serviceimplementation.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/addAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        Admin newAdmin = adminService.addAdmin(admin);
        return ResponseEntity.ok(newAdmin);
    }

    @GetMapping("/getAdmin/{adminId}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long adminId) {
        Admin admin = adminService.getAdminById(adminId);
        return ResponseEntity.ok(admin);
    }

    @PutMapping("/updateAdmin/{adminId}")
    public ResponseEntity<Admin> updateAdminById(@PathVariable Long adminId, @RequestBody Admin admin) {
        Admin updatedAdmin = adminService.updateAdminById(adminId, admin);
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("/removeAdmin/{adminId}")
    public ResponseEntity<Void> removeAdminById(@PathVariable Long adminId) {
        adminService.removeAdminById(adminId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = adminService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/getCustomer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer customer = adminService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/removeCustomer/{customerId}")
    public ResponseEntity<Void> removeCustomerById(@PathVariable Long customerId) {
        adminService.removeCustomerById(customerId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllFoods")
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> foods = adminService.getAllFoods();
        return ResponseEntity.ok(foods);
    }

    @PostMapping("/addFood")
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        Food newFood = adminService.addFood(food);
        return ResponseEntity.ok(newFood);
    }

    @GetMapping("/getFood/{foodId}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long foodId) {
        Food food = adminService.getFoodById(foodId);
        return ResponseEntity.ok(food);
    }

    @PutMapping("/updateFood/{foodId}")
    public ResponseEntity<Food> updateFoodById(@PathVariable Long foodId, @RequestBody Food food) {
        Food updatedFood = adminService.updateFoodById(foodId, food);
        return ResponseEntity.ok(updatedFood);
    }

    @DeleteMapping("/removeFood/{foodId}")
    public ResponseEntity<Void> removeFoodById(@PathVariable Long foodId) {
        adminService.removeFoodById(foodId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> order = adminService.getAllOrders();
        return ResponseEntity.ok(order);
    }

    @GetMapping("/getOrder/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Order order = adminService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    /* @DeleteMapping("/removeOrder/{orderId}")
    public ResponseEntity<Void> removeOrderById(@PathVariable Long orderId) {
        adminService.removeOrderById(orderId);
        return ResponseEntity.ok().build();
    }
    */
}
