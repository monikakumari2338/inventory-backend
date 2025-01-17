package com.inventory.sc.jpa.dto;

import java.util.List;

public class AdhocCombinedDto {

	private AdhocCountdto adhocCountdto;
	private List<AdhocCountDetailsdto> adhocCountDetails;

	public AdhocCountdto getAdhocCountdto() {
		return adhocCountdto;
	}

	public void setAdhocCountdto(AdhocCountdto adhocCountdto) {
		this.adhocCountdto = adhocCountdto;
	}

	public List<AdhocCountDetailsdto> getAdhocCountDetails() {
		return adhocCountDetails;
	}

	public void setAdhocCountDetails(List<AdhocCountDetailsdto> adhocCountDetails) {
		this.adhocCountDetails = adhocCountDetails;
	}

	public AdhocCombinedDto(AdhocCountdto adhocCountdto, List<AdhocCountDetailsdto> adhocCountDetails) {
		super();
		this.adhocCountdto = adhocCountdto;
		this.adhocCountDetails = adhocCountDetails;
	}

}
