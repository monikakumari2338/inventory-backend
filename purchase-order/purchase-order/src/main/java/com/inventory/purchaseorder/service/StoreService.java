package com.inventory.purchaseorder.service;

import java.util.List;


import com.inventory.purchaseorder.dto.StoresDto;
import com.inventory.purchaseorder.entity.Product;
import com.inventory.purchaseorder.entity.Stores;

public interface StoreService {

	//StoresDto save_stores(StoresDto storesDto);
	List<Stores> getStores();
	String deleteStore(int id);
	StoresDto updateStore(int id, StoresDto storesDto);
	List<StoresDto> buddyStore(String itemNum, String color, String size);
}
