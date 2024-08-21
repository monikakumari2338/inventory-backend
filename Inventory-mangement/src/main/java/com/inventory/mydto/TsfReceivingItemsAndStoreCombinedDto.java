package com.inventory.mydto;

import java.time.LocalDate;
import java.util.List;

public class TsfReceivingItemsAndStoreCombinedDto {

	private String tsfId;
	private String status;
	private LocalDate notAfter;
	private LocalDate notBefore;
	private String storeFrom;
	private String storeTo;
	private String reason;
	private List<TsfDetailsGetReceivingDto> tsfDetailsDto;

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

	public List<TsfDetailsGetReceivingDto> getTsfDetailsDto() {
		return tsfDetailsDto;
	}

	public void setTsfDetailsDto(List<TsfDetailsGetReceivingDto> tsfDetailsDto) {
		this.tsfDetailsDto = tsfDetailsDto;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStoreFrom() {
		return storeFrom;
	}

	public void setStoreFrom(String storeFrom) {
		this.storeFrom = storeFrom;
	}

	public String getStoreTo() {
		return storeTo;
	}

	public void setStoreTo(String storeTo) {
		this.storeTo = storeTo;
	}

	public TsfReceivingItemsAndStoreCombinedDto(String tsfId, String status, LocalDate notAfter, LocalDate notBefore,
			String storeFrom, String storeTo, String reason, List<TsfDetailsGetReceivingDto> tsfDetailsDto) {
		super();
		this.tsfId = tsfId;
		this.status = status;
		this.notAfter = notAfter;
		this.notBefore = notBefore;
		this.storeFrom = storeFrom;
		this.storeTo = storeTo;
		this.reason = reason;
		this.tsfDetailsDto = tsfDetailsDto;
	}

	public TsfReceivingItemsAndStoreCombinedDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
