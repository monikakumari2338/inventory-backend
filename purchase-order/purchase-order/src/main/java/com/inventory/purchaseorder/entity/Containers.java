package com.inventory.purchaseorder.entity;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Containers {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence")
	@SequenceGenerator(name = "my_sequence", sequenceName = "my_sequence", initialValue = 80000)
	private int conatinerId;
	private String conatinerNumber;
	private int expectedQuantity;
	private int receivedQuantity;
	private LocalDate receivedDate;
	private String status;
	private String user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "asnId")
//	@JoinColumn(name = "asn", referencedColumnName = "asnNumber")
	private ASN asn;

	public int getConatinerId() {
		return conatinerId;
	}

	public ASN getAsn() {
		return asn;
	}

	public void setAsn(ASN asn) {
		this.asn = asn;
	}

	public void setConatinerId(int conatinerId) {
		this.conatinerId = conatinerId;
	}

	public String getConatinerNumber() {
		return conatinerNumber;
	}

	public void setConatinerNumber(String conatinerNumber) {
		this.conatinerNumber = conatinerNumber;
	}

	public int getExpectedQuantity() {
		return expectedQuantity;
	}

	public void setExpectedQuantity(int expectedQuantity) {
		this.expectedQuantity = expectedQuantity;
	}

	public int getReceivedQuantity() {
		return receivedQuantity;
	}

	public void setReceivedQuantity(int receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
	}

	public LocalDate getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDate receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Containers(String conatinerNumber, int expectedQuantity, int receivedQuantity, LocalDate receivedDate,
			String status, String user, ASN asn) {
		super();
		this.conatinerNumber = conatinerNumber;
		this.expectedQuantity = expectedQuantity;
		this.receivedQuantity = receivedQuantity;
		this.receivedDate = receivedDate;
		this.status = status;
		this.user = user;
		this.asn = asn;
	}

	public Containers() {
		super();
		// TODO Auto-generated constructor stub
	}

}
