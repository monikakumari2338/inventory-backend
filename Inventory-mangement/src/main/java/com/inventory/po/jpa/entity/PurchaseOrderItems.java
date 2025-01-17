package com.inventory.po.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class PurchaseOrderItems {

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
	private String image;
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
	private boolean isCompleted;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "poNumber", referencedColumnName = "poNumber")
	private PurchaseOrder purchaseOrder;

	public PurchaseOrderItems() {
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

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
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

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
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

	public boolean isCompleted() {
		return isCompleted;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public PurchaseOrderItems(String itemNumber, String itemName, int expectedQty, int damageQty, String damageImage,
			String category, String color, String price, String size, String imageData, String image, String upc,
			String sku, String taxPercentage, String taxCode, PurchaseOrder purchaseOrder) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.expectedQty = expectedQty;
//		this.receivedQty = receivedQty;
//		this.remainingQty = remainingQty;
		this.damageQty = damageQty;
		this.damageImage = damageImage;
		this.category = category;
		this.color = color;
		this.price = price;
		this.size = size;
		this.imageData = imageData;
		this.image = image;
		this.upc = upc;
		this.sku = sku;
		this.taxPercentage = taxPercentage;
		this.taxCode = taxCode;
		this.purchaseOrder = purchaseOrder;
	}

	@Override
	public String toString() {
		return "PurchaseOrderItems [generatedId=" + generatedId + ", itemNumber=" + itemNumber + ", itemName="
				+ itemName + ", expectedQty=" + expectedQty + ", receivedQty=" + receivedQty + ", remainingQty="
				+ remainingQty + ", damageQty=" + damageQty + ", damageImage=" + damageImage + ", category=" + category
				+ ", color=" + color + ", price=" + price + ", size=" + size + ", imageData=" + imageData + ", upc="
				+ upc + ", sku=" + sku + ", taxPercentage=" + taxPercentage + ", taxCode=" + taxCode
				+ ", purchaseOrder=" + purchaseOrder + "]";
	}

}
