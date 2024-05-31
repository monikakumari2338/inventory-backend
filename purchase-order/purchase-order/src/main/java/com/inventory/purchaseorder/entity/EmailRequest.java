package com.inventory.purchaseorder.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class EmailRequest {

	private MultipartFile attachment;

	public MultipartFile getAttachment() {
		return attachment;
	}

	public void setAttachment(MultipartFile attachment) {
		this.attachment = attachment;
	}

	public EmailRequest(MultipartFile attachment) {
		super();
		this.attachment = attachment;
	}

	public EmailRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
