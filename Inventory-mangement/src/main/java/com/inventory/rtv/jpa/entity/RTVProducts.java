package com.inventory.rtv.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class RTVProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int generatedId;
	private String attachedImage;
	private int returnQty;
	@Size(min = 1, max = 20)
	@NotBlank
	private String upc;
	@Size(min = 1, max = 10)
	@NotBlank
	private String sku;

	@ManyToOne()
	@JoinColumn(name = "rtvID", referencedColumnName = "rtvID")
	private RTVInfo rtvInfo;

	public RTVProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getGeneratedId() {
		return generatedId;
	}

	public void setGeneratedId(int generatedId) {
		this.generatedId = generatedId;
	}

	public String getAttachedImage() {
		return attachedImage;
	}

	public void setAttachedImage(String attachedImage) {
		this.attachedImage = attachedImage;
	}

	public int getReturnQty() {
		return returnQty;
	}

	public void setReturnQty(int returnQty) {
		this.returnQty = returnQty;
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

	public RTVInfo getRtvInfo() {
		return rtvInfo;
	}

	public void setRtvInfo(RTVInfo rtvInfo) {
		this.rtvInfo = rtvInfo;
	}

	public RTVProducts(String attachedImage, int returnQty, String upc, String sku, RTVInfo rtvInfo) {
		super();
		this.attachedImage = attachedImage;
		this.returnQty = returnQty;
		this.upc = upc;
		this.sku = sku;
		this.rtvInfo = rtvInfo;
	}

}
