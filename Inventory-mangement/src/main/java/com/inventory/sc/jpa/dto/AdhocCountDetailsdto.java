package com.inventory.sc.jpa.dto;

public class AdhocCountDetailsdto {

	private int bookQty;
	private int firstcountedQty;
	private int firstvarianceQty;
	private int reCountQty;
	private int recountVarianceQty;
	private String reCountStatus;
	private String itemNumber;
	private String itemName;
	private String category;
	private String color;
	private String price;
	private String size;
	private String imageData;
	private String sku;

	public AdhocCountDetailsdto() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public AdhocCountDetailsdto(int bookQty, int firstcountedQty, int firstvarianceQty, int reCountQty,
			int recountVarianceQty, String reCountStatus, String itemNumber, String itemName, String category,
			String color, String price, String size, String imageData, String sku) {
		super();
		this.bookQty = bookQty;
		this.firstcountedQty = firstcountedQty;
		this.firstvarianceQty = firstvarianceQty;
		this.reCountQty = reCountQty;
		this.recountVarianceQty = recountVarianceQty;
		this.reCountStatus = reCountStatus;
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.category = category;
		this.color = color;
		this.price = price;
		this.size = size;
		this.imageData = imageData;
		this.sku = sku;
	}

}
