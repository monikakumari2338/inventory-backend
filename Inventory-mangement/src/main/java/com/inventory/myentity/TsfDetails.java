package com.inventory.myentity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TsfDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int generatedId;
	private String itemNumber;
	private String itemName;
	private String category;
	private String color;
	private String price;
	private String size;
	private int requestedQty;
	private int approvedQty;
	private int shippedQty;
	private int receivedQty;
	private int damageQty;
	private String damageProof;
	private String imageData;
	private String upc;
	private String sku;
	private String taxPercentage;
	private String taxCode;

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
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

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
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

	public String getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(String taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public TsfHead getTsfHead() {
		return tsfHead;
	}

	public void setTsfHead(TsfHead tsfHead) {
		this.tsfHead = tsfHead;
	}

	public TsfDetails(String itemNumber, String itemName, String category, String color, String price, String size,
			int requestedQty, int approvedQty, int shippedQty, int receivedQty, int damageQty, String damageProof,
			String imageData, String upc, String sku, String taxPercentage, String taxCode, TsfHead tsfHead) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.category = category;
		this.color = color;
		this.price = price;
		this.size = size;
		this.requestedQty = requestedQty;
		this.approvedQty = approvedQty;
		this.shippedQty = shippedQty;
		this.receivedQty = receivedQty;
		this.damageQty = damageQty;
		this.damageProof = damageProof;
		this.imageData = imageData;
		this.upc = upc;
		this.sku = sku;
		this.taxPercentage = taxPercentage;
		this.taxCode = taxCode;
		this.tsfHead = tsfHead;
	}

}