package com.product.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "product")
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prod_id")
	private int prodId;
	private String name;
	private long price;
	private int quantity;
	private String description;
	private String category;
	
	@ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
	@JoinTable(name = "product_tags",
			joinColumns = @JoinColumn(name="prod_id"),
			inverseJoinColumns = @JoinColumn(name="tag_id"))
	private Set<Tag> tags = new HashSet<>();
	
	public int getId() {
		return prodId;
	}
	
	public void setId(int id) {
		this.prodId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Set<Tag> getTags() {
		return tags;
	}
//	public void setTags(Set<Tag> tags) {
//		this.tags = tags;
//	}
	

	 
}
