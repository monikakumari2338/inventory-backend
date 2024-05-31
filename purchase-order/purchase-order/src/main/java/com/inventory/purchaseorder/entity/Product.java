package com.inventory.purchaseorder.entity;

import jakarta.persistence.CascadeType;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="products_db")
public class Product {

	@Id
	private String itemNumber;
	private String itemName;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", referencedColumnName = "categoryId")
	private Category category;

	public String getitemName() {
		return itemName;
	}

	public void setitemName(String productName) {
		this.itemName = productName;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public Product(String itemNumber, String itemName, Category category) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [itemNumber=" + itemNumber + ", itemName=" + itemName + ", category=" + category + "]";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
