package com.inventory.tsf.jpa.dto;

import java.time.LocalDate;
import java.util.List;

import com.inventory.rtv.jpa.dto.RtvProductsdto;

public class TSFCombinedDto {

	private String id;
	private String reason;
	private String image;
	private LocalDate notAfter;
	private LocalDate notBefore;
	private List<RtvProductsdto> tsfDetailsDto;

	public LocalDate getNotAfter() {
		return notAfter;
	}

	public void setNotAfter(LocalDate notAfter) {
		this.notAfter = notAfter;
	}

	public LocalDate getNotBefore() {
		return notBefore;
	}

	public void setNotBefore(LocalDate notBefore) {
		this.notBefore = notBefore;
	}

	public List<RtvProductsdto> getTsfDetailsDto() {
		return tsfDetailsDto;
	}

	public void setTsfDetailsDto(List<RtvProductsdto> tsfDetailsDto) {
		this.tsfDetailsDto = tsfDetailsDto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public TSFCombinedDto(String id, String reason, String image, LocalDate notAfter, LocalDate notBefore,
			List<RtvProductsdto> tsfDetailsDto) {
		super();
		this.id = id;
		this.reason = reason;
		this.image = image;
		this.notAfter = notAfter;
		this.notBefore = notBefore;
		this.tsfDetailsDto = tsfDetailsDto;
	}

}
