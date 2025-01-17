package com.inventory.tsf.jpa.dto;

import java.util.List;

public class TsfSaveReceivingDto {

	private String tsfId;
	private String image;
	private List<TsfDetailsSaveDto> tsfDetailsSaveDto;

	public String getTsfId() {
		return tsfId;
	}

	public void setTsfId(String tsfId) {
		this.tsfId = tsfId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<TsfDetailsSaveDto> getTsfDetailsSaveDto() {
		return tsfDetailsSaveDto;
	}

	public void setTsfDetailsSaveDto(List<TsfDetailsSaveDto> tsfDetailsSaveDto) {
		this.tsfDetailsSaveDto = tsfDetailsSaveDto;
	}

	public TsfSaveReceivingDto(String tsfId, String image, List<TsfDetailsSaveDto> tsfDetailsSaveDto) {
		super();
		this.tsfId = tsfId;
		this.image = image;
		this.tsfDetailsSaveDto = tsfDetailsSaveDto;
	}

}
