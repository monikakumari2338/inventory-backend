package com.inventory.purchaseorder.dto;

public class SaveStockCountProductsdto {

	private int id;
	private String itemNumber;
	private String itemName;
	private String category;
	private String color;
	private String price;
	private String size;
	private String imageData;
	private String store;
	private int bookQty;
	private int countedQty;
	private int varianceQty;
	private int recountVarianceQty;
	private int countId;
	private int reCountQty;
	private String sku;

	public int getRecountVarianceQty() {
		return recountVarianceQty;
	}

	public void setRecountVarianceQty(int recountVarianceQty) {
		this.recountVarianceQty = recountVarianceQty;
	}

	public int getReCountQty() {
		return reCountQty;
	}

	public void setReCountQty(int reCountQty) {
		this.reCountQty = reCountQty;
	}

	public SaveStockCountProductsdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBookQty() {
		return bookQty;
	}

	public void setBookQty(int bookQty) {
		this.bookQty = bookQty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public int getCountedQty() {
		return countedQty;
	}

	public void setCountedQty(int countedQty) {
		this.countedQty = countedQty;
	}

	public int getVarianceQty() {
		return varianceQty;
	}

	public void setVarianceQty(int varianceQty) {
		this.varianceQty = varianceQty;
	}

	public int getCountId() {
		return countId;
	}

	public void setCountId(int countId) {
		this.countId = countId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public SaveStockCountProductsdto(int id, String itemNumber, String itemName, String category, String color,
			String price, String size, String imageData, String store, int bookQty, int countedQty, int varianceQty,
			int recountVarianceQty, int countId, int reCountQty, String sku) {
		super();
		this.id = id;
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.category = category;
		this.color = color;
		this.price = price;
		this.size = size;
		this.imageData = imageData;
		this.store = store;
		this.bookQty = bookQty;
		this.countedQty = countedQty;
		this.varianceQty = varianceQty;
		this.recountVarianceQty = recountVarianceQty;
		this.countId = countId;
		this.reCountQty = reCountQty;
		this.sku = sku;
	}

	@Override
	public String toString() {
		return "SaveStockCountProductsdto [id=" + id + ", itemNumber=" + itemNumber + ", itemName=" + itemName
				+ ", category=" + category + ", color=" + color + ", price=" + price + ", size=" + size + ", imageData="
				+ imageData + ", store=" + store + ", bookQty=" + bookQty + ", countedQty=" + countedQty
				+ ", varianceQty=" + varianceQty + ", recountVarianceQty=" + recountVarianceQty + ", countId=" + countId
				+ ", reCountQty=" + reCountQty + ", sku=" + sku + "]";
	}

}
