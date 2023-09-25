package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String username;

	private String password;
	private boolean admin;
	private String email;
	private String nameOnCard;
	private String cardNumber;
	private int cvv;
	private String address;

	@JsonProperty(access = Access.AUTO)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Category> catagories;

	@JsonProperty(access = Access.AUTO)
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "user")
	private List<Cart> carts;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, boolean admin, String email, String nameOnCard, String cardNumber,
			int cvv, String address, List<Category> catagories, List<Cart> carts) {
		super();
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.email = email;
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.address = address;
		this.catagories = catagories;
		this.carts = carts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Category> getCatagories() {
		return catagories;
	}

	public void setCatagories(List<Category> catagories) {
		this.catagories = catagories;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", admin=" + admin + ", email="
				+ email + ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", address="
				+ address + ", catagories=" + catagories + ", carts=" + carts + "]";
	}

	public void addCategoryToUser(Category category) {
		if (getCatagories() == null) {
			this.catagories = new ArrayList<>();
		}
		getCatagories().add(category);
		category.setUser(this);
	}

	public void addCartToUser(Cart cart) {
		if (getCarts() == null) {
			this.carts = new ArrayList<>();
		}
		getCarts().add(cart);
		cart.setUser(this);
	}

	public void removeFromCart(Cart cart) {
		if (getCarts() != null) {
			getCarts().remove(cart);
		}
	}

}
