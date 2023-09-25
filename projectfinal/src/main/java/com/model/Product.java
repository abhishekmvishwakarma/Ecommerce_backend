package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "products")
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String description;
	private double price;
	
	private String pitureUrl;
	
	@JsonBackReference(value = "category")
	@ManyToOne
	private Category category;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tag_products",joinColumns = @JoinColumn(name ="tag_id"),inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Tag> tags;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
	private List<Comment> comments;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, String description, double price, String pitureUrl, Category category,
			List<Tag> tags, List<Comment> comments) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.pitureUrl = pitureUrl;
		this.category = category;
		this.tags = tags;
		this.comments = comments;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPitureUrl() {
		return pitureUrl;
	}

	public void setPitureUrl(String pitureUrl) {
		this.pitureUrl = pitureUrl;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", pitureUrl=" + pitureUrl + ", category=" + category + ", tags=" + tags + ", comments=" + comments
				+ "]";
	}
	
	
	public void addCommentToProduct(Comment comment) {
		  if (getComments() == null) {
		   this.comments = new ArrayList<>();
		   }
		   getComments().add(comment);
		   comment.setProduct(this);
		 }

		 public void addTag(Tag tag) {
		  if (getTags() == null) {
			 this.tags = new ArrayList<>();
		    }
		  if (!getTags().contains(tag)) {
		     getTags().add(tag);
		   }
		 }
}
