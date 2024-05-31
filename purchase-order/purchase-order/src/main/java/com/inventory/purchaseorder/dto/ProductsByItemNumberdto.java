package com.inventory.purchaseorder.dto;

import java.util.List;

import com.inventory.purchaseorder.entity.ProductDetails;
import com.inventory.purchaseorder.repository.ProductDetailsRepo;

public class ProductsByItemNumberdto {

	private String itemNumber;
	private String itemName;
	private String categoryName;
	private List<ProductDetailsdto> productDetailsdto;

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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
	public ProductsByItemNumberdto(String itemNumber, String itemName, String categoryName,
			List<ProductDetailsdto> productDetailsdto) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.categoryName = categoryName;
		this.productDetailsdto = productDetailsdto;
	}

	public List<ProductDetailsdto> getProductDetailsdto() {
		return productDetailsdto;
	}

	public void setProductDetailsdto(List<ProductDetailsdto> productDetailsdto) {
		this.productDetailsdto = productDetailsdto;
	}

	public ProductsByItemNumberdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductsByItemNumberdto [itemNumber=" + itemNumber + ", itemName=" + itemName + ", categoryName="
				+ categoryName + ", productDetailsdto=" + productDetailsdto + "]";
	}

}
