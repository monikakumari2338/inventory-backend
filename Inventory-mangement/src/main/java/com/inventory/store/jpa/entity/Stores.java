package com.inventory.store.jpa.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Stores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	@Size(min = 1, max = 30)
	@NotBlank
	private String storeName;
	private int storeStock;
	@Size(min = 1, max = 100)
	@NotBlank
	private String storeAddress;
	private double latitude;
	private double longitude;

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

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Stores(String storeName, int storeStock, String storeAddress, double latitude, double longitude) {
		super();
//		this.storeId = storeId;
		this.storeName = storeName;
		this.storeStock = storeStock;
		this.storeAddress = storeAddress;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Stores() {
		super();
		// TODO Auto-generated constructor stub
	}

}
