package com.inventory.tsf.jpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TsfDetailsSaveDto {
    
	@NotBlank(message="Received Qty can't be null ")
	private int receivedQty;
	private int damageQty;
	private String damageProof;
	private String upc;
	private String sku;

	public TsfDetailsSaveDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(int receivedQty) {
		this.receivedQty = receivedQty;
	}

	public int getDamageQty() {
		return damageQty;
	}

	public void setDamageQty(int damageQty) {
		this.damageQty = damageQty;
	}

	public String getDamageProof() {
		return damageProof;
	}

	public void setDamageProof(String damageProof) {
		this.damageProof = damageProof;
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

	public TsfDetailsSaveDto(int receivedQty, int damageQty, String damageProof, String upc, String sku) {
		super();
		this.receivedQty = receivedQty;
		this.damageQty = damageQty;
		this.damageProof = damageProof;
		this.upc = upc;
		this.sku = sku;
	}

}
