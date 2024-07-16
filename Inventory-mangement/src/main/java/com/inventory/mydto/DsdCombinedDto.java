package com.inventory.mydto;

import java.util.List;

public class DsdCombinedDto {

	private String id;
	private String status;
	private String supplierName;
	private int totalSKU;
	private String attachedImage;
	private int invoiceNumber;
	private List<DsdItemsdto> DsdItems;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public int getTotalSKU() {
		return totalSKU;
	}

	public void setTotalSKU(int totalSKU) {
		this.totalSKU = totalSKU;
	}

	public String getAttachedImage() {
		return attachedImage;
	}

	public void setAttachedImage(String attachedImage) {
		this.attachedImage = attachedImage;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public List<DsdItemsdto> getDsdItems() {
		return DsdItems;
	}

	public void setDsdItems(List<DsdItemsdto> dsdItems) {
		DsdItems = dsdItems;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DsdCombinedDto(String id, String status, String supplierName, int totalSKU, String attachedImage,
			int invoiceNumber, List<DsdItemsdto> dsdItems) {
		super();
		this.id = id;
		this.status = status;
		this.supplierName = supplierName;
		this.totalSKU = totalSKU;
		this.attachedImage = attachedImage;
		this.invoiceNumber = invoiceNumber;
		DsdItems = dsdItems;
	}

	
}
