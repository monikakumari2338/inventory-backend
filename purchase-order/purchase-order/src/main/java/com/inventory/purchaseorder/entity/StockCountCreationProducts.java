package com.inventory.purchaseorder.entity;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StockCountCreationProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String itemNumber;
	private String itemName;
	private String category;
	private String color;
	private String price;
	private String size;
	private String imageData;
	private String store;
	private int bookQty;
	private String sku;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stockcountId", referencedColumnName = "countId")
	private StockCountCreation stockcount;

	public StockCountCreationProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBookQty() {
		return bookQty;
	}

	public void setBookQty(int bookQty) {
		this.bookQty = bookQty;
	}

	public StockCountCreation getStockcount() {
		return stockcount;
	}

	public void setStockcount(StockCountCreation stockcount) {
		this.stockcount = stockcount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public StockCountCreationProducts(String itemNumber, String itemName, String category, String color, String price,
			String size, String imageData, String store, int bookQty, String sku, StockCountCreation stockcount) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.category = category;
		this.color = color;
		this.price = price;
		this.size = size;
		this.imageData = imageData;
		this.store = store;
		this.bookQty = bookQty;
		this.sku = sku;
		this.stockcount = stockcount;
	}

}
