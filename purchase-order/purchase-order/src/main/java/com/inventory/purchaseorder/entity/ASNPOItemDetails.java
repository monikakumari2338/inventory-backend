package com.inventory.purchaseorder.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ASNPOItemDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int generatedId;
	private String itemNumber;
	private String itemName;
	private int expectedQty;
	private int shippedQty;
	private int remainingQty;
	private String category;
	private String color;
	private String price;
	private String size;
	private String imageData;
	private String upc;
	private String sku;
	private String taxPercentage;
	private String taxCode;
	private LocalDate expectedDeliveryDate;
	private LocalDate ReceivedDate;
	private int poNumber;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "asnNumber", referencedColumnName = "asnNumber")
	private ASN asn;

	public ASNPOItemDetails() {
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

	public int getExpectedQty() {
		return expectedQty;
	}

	public void setExpectedQty(int expectedQty) {
		this.expectedQty = expectedQty;
	}

	public int getShippedQty() {
		return shippedQty;
	}

	public void setShippedQty(int shippedQty) {
		this.shippedQty = shippedQty;
	}

	public int getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(int poNumber) {
		this.poNumber = poNumber;
	}

	public ASN getAsn() {
		return asn;
	}

	public void setAsn(ASN asn) {
		this.asn = asn;
	}

	public int getRemainingQty() {
		return remainingQty;
	}

	public void setRemainingQty(int remainingQty) {
		this.remainingQty = remainingQty;
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

	public LocalDate getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public LocalDate getReceivedDate() {
		return ReceivedDate;
	}

	public void setReceivedDate(LocalDate receivedDate) {
		ReceivedDate = receivedDate;
	}

	public ASNPOItemDetails(String itemNumber, String itemName, int expectedQty, int shippedQty, int remainingQty,
			String category, String color, String price, String size, String imageData, String upc, String sku,
			String taxPercentage, String taxCode, LocalDate expectedDeliveryDate, LocalDate receivedDate, int poNumber,
			ASN asn) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.expectedQty = expectedQty;
		this.shippedQty = shippedQty;
		this.remainingQty = remainingQty;
		this.category = category;
		this.color = color;
		this.price = price;
		this.size = size;
		this.imageData = imageData;
		this.upc = upc;
		this.sku = sku;
		this.taxPercentage = taxPercentage;
		this.taxCode = taxCode;
		this.expectedDeliveryDate = expectedDeliveryDate;
		ReceivedDate = receivedDate;
		this.poNumber = poNumber;
		this.asn = asn;
	}

	@Override
	public String toString() {
		return "ASNPOItemDetails [generatedId=" + generatedId + ", itemNumber=" + itemNumber + ", itemName=" + itemName
				+ ", expectedQty=" + expectedQty + ", shippedQty=" + shippedQty + ", remainingQty=" + remainingQty
				+ ", category=" + category + ", color=" + color + ", price=" + price + ", size=" + size + ", imageData="
				+ imageData + ", upc=" + upc + ", sku=" + sku + ", taxPercentage=" + taxPercentage + ", taxCode="
				+ taxCode + ", poNumber=" + poNumber + ", asn=" + asn + "]";
	}

}