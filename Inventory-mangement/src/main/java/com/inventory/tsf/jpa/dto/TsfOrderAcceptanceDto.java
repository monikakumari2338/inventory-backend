package com.inventory.tsf.jpa.dto;

import java.util.List;

public class TsfOrderAcceptanceDto {

	private String tsfId;
	private String status;
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

	public TsfOrderAcceptanceDto(String tsfId, String status, List<TsfDetailsUpdationDto> tsfDetailsUpdationDto) {
		super();
		this.tsfId = tsfId;
		this.status = status;
		this.tsfDetailsUpdationDto = tsfDetailsUpdationDto;
	}

}
