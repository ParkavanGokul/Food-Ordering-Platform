package com.jsd.basicfoodorder.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsd.basicfoodorder.entity.Cart;
import com.jsd.basicfoodorder.entity.Customer;
import com.jsd.basicfoodorder.entity.Food;
import com.jsd.basicfoodorder.entity.Order;
import com.jsd.basicfoodorder.exception.CustomerNotFoundException;
import com.jsd.basicfoodorder.exception.FoodNotFoundException;
import com.jsd.basicfoodorder.exception.OrderNotFoundException;
import com.jsd.basicfoodorder.repository.CartRepository;
import com.jsd.basicfoodorder.repository.CustomerRepository;
import com.jsd.basicfoodorder.repository.FoodRepository;
import com.jsd.basicfoodorder.repository.OrderRepository;
import com.jsd.basicfoodorder.service.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + customerId));
    }

    /*
    @Override
    public Customer updateCustomerById(Long customerId, Customer customerDetails) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            customer.setName(customerDetails.getName());
            customer.setMobileNumber(customerDetails.getMobileNumber());
            customer.setPassword(customerDetails.getPassword());
            customer.setAddress(customerDetails.getAddress());
            return customerRepository.save(customer);
        }
        return null;
    }
    */
    
    @Override
    public Customer updateCustomerById(Long customerId, Customer customerDetails) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            customer.setName(customerDetails.getName());
            customer.setMobileNumber(customerDetails.getMobileNumber());
            customer.setPassword(customerDetails.getPassword());
            customer.setAddress(customerDetails.getAddress());
            return customerRepository.save(customer);
        }
        return null;
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
    public Cart addFoodToCart(Long customerId, Long foodId, int quantity) {
        Customer customer = getCustomerById(customerId);
        Food food = foodRepository.findById(foodId).orElse(null);
        if (customer != null && food != null) {
            Cart cart = customer.getCart();
            if (cart == null) {
                cart = new Cart();
                cart.setCustomer(customer);
            }
            cart.addFood(food, quantity);
            return cartRepository.save(cart);
        }
        return null;
    }

    @Override
    public void removeFoodFromCart(Long customerId, Long foodId) {
        Customer customer = getCustomerById(customerId);
        Food food = foodRepository.findById(foodId).orElse(null);
        if (customer != null && customer.getCart() != null && food != null) {
            customer.getCart().removeFood(food, 1); // Remove one unit of the food
            cartRepository.save(customer.getCart());
        }
    }

    
/*
    @Override
    public Cart addFoodToCart(Long customerId, Long foodId, int quantity) {
        Customer customer = getCustomerById(customerId);
        Food food = foodRepository.findById(foodId).orElse(null);
        if (customer != null && food != null) {
            Cart cart = customer.getCart();
            if (cart == null) {
                cart = new Cart();
                cart.setCustomer(customer);
            }
            cart.addFood(food, quantity);
            return cartRepository.save(cart);
        }
        return null;
    }  

    @Override
    public void setQuantityOfEachFoods(Long customerId, int foodQuantity) {
        Customer customer = getCustomerById(customerId);
        if (customer != null && customer.getCart() != null) {
            customer.getCart().setQuantity(foodQuantity);
            cartRepository.save(customer.getCart());
        }
    }

    @Override
    public void removeFoodFromCart(Long customerId, Long foodId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null && customer.getCart() != null) {
            customer.getCart().removeFood(foodId);
            cartRepository.save(customer.getCart());
        }
    }

   
    @Override
    public List<Order> viewAllMyOrders(Long customerId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            return orderRepository.findByCustomer(customer);
        }
        return null;
    }
*/

    @Override
    public Order viewOrderById(Long customerId, Long orderId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
        }
        return null;
    }

    @Override
    public void cancelOrderById(Long customerId, Long orderId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
            if (order != null) {
                orderRepository.delete(order);
            }
        }
    }

	@Override
	public Optional<Food> getFoodById(Long foodId) {
		return Optional.ofNullable(foodRepository.findById(foodId).orElseThrow(() -> new FoodNotFoundException("Food not found with id: " + foodId)));
	}

	@Override
    @Transactional
    public Order placeOrder(Long customerId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null && customer.getCart() != null) {
            Order order = new Order();
            order.setCustomer(customer);
            order.setFoods(customer.getCart().getFoods());
            order.setTotalPrice(customer.getCart().calculateTotalPrice());
            orderRepository.save(order);

            // Clear cart after placing order
            customer.setCart(null);
            customerRepository.save(customer);

            return order;
        }
        return null;
    }
	
	@Override
    public List<Food> getAllFoodsInCart(Long customerId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null && customer.getCart() != null) {
            return customer.getCart().getFoods();
        }
        return null;
    }
	
}

