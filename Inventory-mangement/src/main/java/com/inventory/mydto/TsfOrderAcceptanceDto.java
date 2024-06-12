package com.inventory.mydto;

import java.time.LocalDate;
import java.util.List;

public class TsfOrderAcceptanceDto {

	private String tsfId;
	private String status;
	private LocalDate date;
	private List<TsfDetailsUpdationDto> tsfDetailsUpdationDto;

	public String getTsfId() {
		return tsfId;
	}

	public void setTsfId(String tsfId) {
		this.tsfId = tsfId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<TsfDetailsUpdationDto> getTsfDetailsUpdationDto() {
		return tsfDetailsUpdationDto;
	}

	public void setTsfDetailsUpdationDto(List<TsfDetailsUpdationDto> tsfDetailsUpdationDto) {
		this.tsfDetailsUpdationDto = tsfDetailsUpdationDto;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public TsfOrderAcceptanceDto(String tsfId, String status, LocalDate date,
			List<TsfDetailsUpdationDto> tsfDetailsUpdationDto) {
		super();
		this.tsfId = tsfId;
		this.status = status;
		this.date = date;
		this.tsfDetailsUpdationDto = tsfDetailsUpdationDto;
	}

}
