package com.inventory.purchaseorder.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

@Entity
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String color;
	private String price;
	private String size;
	private int sellableStock;
	private int nonSellableStock;
	private int totalStock;
	private String imageData;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "store_id", referencedColumnName = "storeId")
	private Stores store;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "itemNumber", referencedColumnName = "itemNumber")
	private Product product;

	@Column(unique = true)
	private String upc;

	private String sku;

	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stores getStore() {
		return store;
	}

	public void setStore(Stores store) {
		this.store = store;
	}

	public int getSellableStock() {
		return sellableStock;
	}

	public void setSellableStock(int sellableStock) {
		this.sellableStock = sellableStock;
	}

	public int getNonSellableStock() {
		return nonSellableStock;
	}

	public void setNonSellableStock(int nonSellableStock) {
		this.nonSellableStock = nonSellableStock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public int getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}

	public ProductDetails(String color, String price, String size, int sellableStock, int nonSellableStock,
			String imageData, Stores store, Product product, String upc, String sku) {
		super();
		this.color = color;
		this.price = price;
		this.size = size;
		this.sellableStock = sellableStock;
		this.nonSellableStock = nonSellableStock;
		this.imageData = imageData;
		this.store = store;
		this.product = product;
		this.upc = upc;
		this.sku = sku;
	}

	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", color=" + color + ", price=" + price + ", size=" + size
				+ ", sellableStock=" + sellableStock + ", nonSellableStock=" + nonSellableStock + ", totalStock="
				+ totalStock + ", imageData=" + imageData + ", store=" + store + ", product=" + product + ", upc=" + upc
				+ ", sku=" + sku + "]";
	}

}
