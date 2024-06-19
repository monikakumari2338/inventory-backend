package com.inventory.myentity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AdhocStockCountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int generatedId;
	private int bookQty;
	private int firstcountedQty;
	private int firstvarianceQty;
	private int reCountQty;
	private int recountVarianceQty;
	private String reCountStatus;
	private String itemNumber;
	private String itemName;
	private String color;
	private String price;
	private String size;
	private String imageData;
	private String sku;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adhocId", referencedColumnName = "adhocId")
	private AdhocStockCount adhocStockCount;

	public int getGeneratedId() {
		return generatedId;
	}

	public void setGeneratedId(int generatedId) {
		this.generatedId = generatedId;
	}

	public int getBookQty() {
		return bookQty;
	}

	public void setBookQty(int bookQty) {
		this.bookQty = bookQty;
	}

	public int getFirstcountedQty() {
		return firstcountedQty;
	}

	public void setFirstcountedQty(int firstcountedQty) {
		this.firstcountedQty = firstcountedQty;
	}

	public int getFirstvarianceQty() {
		return firstvarianceQty;
	}

	public void setFirstvarianceQty(int firstvarianceQty) {
		this.firstvarianceQty = firstvarianceQty;
	}

	public int getReCountQty() {
		return reCountQty;
	}

	public void setReCountQty(int reCountQty) {
		this.reCountQty = reCountQty;
	}

	public int getRecountVarianceQty() {
		return recountVarianceQty;
	}

	public void setRecountVarianceQty(int recountVarianceQty) {
		this.recountVarianceQty = recountVarianceQty;
	}

	public String getReCountStatus() {
		return reCountStatus;
	}

	public void setReCountStatus(String reCountStatus) {
		this.reCountStatus = reCountStatus;
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public AdhocStockCount getAdhocStockCount() {
		return adhocStockCount;
	}

	public void setAdhocStockCount(AdhocStockCount adhocStockCount) {
		this.adhocStockCount = adhocStockCount;
	}

	public AdhocStockCountDetails(int bookQty, int firstcountedQty, int firstvarianceQty, int reCountQty,
			int recountVarianceQty, String reCountStatus, String itemNumber, String itemName, String color,
			String price, String size, String imageData, String sku, AdhocStockCount adhocStockCount) {
		super();
		this.bookQty = bookQty;
		this.firstcountedQty = firstcountedQty;
		this.firstvarianceQty = firstvarianceQty;
		this.reCountQty = reCountQty;
		this.recountVarianceQty = recountVarianceQty;
		this.reCountStatus = reCountStatus;
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.color = color;
		this.price = price;
		this.size = size;
		this.imageData = imageData;
		this.sku = sku;
		this.adhocStockCount = adhocStockCount;
	}

	public AdhocStockCountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
