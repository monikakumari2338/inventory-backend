package com.inventory.purchaseorder.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.purchaseorder.dto.StoresDto;
import com.inventory.purchaseorder.entity.Stores;
import com.inventory.purchaseorder.service.StoreService;

@RestController
@RequestMapping("/store")
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
	public ResponseEntity<List> getStores()
	{
		List<Stores> list=storeService.getStores();
		return new ResponseEntity<>(list,HttpStatus.OK);	
	}
	
	@DeleteMapping("/deletestore/{id}")
	public ResponseEntity<String> deleteStore(@PathVariable int id)
	{
		storeService.deleteStore(id);
		return new ResponseEntity<>("Store deleted successfully",HttpStatus.OK);	
	}
	
	@PutMapping("/updatestore/{id}")
	public ResponseEntity<StoresDto> updateStore(@PathVariable int id, @RequestBody StoresDto storesdto)
	{
		storeService.updateStore(id, storesdto);
		return new ResponseEntity<>(storesdto,HttpStatus.OK);	
	}
	
	@GetMapping("/buddystores/{num}/{color}/{size}")
	public ResponseEntity<List<StoresDto>> getBuddyStores(@PathVariable String num,@PathVariable String color,@PathVariable String size)
	{
		List<StoresDto> storesDto=storeService.buddyStore(num, color, size);
		return new ResponseEntity<>(storesDto,HttpStatus.OK);	
	}
	
}
