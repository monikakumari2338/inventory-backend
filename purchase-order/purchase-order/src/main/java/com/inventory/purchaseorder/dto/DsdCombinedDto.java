package com.inventory.purchaseorder.dto;

import java.util.List;

public class DsdCombinedDto {

	private DsdDto dsd;
	private List<DsdItemsdto> DsdItems;

	public DsdDto getDsd() {
		return dsd;
	}

	public void setDsd(DsdDto dsd) {
		this.dsd = dsd;
	}

	public List<DsdItemsdto> getDsdItems() {
		return DsdItems;
	}

	public void setDsdItems(List<DsdItemsdto> dsdItems) {
		DsdItems = dsdItems;
	}

	public DsdCombinedDto(DsdDto dsd, List<DsdItemsdto> dsdItems) {
		super();
		this.dsd = dsd;
		DsdItems = dsdItems;
	}

}
