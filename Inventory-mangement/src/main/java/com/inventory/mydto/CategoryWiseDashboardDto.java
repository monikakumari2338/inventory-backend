package com.inventory.mydto;

public class CategoryWiseDashboardDto {

	private String category;
	private double actualCount;
	private double systemCount;

	public CategoryWiseDashboardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getActualCount() {
		return actualCount;
	}

	public void setActualCount(double actualCount) {
		this.actualCount = actualCount;
	}

	public double getSystemCount() {
		return systemCount;
	}

	public void setSystemCount(double systemCount) {
		this.systemCount = systemCount;
	}

	public CategoryWiseDashboardDto(String category, double actualCount, double systemCount) {
		super();
		this.category = category;
		this.actualCount = actualCount;
		this.systemCount = systemCount;
	}

}
