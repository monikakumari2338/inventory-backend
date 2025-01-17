package com.inventory.email.service;

import com.inventory.email.jpa.entity.EmailRequest;

public interface EmailService {

	void sendEmail(EmailRequest emailRequest);

	void sendDiscrepancyEmail(EmailRequest emailRequest);

	void sendDsdDiscrepancyEmail(EmailRequest emailRequest);

	void sendTransfersDiscrepancyEmail(EmailRequest emailRequest);
}
