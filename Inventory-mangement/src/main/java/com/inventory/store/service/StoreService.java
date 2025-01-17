package com.inventory.store.service;

import java.util.List;

import com.inventory.product.jpa.dto.ProductDetailsdto2;
import com.inventory.product.jpa.entity.Product;
import com.inventory.store.jpa.dto.BuddyStoresDto;
import com.inventory.store.jpa.dto.StoresDto;
import com.inventory.store.jpa.entity.Stores;

public interface StoreService {

	// StoresDto save_stores(StoresDto storesDto);
	List<Stores> getStores();

	String deleteStore(int id);

	StoresDto updateStore(int id, StoresDto storesDto);

	// List<StoresDto> buddyStore(String itemNum, String color, String size);

	List<String> getMatchedStores(String store);

	ProductDetailsdto2 getBuddyStoreProductDetails(String sku, String store);

	List<BuddyStoresDto> getAllbuddyStores(String sku, String loggedInStoreName);
}
