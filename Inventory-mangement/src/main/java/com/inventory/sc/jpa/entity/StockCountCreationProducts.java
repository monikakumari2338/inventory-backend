package com.inventory.sc.jpa.entity;

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
public class StockCountCreationProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 1, max = 20)
	@NotBlank
	private String upc;
	@Size(min = 1, max = 10)
	@NotBlank
	private String sku;
	private int bookQty;
	private int countedQty;
	private int varianceQty;
	private int recountVarianceQty;
	private int reCountQty;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stockcountId", referencedColumnName = "countId")
	private StockCountCreation stockcount;

	public StockCountCreationProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBookQty() {
		return bookQty;
	}

	public void setBookQty(int bookQty) {
		this.bookQty = bookQty;
	}

	public StockCountCreation getStockcount() {
		return stockcount;
	}

	public void setStockcount(StockCountCreation stockcount) {
		this.stockcount = stockcount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
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

	public StockCountCreationProducts(String sku, String upc, int bookQty, int countedQty, int varianceQty,
			int recountVarianceQty, int reCountQty, StockCountCreation stockcount) {
		super();
		this.sku = sku;
		this.upc = upc;
		this.bookQty = bookQty;
		this.countedQty = countedQty;
		this.varianceQty = varianceQty;
		this.recountVarianceQty = recountVarianceQty;
		this.reCountQty = reCountQty;
		this.stockcount = stockcount;
	}

}
