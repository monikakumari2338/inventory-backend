package com.inventory.mydto;

import java.time.LocalDate;

// This dto has been used to return adhoc creation object
public class ScReturnDto {

	private String id;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate CreationDate;

	public ScReturnDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		CreationDate = creationDate;
	}

	public ScReturnDto(String id, LocalDate startDate, LocalDate endDate, LocalDate creationDate) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.CreationDate = creationDate;
	}

}
