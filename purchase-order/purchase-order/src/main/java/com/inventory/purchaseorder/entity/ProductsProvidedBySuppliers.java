package com.inventory.purchaseorder.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductsProvidedBySuppliers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String itemNumber;
	private String itemName;
	private String color;
	private String price;
	private String size;
	private String category;
	private String imageData;
	@Column(unique = true)
	private String upc;
	private String sku;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "supplierId", referencedColumnName = "supplierId")
	private Suppliers suppliers;

	public ProductsProvidedBySuppliers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Suppliers getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}

	public ProductsProvidedBySuppliers(int id, String itemNumber, String itemName, String color, String price,
			String size, String category, String imageData, String upc, String sku, Suppliers suppliers) {
		super();
		this.id = id;
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.color = color;
		this.price = price;
		this.size = size;
		this.category = category;
		this.imageData = imageData;
		this.upc = upc;
		this.sku = sku;
		this.suppliers = suppliers;
	}

	@Override
	public String toString() {
		return "ProductsProvidedBySuppliers [id=" + id + ", itemNumber=" + itemNumber + ", itemName=" + itemName
				+ ", color=" + color + ", price=" + price + ", size=" + size + ", category=" + category + ", imageData="
				+ imageData + ", upc=" + upc + ", sku=" + sku + ", suppliers=" + suppliers + "]";
	}

}
