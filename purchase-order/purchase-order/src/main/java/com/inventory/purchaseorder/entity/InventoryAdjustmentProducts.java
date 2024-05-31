package com.inventory.purchaseorder.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class InventoryAdjustmentProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String itemNumber;
	private String itemName;
	private String category;
	private String sku;
	private String upc;
	private String store;
	private String reason;
	private String status;
	private String user;
	private int adjQty;
	@Column(length = 65555)
	private String imageData;

	@ManyToOne(cascade = CascadeType.ALL)
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

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getAdjQty() {
		return adjQty;
	}

	public void setAdjQty(int adjQty) {
		this.adjQty = adjQty;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public InventoryAdjustment getInvAdjustment() {
		return invAdjustment;
	}

	public void setInvAdjustment(InventoryAdjustment invAdjustment) {
		this.invAdjustment = invAdjustment;
	}

	public InventoryAdjustmentProducts(String itemNumber, String itemName, String category, String sku, String upc,
			String store, String reason, String status, String user, int adjQty, String imageData,
			InventoryAdjustment invAdjustment) {
		super();

		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.category = category;
		this.sku = sku;
		this.upc = upc;
		this.store = store;
		this.reason = reason;
		this.status = status;
		this.user = user;
		this.adjQty = adjQty;
		this.imageData = imageData;
		this.invAdjustment = invAdjustment;
	}

}
