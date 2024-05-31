package com.inventory.purchaseorder.dto;

import java.util.List;

public class ReturnToVendorCombinedDto {

	private ReturnToVendorInfodto rtvInfodto;
	private List<ReturnToVendorProductsdto> rtvProductsdto;

	public ReturnToVendorInfodto getRtvInfodto() {
		return rtvInfodto;
	}

	public void setRtvInfodto(ReturnToVendorInfodto rtvInfodto) {
		this.rtvInfodto = rtvInfodto;
	}

	public List<ReturnToVendorProductsdto> getRtvProductsdto() {
		return rtvProductsdto;
	}

	public void setRtvProductsdto(List<ReturnToVendorProductsdto> rtvProductsdto) {
		this.rtvProductsdto = rtvProductsdto;
	}

	public ReturnToVendorCombinedDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReturnToVendorCombinedDto(ReturnToVendorInfodto rtvInfodto, List<ReturnToVendorProductsdto> rtvProductsdto) {
		super();
		this.rtvInfodto = rtvInfodto;
		this.rtvProductsdto = rtvProductsdto;
	}

	@Override
	public String toString() {
		return "ReturnToVendorCombinedDto [rtvInfodto=" + rtvInfodto + ", rtvProductsdto=" + rtvProductsdto + "]";
	}

}
