package com.inventory.tsf.jpa.entity;

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
public class TsfDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int generatedId;
	private int requestedQty;
	private int approvedQty;
	private int shippedQty;
	private int receivedQty;
	private int damageQty;
	private String damageProof;
	@Size(min = 1, max = 20)
	@NotBlank
	private String upc;
	@Size(min = 1, max = 10)
	@NotBlank
	private String sku;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tsfId", referencedColumnName = "tsfId")
	private TsfHead tsfHead;

	public TsfDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getGeneratedId() {
		return generatedId;
	}

	public void setGeneratedId(int generatedId) {
		this.generatedId = generatedId;
	}

	public int getRequestedQty() {
		return requestedQty;
	}

	public void setRequestedQty(int requestedQty) {
		this.requestedQty = requestedQty;
	}

	public int getApprovedQty() {
		return approvedQty;
	}

	public void setApprovedQty(int approvedQty) {
		this.approvedQty = approvedQty;
	}

	public int getShippedQty() {
		return shippedQty;
	}

	public void setShippedQty(int shippedQty) {
		this.shippedQty = shippedQty;
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

	public TsfHead getTsfHead() {
		return tsfHead;
	}

	public void setTsfHead(TsfHead tsfHead) {
		this.tsfHead = tsfHead;
	}

	public TsfDetails(int requestedQty, int approvedQty, int shippedQty, int receivedQty, int damageQty,
			String damageProof, String upc, String sku, TsfHead tsfHead) {
		super();
		this.requestedQty = requestedQty;
		this.approvedQty = approvedQty;
		this.shippedQty = shippedQty;
		this.receivedQty = receivedQty;
		this.damageQty = damageQty;
		this.damageProof = damageProof;
		this.upc = upc;
		this.sku = sku;
		this.tsfHead = tsfHead;
	}

}
