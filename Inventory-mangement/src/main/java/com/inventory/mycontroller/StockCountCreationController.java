package com.inventory.mycontroller;

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

import com.inventory.mydto.DSDLandingDto;
import com.inventory.mydto.StockCountAdhocCreationCombinedDto;
import com.inventory.mydto.StockCountCreationDto;
import com.inventory.myservice.StockCountCreationService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/stockcount")
@SecurityRequirement(name = "bearerAuth")
public class StockCountCreationController {

	@Autowired
	private StockCountCreationService scCreationService;

	// Api to create System stock count
	@PostMapping("/Create/SystemStockCount/{store}")
	public ResponseEntity<String> createSystemStockCount(@PathVariable String store) {
		String countId = scCreationService.createSystemStockCount(store);
		return new ResponseEntity<>(countId, HttpStatus.OK);
	}

	// Api to add products in created System stock count
	@PostMapping("/add/SystemCountProducts")
	public ResponseEntity<String> saveSystemCountProducts(@RequestBody StockCountCreationDto creationDto) {
		String success = scCreationService.saveSystemCountProducts(creationDto);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// Api to create System stock count
	@PostMapping("/Create/AdhocstockCount/{store}")
	public ResponseEntity<String> createAdhocstockCount(@PathVariable String store) {
		String countId = scCreationService.createAdhocstockCount(store);
		return new ResponseEntity<>(countId, HttpStatus.OK);
	}

	// Api to add products in created System stock count
	@PostMapping("/add/AdhocProducts")
	public ResponseEntity<String> saveSystemCountProducts(@RequestBody StockCountAdhocCreationCombinedDto adhocDto) {
		String success = scCreationService.saveAdhocProducts(adhocDto);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// Api to get all Stock Counts
	@GetMapping("/all/StockCounts")
	public ResponseEntity<List<DSDLandingDto>> getAllStockCounts() {
		List<DSDLandingDto> scList = scCreationService.getAllStockCount();
		return new ResponseEntity<>(scList, HttpStatus.OK);
	}

	// Api to get reason Codes
	@GetMapping("/reasoncodes")
	public ResponseEntity<List<String>> getReasonCodes() {
		List<String> codes = scCreationService.getScReasonCodes();
		return new ResponseEntity<>(codes, HttpStatus.OK);
	}
}
