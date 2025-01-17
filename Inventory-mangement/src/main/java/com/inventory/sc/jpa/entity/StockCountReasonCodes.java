package com.inventory.sc.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class StockCountReasonCodes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int generatedId;
	@Size(min = 1, max = 30)
	@NotBlank
	private String reasonCode;

	public StockCountReasonCodes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getGeneratedId() {
		return generatedId;
	}

	public void setGeneratedId(int generatedId) {
		this.generatedId = generatedId;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public StockCountReasonCodes(int generatedId, String reasonCode) {
		super();
		this.generatedId = generatedId;
		this.reasonCode = reasonCode;
	}

}
