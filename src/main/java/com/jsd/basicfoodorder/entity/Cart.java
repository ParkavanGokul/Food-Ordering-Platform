package com.jsd.basicfoodorder.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
// import java.util.Map;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @Column(nullable = false)
    private double totalPrice;
    @Column(nullable = false)
    private int quantity;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Food> foods;
    
    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private Order order;
    
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<FoodItem> foodItems = new ArrayList<>(); 
    
    public double calculateTotalPrice() {
        totalPrice = 0.0;
        if (foods != null) {
            for (Food food : foods) {
                totalPrice += food.getPrice();
            }
        }
        return totalPrice;
    }
    
    public void addFood(Food food, int quantity) {
        boolean foodExists = false;
        
        // Check if the food already exists in the cart
        for (FoodItem item : foodItems) {
            if (item.getFood().equals(food)) {
                item.setQuantity(item.getQuantity() + quantity);
                foodExists = true;
                break;
            }
        }
        
        // If food doesn't exist in the cart, add a new FoodItem
        if (!foodExists) {
            FoodItem foodItem = new FoodItem(food, quantity);
            foodItem.setCart(this);  // Set the cart for the FoodItem
            foodItems.add(foodItem);
        }
    }

    public void removeFood(Food food, int quantity) {
        for (FoodItem item : new ArrayList<>(foodItems)) {  // Use a new ArrayList to avoid ConcurrentModificationException
            if (item.getFood().equals(food)) {
                int newQuantity = item.getQuantity() - quantity;
                
                // If new quantity is less than or equal to 0, remove the food item
                if (newQuantity <= 0) {
                    foodItems.remove(item);
                } else {
                    item.setQuantity(newQuantity);
                }
                break;
            }
        }
    }
    
    																								// Getters and Setters
    public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Long getCartId() {
		return cartId;
	}
																											// Constructors
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public Cart(double totalPrice, int quantity, Customer customer, List<Food> foods, Order order,
			List<FoodItem> foodItems) {
		super();
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.customer = customer;
		this.foods = foods;
		this.order = order;
		this.foodItems = foodItems;
	}
	
	
}
