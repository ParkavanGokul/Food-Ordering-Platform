package com.jsd.basicfoodorder.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column
    private String name;
    @Column
    private String mobileNumber;
    @Column
    private String password;
    @Column
    private String address;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;
    
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Cart cart;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Food> foods;
    
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
    
    																									// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Long getCustomerId() {
		return customerId;
	}
																													//Constructors
	public Customer(String name, String mobileNumber, String password, String address, List<Order> orders, Cart cart,
			List<Food> foods, Admin admin) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.address = address;
		this.orders = orders;
		this.cart = cart;
		this.foods = foods;
		this.admin = admin;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
