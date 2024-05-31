package com.inventory.purchaseorder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "suppliers")
public class Suppliers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierId;
	private String supplierName;
	private String contactPerson;
	private String email;
	private String contactNumber;
	private String address;

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Suppliers(String supplierName, String contactPerson, String email, String contactNumber, String address) {
		super();
		this.supplierName = supplierName;
		this.contactPerson = contactPerson;
		this.email = email;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	@Override
	public String toString() {
		return "DsdSuppliers [supplierId=" + supplierId + ", supplierName=" + supplierName + ", contactPerson="
				+ contactPerson + ", email=" + email + ", contactNumber=" + contactNumber + ", address=" + address
				+ "]";
	}

	public Suppliers() {
		super();
		// TODO Auto-generated constructor stub
	}

}
