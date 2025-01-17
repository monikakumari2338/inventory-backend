package com.inventory.product.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	@Size(min=1, max=20)
	@NotBlank
	private String category;
	@Size(min=1, max=100)
	@NotBlank
	private String location;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Category(int categoryId, String category, String location) {
		super();
		this.categoryId = categoryId;
		this.category = category;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", category=" + category + "]";
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

}
