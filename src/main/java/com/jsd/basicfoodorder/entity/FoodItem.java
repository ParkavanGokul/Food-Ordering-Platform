package com.jsd.basicfoodorder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FoodItem {
	@Id
	private Long foodItemId;
    // private Food food;
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    public FoodItem(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    // getters and setters
    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public FoodItem() {
    }

    // Getter and Setter for Cart
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

	public Long getFoodItemId() {
		return foodItemId;
	}

	public FoodItem(int quantity, Cart cart, Food food) {
		super();
		this.quantity = quantity;
		this.cart = cart;
		this.food = food;
	}
    
}
