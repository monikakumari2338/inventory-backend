package com.inventory.store.service;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.myrepository.ProductDetailsRepo;
import com.inventory.myrepository.StoreRepo;
import com.inventory.product.jpa.dto.ProductDetailsdto2;
import com.inventory.product.jpa.entity.ProductDetails;
import com.inventory.store.jpa.dto.BuddyStoresDto;
import com.inventory.store.jpa.dto.StoresDto;
import com.inventory.store.jpa.entity.DistanceCalculator;
import com.inventory.store.jpa.entity.Stores;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepo storeRepo;

	@Autowired
	private ProductDetailsRepo productDetailsRepo;

//	@Autowired
//	private ProductRepo productRepo;

//	@Override
//	public StoresDto save_stores(StoresDto storesDto) {
//		Stores stores = new Stores(storesDto.getStoreId(), storesDto.getStoreName(), storesDto.getStoreStock(),
//				storesDto.getStoreAddress());
//
//		storeRepo.save(stores);
//
//		StoresDto storesdto = new StoresDto(stores.getStoreId(), stores.getStoreName(), stores.getStoreStock(),
//				stores.getStoreAddress());
//		return storesdto;
//	}

	@Override
	public List<Stores> getStores() {
		List<Stores> list = storeRepo.findAll();
		return list;
	}

	@Override
	public String deleteStore(int id) {
		storeRepo.deleteById(id);
		return "Store deleted successfully";
	}

	@Override
	public StoresDto updateStore(int id, StoresDto storesDto) {
		Stores store = storeRepo.findById(id).get();

		store.setStoreName(storesDto.getStoreName());
		store.setStoreStock(storesDto.getStoreStock());
		store.setStoreAddress(storesDto.getStoreAddress());

		Stores storeSaved = storeRepo.save(store);
		storesDto.setStoreId(storeSaved.getStoreId());
		storesDto.setStoreName(storeSaved.getStoreName());
		storesDto.setStoreAddress(storeSaved.getStoreAddress());
		storesDto.setStoreStock(storeSaved.getStoreStock());

		return storesDto;
	}

	@Override
	public ProductDetailsdto2 getBuddyStoreProductDetails(String sku, String storeName) {

		Stores store = storeRepo.findByStoreName(storeName);
		ProductDetails Product = productDetailsRepo.findBySkuAndStore(sku, store);

		if (Product != null && store != null) {
			ProductDetailsdto2 itemsDto = new ProductDetailsdto2(Product.getProduct().getItemNumber(),
					Product.getProduct().getitemName(), Product.getProduct().getCategory().getCategory(),
					Product.getColor(), Product.getSize(), Product.getPrice(), Product.getSku(), Product.getUpc(),
					Product.getSellableStock(), Product.getNonSellableStock(), Product.getImageData());

			return itemsDto;
		} else {
			return null;
		}

	}

	@Override
	public List<BuddyStoresDto> getAllbuddyStores(String sku, String loggedInStoreName) {

		List<ProductDetails> productDetails = productDetailsRepo.findAllBySku(sku);

		List<BuddyStoresDto> stores = new ArrayList<>();
		Stores loggedInStore = storeRepo.findByStoreName(loggedInStoreName);

		for (int i = 0; i < productDetails.size(); i++) {
			Stores store = storeRepo.findByStoreId(productDetails.get(i).getStore().getStoreId());
			double distance = DistanceCalculator.calculateDistance(loggedInStore.getLatitude(),
					loggedInStore.getLongitude(), store.getLatitude(), store.getLongitude());

			stores.add(new BuddyStoresDto(store.getStoreId(), store.getStoreName(),
					productDetails.get(i).getSellableStock(), store.getStoreAddress(), distance));
		}

		return stores;
	}

	@Override
	public List<String> getMatchedStores(String store) {
		List<Stores> stores = storeRepo.findByStoreNameContaining(store);
		List<String> storeList = new ArrayList<>();
		for (int i = 0; i < stores.size(); i++) {
			storeList.add(stores.get(i).getStoreName());

		}
		return storeList;
	}
}
