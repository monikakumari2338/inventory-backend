//package com.inventory.purchaseorder.entity;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class TransferReceiveProducts {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//
//	private String itemNumber;
//	private String itemName;
//	private int expectedQty;
//	private String category;
//	private String color;
//	private String price;
//	private String size;
//	private String imageData;
//	private String store;
//	private int stock;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "transferId", referencedColumnName = "transferId")
//	private TransferReceiveInfo transferInfo;
//
//	public TransferReceiveProducts() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getItemNumber() {
//		return itemNumber;
//	}
//
//	public void setItemNumber(String itemNumber) {
//		this.itemNumber = itemNumber;
//	}
//
//	public String getItemName() {
//		return itemName;
//	}
//
//	public void setItemName(String itemName) {
//		this.itemName = itemName;
//	}
//
//	public int getExpectedQty() {
//		return expectedQty;
//	}
//
//	public void setExpectedQty(int expectedQty) {
//		this.expectedQty = expectedQty;
//	}
//
//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}
//
//	public String getColor() {
//		return color;
//	}
//
//	public void setColor(String color) {
//		this.color = color;
//	}
//
//	public String getPrice() {
//		return price;
//	}
//
//	public void setPrice(String price) {
//		this.price = price;
//	}
//
//	public String getSize() {
//		return size;
//	}
//
//	public void setSize(String size) {
//		this.size = size;
//	}
//
//	public String getImageData() {
//		return imageData;
//	}
//
//	public void setImageData(String imageData) {
//		this.imageData = imageData;
//	}
//
//	public TransferReceiveInfo getTransferInfo() {
//		return transferInfo;
//	}
//
//	public void setTransferInfo(TransferReceiveInfo transferInfo) {
//		transferInfo = transferInfo;
//	}
//
//	public String getStore() {
//		return store;
//	}
//
//	public void setStore(String store) {
//		this.store = store;
//	}
//
//	public int getStock() {
//		return stock;
//	}
//
//	public void setStock(int stock) {
//		this.stock = stock;
//	}
//
//	public TransferReceiveProducts(String itemNumber, String itemName, int expectedQty, String category, String color,
//			String price, String size, String imageData, String store, int stock, TransferReceiveInfo TransferInfo) {
//		super();
//		// this.id = id;
//		this.itemNumber = itemNumber;
//		this.itemName = itemName;
//		this.expectedQty = expectedQty;
//		this.category = category;
//		this.color = color;
//		this.price = price;
//		this.size = size;
//		this.imageData = imageData;
//		this.store = store;
//		this.stock = stock;
//		this.transferInfo = TransferInfo;
//	}
//
//	@Override
//	public String toString() {
//		return "TransferReceiveProducts [id=" + id + ", itemNumber=" + itemNumber + ", itemName=" + itemName + ", expectedQty="
//				+ expectedQty + ", category=" + category + ", color=" + color + ", price=" + price + ", size=" + size
//				+ ", imageData=" + imageData + ", store=" + store + ", stock=" + stock + ", TransferInfo=" + transferInfo
//				+ "]";
//	}
//}
