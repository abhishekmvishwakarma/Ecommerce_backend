package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="categoires")
public class Category
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@JsonBackReference(value="user")
	@ManyToOne
	private User user;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany
	private List<Product> products;

	

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(long id, String name, User user, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.products = products;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", user=" + user + ", products=" + products + "]";
	}

	public void addProductToCategory(Product product) {
		if (getProducts()==null) {
			this.products = new ArrayList<>();
		}
		getProducts().add(product);
		product.setCategory(this);
	}
	

}
