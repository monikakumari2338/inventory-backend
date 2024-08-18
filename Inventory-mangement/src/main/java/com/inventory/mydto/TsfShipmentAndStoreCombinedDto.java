package com.inventory.mydto;

import java.time.LocalDate;
import java.util.List;

public class TsfShipmentAndStoreCombinedDto {

	private String tsfId;
	private String status;
	private LocalDate notAfter;
	private LocalDate notBefore;
	private int storeId;
	private String storeName;
	private String storeAddress;
	private String reason;
	private List<TsfDetailsShipmentDto> tsfDetailsDto;

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

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public List<TsfDetailsShipmentDto> getTsfDetailsDto() {
		return tsfDetailsDto;
	}

	public void setTsfDetailsDto(List<TsfDetailsShipmentDto> tsfDetailsDto) {
		this.tsfDetailsDto = tsfDetailsDto;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public TsfShipmentAndStoreCombinedDto(String tsfId, String status, LocalDate notAfter, LocalDate notBefore,
			int storeId, String storeName, String storeAddress, String reason,
			List<TsfDetailsShipmentDto> tsfDetailsDto) {
		super();
		this.tsfId = tsfId;
		this.status = status;
		this.notAfter = notAfter;
		this.notBefore = notBefore;
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.reason = reason;
		this.tsfDetailsDto = tsfDetailsDto;
	}

	public TsfShipmentAndStoreCombinedDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
