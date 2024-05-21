package com.jsd.basicfoodorder.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;
    @Column(nullable = false, length = 24)
    private String name;
    @Column(nullable = false)
    private double price;
    
    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<FoodItem> foodItems;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    																								// Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Long getFoodId() {
		return foodId;
	}
	
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}
	
																											// Constructors

	public Food(Food food, int quantity) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(String name, double price, List<FoodItem> foodItems, Admin admin, Customer customer, Cart cart,
			Order order) {
		super();
		this.name = name;
		this.price = price;
		this.foodItems = foodItems;
		this.admin = admin;
		this.customer = customer;
		this.cart = cart;
		this.order = order;
	}
	
	
	
}
