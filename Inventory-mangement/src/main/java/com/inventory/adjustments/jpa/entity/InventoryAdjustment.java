package com.inventory.adjustments.jpa.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "inv_adjustment")
public class InventoryAdjustment {

	@Size(min = 1, max = 20)
	@NotBlank
	@Id
	private String adjId;
	private String imageData;
	@Size(min = 1, max = 10)
	@NotBlank
	private int totalSku;
	private LocalDate date;
	@Size(min = 1, max = 30)
	@NotBlank
	private String reason;
	@Size(min = 1, max = 30)
	@NotBlank
	private String store;
	@Size(min = 1, max = 30)
	@NotBlank
	private String user;
	@Size(min = 1, max = 20)
	@NotBlank
	private String status;

	@OneToMany(mappedBy = "invAdjustment", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InventoryAdjustmentProducts> invProducts;

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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public InventoryAdjustment(String adjId, String imageData, int totalSku, LocalDate date, String reason,
			String store, String user, String status) {
		super();
		this.adjId = adjId;
		this.imageData = imageData;
		this.totalSku = totalSku;
		this.date = date;
		this.reason = reason;
		this.store = store;
		this.user = user;
		this.status = status;
	}

}
