package com.inventory.purchaseorder.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.inventory.purchaseorder.entity.EmailRequest;
import com.inventory.purchaseorder.entity.UserIdData;
import com.inventory.purchaseorder.repository.UserIdDetailsRepo;
import com.inventory.purchaseorder.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UserIdDetailsRepo userIdDetailsRepo;

	@Override
	public void sendEmail(EmailRequest emailRequest) {

		List<UserIdData> userIdData = userIdDetailsRepo.findAll();
		String[] emailIds = new String[userIdData.size()];

		for (int i = 0; i < userIdData.size(); i++) {
			emailIds[i] = userIdData.get(i).getEmail();
		}

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper1;
		try {
			helper1 = new MimeMessageHelper(message, true);

			helper1.setFrom("monika@gmail.com");
			helper1.setTo(emailIds);
			helper1.setText("Please find the stock count discrepancy attachment");
			helper1.setSubject("Stock Count Discrepancy Email");

			InputStreamSource source = new ByteArrayResource(emailRequest.getAttachment().getBytes());

			helper1.addAttachment("Todayscycle Report.pdf", source);
			javaMailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

	}

	@Override
	public void sendDiscrepancyEmail(EmailRequest emailRequest) {

		List<UserIdData> userIdData = userIdDetailsRepo.findAll();
		System.out.println("userIdData: " + userIdData);
		String[] emailIds = new String[userIdData.size()];

		for (int i = 0; i < userIdData.size(); i++) {
			emailIds[i] = userIdData.get(i).getEmail();
		}
		System.out.println("emailIds : " + emailIds);
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper1;
		try {
			helper1 = new MimeMessageHelper(message, true);

			helper1.setFrom("monika@gmail.com");
			helper1.setTo(emailIds);
			helper1.setText("Please find the purchase order discrepancy attachment");
			helper1.setSubject("Purchase Order Discrepancy Email");

			InputStreamSource source = new ByteArrayResource(emailRequest.getAttachment().getBytes());

			helper1.addAttachment("PO Discrepancy Report.pdf", source);
			javaMailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

	}

	@Override
	public void sendDsdDiscrepancyEmail(EmailRequest emailRequest) {

		List<UserIdData> userIdData = userIdDetailsRepo.findAll();
		String[] emailIds = new String[userIdData.size()];

		for (int i = 0; i < userIdData.size(); i++) {
			emailIds[i] = userIdData.get(i).getEmail();
		}
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper1;
		try {
			helper1 = new MimeMessageHelper(message, true);

			helper1.setFrom("monika@gmail.com");
			helper1.setTo(emailIds);
			helper1.setText("Please find the Direct Store Delivery order discrepancy attachment");
			helper1.setSubject("Direct Store Delivery Discrepancy Email");

			InputStreamSource source = new ByteArrayResource(emailRequest.getAttachment().getBytes());

			helper1.addAttachment("Dsd Discrepancy Report.pdf", source);
			javaMailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

	}
}
