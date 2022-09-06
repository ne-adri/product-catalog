package com.product.DTO;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.product.entity.Product;

public class TagDto {
	
	private int tagId;
	private String tagName;
	
	@JsonIgnore
	private Set<Product> products;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public int getTagId() {
		return tagId;
	}
	
	

}
