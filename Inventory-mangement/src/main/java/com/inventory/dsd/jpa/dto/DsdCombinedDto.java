package com.inventory.dsd.jpa.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DsdCombinedDto {

	private String id;
	@NotBlank(message = "Status cannot be blank")
	@Size(max = 10, message = "status should be a character string with 100 character length")
	@Schema(description = "This is the status field.")
	private String status;
	private String supplierId;
	private int invoiceNumber;
	private String imageData;
	private int totalSku;
	private List<DsdItemsdto> items;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public int getTotalSku() {
		return totalSku;
	}

	public void setTotalSku(int totalSku) {
		this.totalSku = totalSku;
	}

	public List<DsdItemsdto> getItems() {
		return items;
	}

	public void setItems(List<DsdItemsdto> items) {
		this.items = items;
	}

	public DsdCombinedDto(String id, String status, String supplierId, int invoiceNumber, String imageData,
			int totalSku, List<DsdItemsdto> items) {
		super();
		this.id = id;
		this.status = status;
		this.supplierId = supplierId;
		this.invoiceNumber = invoiceNumber;
		this.imageData = imageData;
		this.totalSku = totalSku;
		this.items = items;
	}

}
