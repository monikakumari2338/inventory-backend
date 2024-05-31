package com.inventory.purchaseorder.dto;

import java.util.List;

public class ASNCombinedDto {

	private ASNDto asn;
	private List<ASNPOItemDetailsDto> asnDetails;

	public ASNDto getAsn() {
		return asn;
	}

	public void setAsn(ASNDto asn) {
		this.asn = asn;
	}

	public List<ASNPOItemDetailsDto> getAsnDetails() {
		return asnDetails;
	}

	public void setAsnDetails(List<ASNPOItemDetailsDto> asnDetails) {
		this.asnDetails = asnDetails;
	}

	public ASNCombinedDto(ASNDto asn, List<ASNPOItemDetailsDto> asnDetails) {
		super();
		this.asn = asn;
		this.asnDetails = asnDetails;
	}

	@Override
	public String toString() {
		return "ASNCombinedDto [asn=" + asn + ", asnDetails=" + asnDetails + "]";
	}

}
