package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="carts")
public class Cart
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private double price;
	private int quantity;
	private String pitureUrl;
	
	@JsonBackReference(value="user")
	@ManyToOne
	private User user;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(String name, double price, int quantity, String pitureUrl, User user) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.pitureUrl = pitureUrl;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPitureUrl() {
		return pitureUrl;
	}

	public void setPitureUrl(String pitureUrl) {
		this.pitureUrl = pitureUrl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", pitureUrl="
				+ pitureUrl + ", user=" + user + "]";
	}
	
	
	
	

}
