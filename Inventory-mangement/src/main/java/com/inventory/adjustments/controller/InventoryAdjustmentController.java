package com.inventory.adjustments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.adjustments.jpa.dto.InventoryAdjustmentCombinedDto;
import com.inventory.adjustments.jpa.dto.InventoryAdjustmentLandingDto;
import com.inventory.adjustments.jpa.dto.InventoryAdjustmentProductsdto;
import com.inventory.adjustments.jpa.dto.InventoryAdjustmentdto;
import com.inventory.adjustments.jpa.entity.InventoryAdjustment;
import com.inventory.adjustments.jpa.entity.InventoryAdjustmentProducts;
import com.inventory.adjustments.service.InventoryAdjustmentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/inventoryadjustment")
@SecurityRequirement(name = "bearerAuth")
public class InventoryAdjustmentController {

	@Autowired
	private InventoryAdjustmentService inventoryAdjustmentService;

	// Api to create IA
	@PostMapping("/create/IA/{store}/{user}")
	public ResponseEntity<InventoryAdjustmentdto> createIA(@PathVariable String store, @PathVariable String user) {
		InventoryAdjustmentdto IA = inventoryAdjustmentService.createInventoryAdjustment(store, user);
		return new ResponseEntity<>(IA, HttpStatus.OK);
	}

	// Api to add products in created IA
	@PostMapping("/save/adj/products")
	public ResponseEntity<String> saveProducts(
			@RequestBody InventoryAdjustmentCombinedDto inventoryAdjustmentCombinedDto) {
		String success = inventoryAdjustmentService.saveInventoryAdjustmentProducts(inventoryAdjustmentCombinedDto);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// Save As draft
	@PostMapping("/saveAsDraft")
	public ResponseEntity<String> saveAsDraft(
			@RequestBody InventoryAdjustmentCombinedDto inventoryAdjustmentCombinedDto) {
		String success = inventoryAdjustmentService.IaSaveAsDraft(inventoryAdjustmentCombinedDto);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/delete/byid/{id}")
	public ResponseEntity<String> deleteById(@PathVariable String id) {
		String success = inventoryAdjustmentService.deleteByIaId(id);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// Api to get reason Codes
	@GetMapping("/reasoncodes")
	public ResponseEntity<List<String>> getReasonCodes() {
		List<String> codes = inventoryAdjustmentService.getAllReasonCodes();
		return new ResponseEntity<>(codes, HttpStatus.OK);
	}

	// Api to get all adjustments
	@GetMapping("/all/adjustments")
	public ResponseEntity<List<InventoryAdjustmentLandingDto>> getAllInventoryadjustments() {
		List<InventoryAdjustmentLandingDto> inventoryAdjustmentList = inventoryAdjustmentService
				.getAllInventoryAdjustment();
		return new ResponseEntity<>(inventoryAdjustmentList, HttpStatus.OK);
	}

	// Api to get products in IA
	@GetMapping("/products/id/{adjID}")
	public ResponseEntity<InventoryAdjustmentCombinedDto> getAllInventoryadjustmentProductsByID(
			@PathVariable String adjID) {
		InventoryAdjustmentCombinedDto InventoryAdjustmentProductsList = inventoryAdjustmentService
				.getInventoryAdjustmentProductsByID(adjID);
		return new ResponseEntity<>(InventoryAdjustmentProductsList, HttpStatus.OK);
	}

	// Api to get sort adjustments by latest date
	@GetMapping("/sort/latest/adjustments")
	public ResponseEntity<List<InventoryAdjustmentLandingDto>> sortLatestAdjustments() {
		List<InventoryAdjustmentLandingDto> sortedList = inventoryAdjustmentService.sortInventoryAdjustmentByLatest();
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to get sort adjustments by oldest date
	@GetMapping("/sort/oldest/adjustments")
	public ResponseEntity<List<InventoryAdjustmentLandingDto>> sortOldestAdjustments() {
		List<InventoryAdjustmentLandingDto> sortedList = inventoryAdjustmentService.sortInventoryAdjustmentByOldest();
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to get filtered adjustments by reason or status
	@GetMapping("/filter/adjustments/{param}")
	public ResponseEntity<List<InventoryAdjustmentLandingDto>> filterAdjustment(@PathVariable String param) {
		List<InventoryAdjustmentLandingDto> sortedList = inventoryAdjustmentService.filtersByReasonOrStatus(param);
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to do an elastic search on adjustments by Id
	@GetMapping("/search/adjustments/{id}")
	public ResponseEntity<List<InventoryAdjustmentLandingDto>> searchAdjustmentById(@PathVariable String id) {
		List<InventoryAdjustmentLandingDto> searchedAdjustment = inventoryAdjustmentService.getMatchedInvAdjByid(id);
		return new ResponseEntity<>(searchedAdjustment, HttpStatus.OK);
	}

	// Api to do an elastic search on items by sku for the provided adjustment id
	@GetMapping("/search/item/inadjustments/sku/{id}/{sku}")
	public ResponseEntity<List<InventoryAdjustmentProductsdto>> searchItemInAdjustmentById(@PathVariable String id,
			@PathVariable String sku) {
		List<InventoryAdjustmentProductsdto> searchedItem = inventoryAdjustmentService.getSearchedItemInAdjustment(id,
				sku);
		return new ResponseEntity<>(searchedItem, HttpStatus.OK);
	}

	// Api to do an elastic search on items by item name for the provided adjustment
	// id
	@GetMapping("/search/item/inadjustments/name/{id}/{name}")
	public ResponseEntity<List<InventoryAdjustmentProductsdto>> searchItemInAdjustmentByName(@PathVariable String id,
			@PathVariable String name) {
		List<InventoryAdjustmentProductsdto> searchedItem = inventoryAdjustmentService
				.getSearchedItemInAdjustmentByName(id, name);
		return new ResponseEntity<>(searchedItem, HttpStatus.OK);
	}
}
