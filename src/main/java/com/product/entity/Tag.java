package com.product.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Tag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tag_id")
	private int tagId;
	
	
//	@ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "tags")
//	private Set<Product> products = new HashSet<>();
	
	private String tagName;

	public int getTagId() {
		return tagId;
	}

//	public Set<Product> getProduct() {
//		return products;
//	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	
}
