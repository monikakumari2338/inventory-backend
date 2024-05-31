package com.inventory.purchaseorder.dto;

public class ProductCombineddto {

	private Productdto productdto;
	private ProductDetailsdto productDetailsdto;

	public Productdto getProductdto() {
		return productdto;
	}

	public void setProductdto(Productdto productdto) {
		this.productdto = productdto;
	}

	public ProductDetailsdto getProductDetailsdto() {
		return productDetailsdto;
	}

	public void setProductDetailsdto(ProductDetailsdto productDetailsdto) {
		this.productDetailsdto = productDetailsdto;
	}

	public ProductCombineddto(Productdto productdto, ProductDetailsdto productDetailsdto) {
		super();
		this.productdto = productdto;
		this.productDetailsdto = productDetailsdto;
	}

	public ProductCombineddto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
