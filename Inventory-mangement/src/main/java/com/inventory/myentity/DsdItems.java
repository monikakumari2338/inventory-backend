package com.inventory.myentity;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DsdItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int generatedId;
	private String itemNumber;
	private String itemName;
	private int expectedQty;
	private int receivedQty;
	private String category;
	private String color;
	private String size;
	private String imageData;
	private String upc;
	private String sku;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dsdNumber", referencedColumnName = "dsdNumber")
	private DSD dsd;

	public DsdItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getGeneratedId() {
		return generatedId;
	}

	public void setGeneratedId(int generatedId) {
		this.generatedId = generatedId;
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

	public int getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(int receivedQty) {
		this.receivedQty = receivedQty;
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

	public DSD getDsd() {
		return dsd;
	}

	public void setDsd(DSD dsd) {
		this.dsd = dsd;
	}

	public int getExpectedQty() {
		return expectedQty;
	}

	public void setExpectedQty(int expectedQty) {
		this.expectedQty = expectedQty;
	}

	public DsdItems(String itemNumber, String itemName, int expectedQty, int receivedQty, String category, String color,
			String size, String imageData, String upc, String sku, DSD dsd) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.expectedQty = expectedQty;
		this.receivedQty = receivedQty;
		this.category = category;
		this.color = color;
		this.size = size;
		this.imageData = imageData;
		this.upc = upc;
		this.sku = sku;
		this.dsd = dsd;
	}

}
