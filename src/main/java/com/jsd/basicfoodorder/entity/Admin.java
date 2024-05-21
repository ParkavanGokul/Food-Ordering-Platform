package com.jsd.basicfoodorder.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    @Column(nullable = false, length = 24)
    private String username;
    @Column(nullable = false, length = 32)
    private String password;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Customer> customers;
    
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Food> foods;
    																								// Getters and Setters
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Long getAdminId() {
		return adminId;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	
																											//Constructors
	public Admin(String username, String password, List<Customer> customers, List<Food> foods) {
		super();
		this.username = username;
		this.password = password;
		this.customers = customers;
		this.foods = foods;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	
}

