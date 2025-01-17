package com.inventory.dashboard.jpa.dto;

public class MyTasksDto {

	private String module;
	private float percentageValue;
	private int pendingValue;
	private String pendingLabel;

	public MyTasksDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public float getPercentageValue() {
		return percentageValue;
	}

	public void setPercentageValue(float percentageValue) {
		this.percentageValue = percentageValue;
	}

	public int getPendingValue() {
		return pendingValue;
	}

	public void setPendingValue(int pendingValue) {
		this.pendingValue = pendingValue;
	}

	public String getPendingLabel() {
		return pendingLabel;
	}

	public void setPendingLabel(String pendingLabel) {
		this.pendingLabel = pendingLabel;
	}

	public MyTasksDto(String module, float percentageValue, int pendingValue, String pendingLabel) {
		super();
		this.module = module;
		this.percentageValue = percentageValue;
		this.pendingValue = pendingValue;
		this.pendingLabel = pendingLabel;
	}

	@Override
	public String toString() {
		return "MyTasksDto [module=" + module + ", percentageValue=" + percentageValue + ", pendingValue="
				+ pendingValue + ", pendingLabel=" + pendingLabel + "]";
	}

}
