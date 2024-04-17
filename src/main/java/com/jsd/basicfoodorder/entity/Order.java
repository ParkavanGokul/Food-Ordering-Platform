package com.jsd.basicfoodorder.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column
    private LocalDateTime dateTime;
    @Column
    private String status;
    @Column
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Food> foods;
    
    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    																									// Getters and Setters

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Long getOrderId() {
		return orderId;
	}
    																									// Constructors

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(LocalDateTime dateTime, String status, double totalPrice, Customer customer, List<Food> foods,
			Cart cart) {
		super();
		this.dateTime = dateTime;
		this.status = status;
		this.totalPrice = totalPrice;
		this.customer = customer;
		this.foods = foods;
		this.cart = cart;
	}
    
	
}
