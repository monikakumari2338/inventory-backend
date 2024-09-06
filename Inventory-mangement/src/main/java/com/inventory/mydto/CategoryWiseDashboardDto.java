package com.inventory.mydto;

public class CategoryWiseDashboardDto {

	private String category;
	private int actualCount;
	private int systemCount;

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

	public int getActualCount() {
		return actualCount;
	}

	public void setActualCount(int actualCount) {
		this.actualCount = actualCount;
	}

	public int getSystemCount() {
		return systemCount;
	}

	public void setSystemCount(int systemCount) {
		this.systemCount = systemCount;
	}

	public CategoryWiseDashboardDto(String category, int actualCount, int systemCount) {
		super();
		this.category = category;
		this.actualCount = actualCount;
		this.systemCount = systemCount;
	}

}
