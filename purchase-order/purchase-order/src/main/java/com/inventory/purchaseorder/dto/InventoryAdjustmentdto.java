package com.inventory.purchaseorder.dto;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Lob;

public class InventoryAdjustmentdto {

	private String adjId;
	private String image;
	private int totalSku;
	private LocalDate date;

	public InventoryAdjustmentdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getAdjId() {
		return adjId;
	}

	public void setAdjId(String adjId) {
		this.adjId = adjId;
	}

	public InventoryAdjustmentdto(String adjId, String image, int totalSku, LocalDate date) {
		super();
		this.adjId = adjId;
		this.image = image;
		this.totalSku = totalSku;
		this.date = date;
	}

	@Override
	public String toString() {
		return "InventoryAdjustmentdto [image=" + image + ", totalSku=" + totalSku + ", date=" + date + "]";
	}

}
