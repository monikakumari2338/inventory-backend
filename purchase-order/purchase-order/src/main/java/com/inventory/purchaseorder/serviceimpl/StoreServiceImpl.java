package com.inventory.purchaseorder.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.purchaseorder.dto.StoresDto;
import com.inventory.purchaseorder.entity.Product;
import com.inventory.purchaseorder.entity.ProductDetails;
import com.inventory.purchaseorder.entity.Stores;
import com.inventory.purchaseorder.repository.ProductDetailsRepo;
import com.inventory.purchaseorder.repository.ProductRepo;
import com.inventory.purchaseorder.repository.StoreRepo;
import com.inventory.purchaseorder.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepo storeRepo;

	@Autowired
	private ProductDetailsRepo productDetailsRepo;

	@Autowired
	private ProductRepo productRepo;

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
	public List<StoresDto> buddyStore(String itemNum, String color, String size) {
		Product product = productRepo.findByItemNumber(itemNum);
		System.out.println("product : " + product);
		List<ProductDetails> productDetails = productDetailsRepo.findByProductAndColorAndSize(product, color, size);

		List<Stores> store = new ArrayList<>();
		List<StoresDto> storesDto = new ArrayList<>();
		for (int i = 0; i < productDetails.size(); i++) {
			store.add(storeRepo.findByStoreId(productDetails.get(i).getStore().getStoreId()));
			storesDto.add(new StoresDto(store.get(i).getStoreId(), store.get(i).getStoreName(),
					productDetails.get(i).getSellableStock(), store.get(i).getStoreAddress(),
					productDetails.get(i).getColor(), productDetails.get(i).getPrice(),
					productDetails.get(i).getSize(),productDetails.get(i).getImageData()));
		}

//		System.out.println("ProductDetails : " + productDetails);
//		System.out.println("store : " + store);
//		System.out.println("storesDto : " + storesDto);
		return storesDto;
	}

}
