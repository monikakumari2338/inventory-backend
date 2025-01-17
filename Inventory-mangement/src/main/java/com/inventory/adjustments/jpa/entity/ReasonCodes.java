package com.inventory.adjustments.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class ReasonCodes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int generatedId;

	@Size(min = 1, max = 30)
	@NotBlank
	private String reason;

	public ReasonCodes() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ReasonCodes [generatedId=" + generatedId + ", reason=" + reason + "]";
	}

	public int getGeneratedId() {
		return generatedId;
	}

	public void setGeneratedId(int generatedId) {
		this.generatedId = generatedId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public ReasonCodes(int generatedId, String reason) {
		super();
		this.generatedId = generatedId;
		this.reason = reason;
	}

}
