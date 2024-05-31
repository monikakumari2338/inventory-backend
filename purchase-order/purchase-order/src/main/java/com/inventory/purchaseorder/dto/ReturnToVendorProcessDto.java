package com.inventory.purchaseorder.dto;

import java.util.List;

public class ReturnToVendorProcessDto {

	private ReturnToVendorProcessInfoDto rtvProcessInfo;
	private List<ReturnToVendorProcessProductsDto> rtvProcessProducts;

	public ReturnToVendorProcessInfoDto getRtvProcessInfo() {
		return rtvProcessInfo;
	}

	public void setRtvProcessInfo(ReturnToVendorProcessInfoDto rtvProcessInfo) {
		this.rtvProcessInfo = rtvProcessInfo;
	}

	public List<ReturnToVendorProcessProductsDto> getRtvProcessProducts() {
		return rtvProcessProducts;
	}

	public void setRtvProcessProducts(List<ReturnToVendorProcessProductsDto> rtvProcessProducts) {
		this.rtvProcessProducts = rtvProcessProducts;
	}

	public ReturnToVendorProcessDto(ReturnToVendorProcessInfoDto rtvProcessInfo,
			List<ReturnToVendorProcessProductsDto> rtvProcessProducts) {
		super();
		this.rtvProcessInfo = rtvProcessInfo;
		this.rtvProcessProducts = rtvProcessProducts;
	}

	@Override
	public String toString() {
		return "ReturnToVendorProcessDto [rtvProcessInfo=" + rtvProcessInfo + ", rtvProcessProducts="
				+ rtvProcessProducts + "]";
	}

}
