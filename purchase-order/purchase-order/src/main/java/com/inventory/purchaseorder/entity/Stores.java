package com.inventory.purchaseorder.entity;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Stores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	private String storeName;
	private int storeStock;
	private String storeAddress;
	
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public int getStoreStock() {
		return storeStock;
	}
	public void setStoreStock(int storeStock) {
		this.storeStock = storeStock;
	}
	
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	
	
	@Override
	public String toString() {
		return "Stores [storeId=" + storeId + ", storeName=" + storeName + ", storeStock=" + storeStock
				+ ", storeAddress=" + storeAddress + "]";
	}
	public Stores(int storeId, String storeName, int storeStock, String storeAddress) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeStock = storeStock;
		this.storeAddress = storeAddress;
	}
	public Stores() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
