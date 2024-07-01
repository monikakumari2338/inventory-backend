package com.inventory.myentity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
public class AdjustmentOrRtvExcelUploadTemplate {

	@Id
	private int sNo;

	@NotNull(message = "AlphaNumeric field cannot be null")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "AlphaNumeric field must be alphanumeric")
	private String sku;

	@NotNull(message = "Numeric field cannot be null")
	@Positive(message = "Numeric field must be a positive number")
	private int inputQty;

	public AdjustmentOrRtvExcelUploadTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getInputQty() {
		return inputQty;
	}

	public void setInputQty(int inputQty) {
		this.inputQty = inputQty;
	}

	public AdjustmentOrRtvExcelUploadTemplate(int sNo,
			@NotNull(message = "AlphaNumeric field cannot be null") @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "AlphaNumeric field must be alphanumeric") String sku,
			@NotNull(message = "Numeric field cannot be null") @Positive(message = "Numeric field must be a positive number") int inputQty) {
		super();
		this.sNo = sNo;
		this.sku = sku;
		this.inputQty = inputQty;
	}

	@Override
	public String toString() {
		return "AdjustmentOrRtvExcelUploadTemplate [sNo=" + sNo + ", sku=" + sku + ", inputQty=" + inputQty + "]";
	}

}
