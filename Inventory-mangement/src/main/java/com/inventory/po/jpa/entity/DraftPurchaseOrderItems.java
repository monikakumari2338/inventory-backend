package com.inventory.po.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class DraftPurchaseOrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int generatedId;
	@Size(min = 1, max = 30)
	@NotBlank
	private String itemNumber;
	@Size(min = 1, max = 100)
	@NotBlank
	private String itemName;
	private int expectedQty;
	private int receivedQty;
	private int remainingQty;
	private int damageQty;
	@Column(length = 65555)
	private String damageImage;
	@Size(min = 1, max = 20)
	@NotBlank
	private String category;
	@Size(min = 1, max = 20)
	@NotBlank
	private String color;
	@Size(min = 1, max = 100)
	@NotBlank
	private String price;
	@Size(min = 1, max = 20)
	@NotBlank
	private String size;
	private String imageData;
	@Size(min = 1, max = 20)
	@NotBlank
	private String upc;
	@Size(min = 1, max = 10)
	@NotBlank
	private String sku;
	@Size(min = 1, max = 20)
	@NotBlank
	private String taxPercentage;
	@Size(min = 1, max = 20)
	@NotBlank
	private String taxCode;
	@Size(min = 1, max = 20)
	@NotBlank
	private String poNumber;
	@Size(min = 1, max = 20)
	@NotBlank
	private String asnNumber;

	public DraftPurchaseOrderItems() {
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

	public int getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(int receivedQty) {
		this.receivedQty = receivedQty;
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

	public int getDamageQty() {
		return damageQty;
	}

	public void setDamageQty(int damageQty) {
		this.damageQty = damageQty;
	}

	public String getDamageImage() {
		return damageImage;
	}

	public void setDamageImage(String damageImage) {
		this.damageImage = damageImage;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getAsnNumber() {
		return asnNumber;
	}

	public void setAsnNumber(String asnNumber) {
		this.asnNumber = asnNumber;
	}

	public DraftPurchaseOrderItems(String itemNumber, String itemName, int expectedQty, int receivedQty,
			int remainingQty, int damageQty, String damageImage, String category, String color, String price,
			String size, String imageData, String upc, String sku, String taxPercentage, String taxCode,
			String poNumber, String asnNumber) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.expectedQty = expectedQty;
		this.receivedQty = receivedQty;
		this.remainingQty = remainingQty;
		this.damageQty = damageQty;
		this.damageImage = damageImage;
		this.category = category;
		this.color = color;
		this.price = price;
		this.size = size;
		this.imageData = imageData;
		this.upc = upc;
		this.sku = sku;
		this.taxPercentage = taxPercentage;
		this.taxCode = taxCode;
		this.poNumber = poNumber;
		this.asnNumber = asnNumber;
	}

	@Override
	public String toString() {
		return "DraftPurchaseOrderItems [generatedId=" + generatedId + ", itemNumber=" + itemNumber + ", itemName="
				+ itemName + ", expectedQty=" + expectedQty + ", receivedQty=" + receivedQty + ", remainingQty="
				+ remainingQty + ", damageQty=" + damageQty + ", damageImage=" + damageImage + ", category=" + category
				+ ", color=" + color + ", price=" + price + ", size=" + size + ", imageData=" + imageData + ", upc="
				+ upc + ", sku=" + sku + ", taxPercentage=" + taxPercentage + ", taxCode=" + taxCode + ", poNumber="
				+ poNumber + ", asnNumber=" + asnNumber + "]";
	}

}
