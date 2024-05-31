package com.inventory.purchaseorder.dto;

public class categorydto {

	String categoryName;
	int totalStock;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}

	public categorydto(String categoryName, int totalStock) {
		super();
		this.categoryName = categoryName;
		this.totalStock = totalStock;
	}

	@Override
	public String toString() {
		return "categorydto [categoryName=" + categoryName + ", totalStock=" + totalStock + "]";
	}

	public categorydto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
