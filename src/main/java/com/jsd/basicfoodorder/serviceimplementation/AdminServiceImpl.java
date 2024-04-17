package com.jsd.basicfoodorder.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsd.basicfoodorder.entity.Admin;
import com.jsd.basicfoodorder.entity.Customer;
import com.jsd.basicfoodorder.entity.Food;
import com.jsd.basicfoodorder.entity.Order;
import com.jsd.basicfoodorder.exception.AdminNotFoundException;
import com.jsd.basicfoodorder.exception.CustomerNotFoundException;
import com.jsd.basicfoodorder.exception.FoodNotFoundException;
import com.jsd.basicfoodorder.exception.OrderNotFoundException;
import com.jsd.basicfoodorder.repository.AdminRepository;
import com.jsd.basicfoodorder.repository.CustomerRepository;
import com.jsd.basicfoodorder.repository.FoodRepository;
import com.jsd.basicfoodorder.repository.OrderRepository;
import com.jsd.basicfoodorder.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long adminId) {
        return adminRepository.findById(adminId).orElseThrow(() -> new AdminNotFoundException("Admin not found with id: " + adminId));
    }

    /*
    @Override
    public Admin updateAdminById(Long adminId, Admin admin) {
    	Admin a = adminRepository.findById(adminId).get();
    	a.setUsername(a.getUsername());
    	a.setPassword(a.getPassword());
        return adminRepository.save(a);
    }
    */
    
    @Override
    public Admin updateAdminById(Long adminId, Admin admin) {
        Admin existingAdmin = adminRepository.findById(adminId)
                .orElseThrow(() -> new AdminNotFoundException("Admin not found with id: " + adminId));
        existingAdmin.setUsername(admin.getUsername());
        existingAdmin.setPassword(admin.getPassword());
        return adminRepository.save(existingAdmin);
    }

    @Override
    public void removeAdminById(Long adminId) {
        adminRepository.deleteById(adminId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + customerId));
    }

    @Override
    public void removeCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food getFoodById(Long foodId) {
        return foodRepository.findById(foodId).orElseThrow(() -> new FoodNotFoundException("Food not found with id: " + foodId));
    }

    @Override
    public Food updateFoodById(Long foodId, Food food) {
    	Food f = foodRepository.findById(foodId).get();
    	f.setName(f.getName());
    	f.setPrice(f.getPrice());
        return foodRepository.save(f);
    }

    @Override
    public void removeFoodById(Long foodId) {
        foodRepository.deleteById(foodId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
    }

    /* @Override
    public void removeOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
    }
    */
}
