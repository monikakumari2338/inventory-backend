package com.inventory.purchaseorder.dto;

public class StoreAndInTransitInventorydto {

	private int inStore;
	private int inTransit;

	public int getInStore() {
		return inStore;
	}

	public void setInStore(int inStore) {
		this.inStore = inStore;
	}

	public int getInTransit() {
		return inTransit;
	}

	public void setInTransit(int inTransit) {
		this.inTransit = inTransit;
	}

	public StoreAndInTransitInventorydto(int inStore, int inTransit) {
		super();
		this.inStore = inStore;
		this.inTransit = inTransit;
	}

	public StoreAndInTransitInventorydto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StoreAndInTransitInventorydto [inStore=" + inStore + ", inTransit=" + inTransit + "]";
	}

}
