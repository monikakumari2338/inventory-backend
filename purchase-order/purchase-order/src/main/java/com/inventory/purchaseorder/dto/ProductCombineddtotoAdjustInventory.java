package com.inventory.purchaseorder.dto;

import java.util.List;

public class ProductCombineddtotoAdjustInventory {

	private Productdto productdto;
	private List<ProductDetailsInventoryAdjustment> productDetailsdto;

	public Productdto getProductdto() {
		return productdto;
	}

	public void setProductdto(Productdto productdto) {
		this.productdto = productdto;
	}

	public List<ProductDetailsInventoryAdjustment> getProductDetailsdto() {
		return productDetailsdto;
	}

	public void setProductDetailsdto(List<ProductDetailsInventoryAdjustment> productDetailsdto) {
		this.productDetailsdto = productDetailsdto;
	}

	public ProductCombineddtotoAdjustInventory(Productdto productdto, List<ProductDetailsInventoryAdjustment> productDetailsdto) {
		super();
		this.productdto = productdto;
		this.productDetailsdto = productDetailsdto;
	}

	public ProductCombineddtotoAdjustInventory() {
		super();
		// TODO Auto-generated constructor stub
	}

}
