package com.inventory.purchaseorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.purchaseorder.dto.InventoryAdjustmentCombinedDto;

import com.inventory.purchaseorder.entity.InventoryAdjustment;
import com.inventory.purchaseorder.entity.InventoryAdjustmentProducts;
import com.inventory.purchaseorder.service.InventoryAdjustmentService;

@RestController
@RequestMapping("/inventoryadjustment")
public class InventoryAdjustmentController {

	@Autowired
	private InventoryAdjustmentService inventoryAdjustmentService;

	// Api to save data in Purchase order table
	@PostMapping("/creation")
	public ResponseEntity<String> add_Products(
			@RequestBody InventoryAdjustmentCombinedDto inventoryAdjustmentCombinedDto) {
		// System.out.println("inventoryAdjustmentCombinedDto :" +
		// inventoryAdjustmentCombinedDto);
		String success = inventoryAdjustmentService.saveInventoryAdjustment(inventoryAdjustmentCombinedDto);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	@GetMapping("/reasoncodes")
	public ResponseEntity<List<String>> getReasonCodes() {
		List<String> codes = inventoryAdjustmentService.getAllReasonCodes();
		return new ResponseEntity<>(codes, HttpStatus.OK);
	}

	@GetMapping("/all/adjustments")
	public ResponseEntity<List<InventoryAdjustment>> getAllInventoryadjustments() {
		List<InventoryAdjustment> inventoryAdjustmentList = inventoryAdjustmentService.getAllInventoryAdjustment();
		return new ResponseEntity<>(inventoryAdjustmentList, HttpStatus.OK);
	}

	@GetMapping("/products/id/{adjID}")
	public ResponseEntity<List<InventoryAdjustmentProducts>> getAllInventoryadjustmentProductsByID(
			@PathVariable String adjID) {
		List<InventoryAdjustmentProducts> InventoryAdjustmentProductsList = inventoryAdjustmentService
				.getInventoryAdjustmentProductsByID(adjID);
		return new ResponseEntity<>(InventoryAdjustmentProductsList, HttpStatus.OK);
	}

}
