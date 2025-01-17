package com.inventory.dsd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.adjustments.jpa.dto.InventoryAdjustmentCombinedDto;
import com.inventory.adjustments.jpa.dto.InventoryAdjustmentProductsdto;
import com.inventory.dsd.jpa.dto.DSDLandingDto;
import com.inventory.dsd.jpa.dto.DsdCombinedDto;
import com.inventory.dsd.jpa.dto.DsdDto;
import com.inventory.dsd.jpa.dto.DsdItemsdto;
import com.inventory.dsd.jpa.dto.SuppliersProductsDto;
import com.inventory.dsd.jpa.entity.SuppliersProducts;
import com.inventory.dsd.service.DSDService;
import com.inventory.email.jpa.entity.EmailRequest;
import com.inventory.email.service.EmailService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/dsd")
@SecurityRequirement(name = "bearerAuth")
public class DSDController {

	@Autowired
	private DSDService dsdService;

	@Autowired
	private EmailService emailService;

	// Api to create DSD
	@PostMapping("/create/Dsd/{store}/{user}")
	public ResponseEntity<DsdDto> createDsd(@PathVariable String store, @PathVariable String user) {
		DsdDto dsd = dsdService.createDsd(store, user);
		return new ResponseEntity<>(dsd, HttpStatus.OK);
	}

	// Api to add products in created DSD
	@PostMapping("/save/Dsd/products")
	public ResponseEntity<String> saveProducts(@RequestBody DsdCombinedDto inventoryAdjustmentCombinedDto) {
		String success = dsdService.saveDsd(inventoryAdjustmentCombinedDto);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// Api to get all DSD
	@GetMapping("/all/Dsd")
	public ResponseEntity<List<DSDLandingDto>> getAllDsd() {
		List<DSDLandingDto> dsdList = dsdService.getAllDSd();
		return new ResponseEntity<>(dsdList, HttpStatus.OK);
	}

	// Save As draft
	@PostMapping("/saveAsDraft")
	public ResponseEntity<String> saveAsDraft(@RequestBody DsdCombinedDto dsdCombinedDto) {
		String success = dsdService.DsdSaveAsDraft(dsdCombinedDto);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/delete/byid/{dsdNumber}")
	public ResponseEntity<String> deleteById(@PathVariable String dsdNumber) {
		String success = dsdService.deleteByDsdNumber(dsdNumber);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// Api to get products By Dsd Number
	@GetMapping("/products/DsdNumber/{DsdNumber}")
	public ResponseEntity<DsdCombinedDto> getAllInventoryadjustmentProductsByID(@PathVariable String DsdNumber) {
		DsdCombinedDto dsdProductsList = dsdService.getDsdProductsByID(DsdNumber);
		return new ResponseEntity<>(dsdProductsList, HttpStatus.OK);
	}

	// Api to get sort dsd by latest date
	@GetMapping("/sort/latest/Dsd")
	public ResponseEntity<List<DSDLandingDto>> sortLatestDsd() {
		List<DSDLandingDto> sortedList = dsdService.sortDsdByLatest();
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to get sort dsd by oldest date
	@GetMapping("/sort/oldest/Dsd")
	public ResponseEntity<List<DSDLandingDto>> sortOldestDsd() {
		List<DSDLandingDto> sortedList = dsdService.sortDsdByOldest();
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to get filtered adjustments by reason or status
	@GetMapping("/filter/Dsd/{supplierOrStatus}")
	public ResponseEntity<List<DSDLandingDto>> filterAdjustment(@PathVariable String supplierOrStatus) {
		List<DSDLandingDto> filteredList = dsdService.filtersBySupplierNameOrStatus(supplierOrStatus);
		return new ResponseEntity<>(filteredList, HttpStatus.OK);
	}

	// Api to save dsd items in Dsd and master table
	@PostMapping("/save/supplier/products")
	public ResponseEntity<String> saveSupplierItems(@RequestBody List<SuppliersProductsDto> SuppliersProducts) {
		String msg = dsdService.SaveSupplierProducts(SuppliersProducts);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	// Api to get Matched suppliers by supplier name or supplier id
	@GetMapping("/getMatched/suppliers/{supplierNameOrId}")
	public ResponseEntity<Map<String, String>> getMatchedSuppliers(@PathVariable String supplierNameOrId) {
		Map<String, String> suppliers = dsdService.getMatchedSuppliers(supplierNameOrId);
		return new ResponseEntity<>(suppliers, HttpStatus.OK);
	}

	// Api to get Matched DSD
	@GetMapping("/getMatched/Dsd/{DsdNumber}")
	public ResponseEntity<List<DSDLandingDto>> getMatchedDsd(@PathVariable String DsdNumber) {
		List<DSDLandingDto> dsd = dsdService.getMatchedDSD(DsdNumber);
		return new ResponseEntity<>(dsd, HttpStatus.OK);
	}

	// Api to do an elastic search on items by sku for the provided adjustment id
	@GetMapping("/search/item/inDsd/{id}/{sku}")
	public ResponseEntity<List<DsdItemsdto>> searchItemInDsdById(@PathVariable String id, @PathVariable String sku) {
		List<DsdItemsdto> searchedItem = dsdService.getSearchedItemInDsd(id, sku);
		return new ResponseEntity<>(searchedItem, HttpStatus.OK);
	}

	// Api to get product from suppliers product table
	@GetMapping("/get/supplier/products/{supplierId}/{sku}/{store}/{type}")
	public ResponseEntity<InventoryAdjustmentCombinedDto> getItemsToAddInDSD(@PathVariable String supplierId,
			@PathVariable String sku, @PathVariable String store, @PathVariable String type) {
		InventoryAdjustmentCombinedDto product = dsdService.getItemsToAdd(supplierId, sku, store, type);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	// Api to get unique product by sku from suppliers product table
	@GetMapping("/get/supplier/product/{supplierName}/{sku}/{store}")
	public ResponseEntity<InventoryAdjustmentCombinedDto> getSupplierItem(@PathVariable String supplierName,
			@PathVariable String sku, @PathVariable String store) {
		InventoryAdjustmentCombinedDto product = dsdService.getSupplierItem(supplierName, sku, store);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PostMapping(value = "send/Dsd_Discrepancy/Email", consumes = "multipart/form-data")
	public void sendPoDiscrepancyEmail(@ModelAttribute EmailRequest emailRequest) {
		System.out.println("Going to Send email: " + emailRequest.toString());
		emailService.sendDsdDiscrepancyEmail(emailRequest);
	}

}
