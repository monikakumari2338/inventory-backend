package com.inventory.myservice;

import java.util.List;

import com.inventory.mydto.StoresDto;
import com.inventory.myentity.Product;
import com.inventory.myentity.Stores;

public interface StoreService {

	//StoresDto save_stores(StoresDto storesDto);
	List<Stores> getStores();
	String deleteStore(int id);
	StoresDto updateStore(int id, StoresDto storesDto);
	List<StoresDto> buddyStore(String itemNum, String color, String size);
	List<String> getMatchedStores(String store);
}
