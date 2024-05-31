package com.inventory.purchaseorder.service;

import com.inventory.purchaseorder.entity.EmailRequest;

public interface EmailService {

	void sendEmail(EmailRequest emailRequest);

	void sendDiscrepancyEmail(EmailRequest emailRequest);

	void sendDsdDiscrepancyEmail(EmailRequest emailRequest);
}
