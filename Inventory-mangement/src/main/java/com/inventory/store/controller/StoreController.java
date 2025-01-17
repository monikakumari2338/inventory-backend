package com.inventory.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.product.jpa.dto.ProductDetailsdto2;
import com.inventory.store.jpa.dto.BuddyStoresDto;
import com.inventory.store.jpa.dto.StoresDto;
import com.inventory.store.jpa.entity.Stores;
import com.inventory.store.service.StoreService;

@RestController
@RequestMapping("/store")
//@SecurityRequirement(name="bearerAuth")
public class StoreController {

	@Autowired
	private StoreService storeService;

//	@PostMapping("/addstore")
//	public ResponseEntity<StoresDto> add_store(@RequestBody StoresDto storesdto)
//	{
//		storeService.save_stores(storesdto);
//		return new ResponseEntity<>(storesdto,HttpStatus.OK);	
//	}

	@GetMapping("/getallstores")
	public ResponseEntity<List> getStores() {
		List<Stores> list = storeService.getStores();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@DeleteMapping("/deletestore/{id}")
	public ResponseEntity<String> deleteStore(@PathVariable int id) {
		storeService.deleteStore(id);
		return new ResponseEntity<>("Store deleted successfully", HttpStatus.OK);
	}

	@PutMapping("/updatestore/{id}")
	public ResponseEntity<StoresDto> updateStore(@PathVariable int id, @RequestBody StoresDto storesdto) {
		storeService.updateStore(id, storesdto);
		return new ResponseEntity<>(storesdto, HttpStatus.OK);
	}

	@GetMapping("/getBuddyStoreProductDetails/{sku}/{store}")
	public ResponseEntity<ProductDetailsdto2> getBuddyStoreProductDetails(@PathVariable String sku,
			@PathVariable String store) {
		ProductDetailsdto2 products = storeService.getBuddyStoreProductDetails(sku, store);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("get/all/buddystores/{sku}/{store}")
	public ResponseEntity<List<BuddyStoresDto>> getBuddyStores(@PathVariable String sku, @PathVariable String store) {
		List<BuddyStoresDto> stores = storeService.getAllbuddyStores(sku, store);
		return new ResponseEntity<>(stores, HttpStatus.OK);
	}

	@GetMapping("/getMatched/stores/{store}")
	public ResponseEntity<List<String>> getMatchedItemName(@PathVariable String store) {
		List<String> stores = storeService.getMatchedStores(store);
		return new ResponseEntity<>(stores, HttpStatus.OK);
	}

}
