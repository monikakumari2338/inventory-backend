package com.inventory.dsd.jpa.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "suppliers")
public class Suppliers {

	@Id
	@Size(min = 1, max = 10)
	@NotBlank
	private String supplierId;
	@Size(min = 1, max = 30)
	@NotBlank
	private String supplierName;
	@Size(min = 1, max = 30)
	@NotBlank
	private String contactPerson;
	@Size(min = 1, max = 30)
	@NotBlank
	private String email;
	@Size(min = 1, max = 12)
	@NotBlank
	private String contactNumber;
	@Size(min = 1, max = 100)
	@NotBlank
	private String address;

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
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

	public Suppliers(String supplierId, String supplierName, String contactPerson, String email, String contactNumber,
			String address) {
		super();
		this.supplierId = supplierId;
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
