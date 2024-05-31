package com.inventory.purchaseorder.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "inv_adjustment")
public class InventoryAdjustment {

	@Id
	private String adjId;
	 @Column(length = 65555)
	private String imageData;
	private int totalSku;
	private LocalDate date;

	public InventoryAdjustment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAdjId() {
		return adjId;
	}

	public void setAdjId(String adjId) {
		this.adjId = adjId;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public int getTotalSku() {
		return totalSku;
	}

	public void setTotalSku(int totalSku) {
		this.totalSku = totalSku;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public InventoryAdjustment(String adjId, String imageData, int totalSku, LocalDate date) {
		super();
		this.adjId = adjId;
		this.imageData = imageData;
		this.totalSku = totalSku;
		this.date = date;
	}

}
