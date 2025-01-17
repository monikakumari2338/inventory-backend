package com.inventory.rtv.jpa.dto;

import java.util.List;

public class RtvCombinedDto {

	private String id;
	private String reason;
	private String status;
	private String supplierId;
	private String dispatchedUser;
	private String image;
	private List<RtvProductsdto> items;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getDispatchedUser() {
		return dispatchedUser;
	}

	public void setDispatchedUser(String dispatchedUser) {
		this.dispatchedUser = dispatchedUser;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<RtvProductsdto> getItems() {
		return items;
	}

	public void setItems(List<RtvProductsdto> items) {
		this.items = items;
	}

	public RtvCombinedDto(String id, String reason, String status, String supplierId, String dispatchedUser,
			String image, List<RtvProductsdto> items) {
		super();
		this.id = id;
		this.reason = reason;
		this.status = status;
		this.supplierId = supplierId;
		this.dispatchedUser = dispatchedUser;
		this.image = image;
		this.items = items;
	}

}
