package com.inventory.adjustments.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class InventoryAdjustmentProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 1, max = 30)
	@NotBlank
	private String itemNumber;
	@Size(min = 1, max = 100)
	@NotBlank
	private String itemName;
	@Size(min = 1, max = 20)
	@NotBlank
	private String category;
	@Size(min = 1, max = 20)
	@NotBlank
	private String color;
	@Size(min = 1, max = 20)
	@NotBlank
	private String size;
	@Size(min = 1, max = 20)
	@NotBlank
	private String upc;
	@Size(min = 1, max = 10)
	@NotBlank
	private String sku;
	@Size(min = 1, max = 20)
	@NotBlank
	private String taxPercentage;
	@Size(min = 1, max = 20)
	@NotBlank
	private String taxCode;
	private int adjQty;
	@Column(length = 65555)
	private String proof;
	@Column(length = 65555)
	private String imageData;

	@ManyToOne
	@JoinColumn(name = "adjId", referencedColumnName = "adjId")
	private InventoryAdjustment invAdjustment;

	public InventoryAdjustmentProducts() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public int getAdjQty() {
		return adjQty;
	}

	public void setAdjQty(int adjQty) {
		this.adjQty = adjQty;
	}

	public String getProof() {
		return proof;
	}

	public void setProof(String proof) {
		this.proof = proof;
	}

	public InventoryAdjustment getInvAdjustment() {
		return invAdjustment;
	}

	public void setInvAdjustment(InventoryAdjustment invAdjustment) {
		this.invAdjustment = invAdjustment;
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

	public InventoryAdjustmentProducts(String itemNumber, String itemName, String category, String color, String size,
			String sku, String upc, int adjQty, String proof, String imageData, InventoryAdjustment invAdjustment) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.category = category;
		this.color = color;
		this.size = size;
		this.sku = sku;
		this.upc = upc;
		this.adjQty = adjQty;
		this.proof = proof;
		this.imageData = imageData;
		this.invAdjustment = invAdjustment;
	}

}
