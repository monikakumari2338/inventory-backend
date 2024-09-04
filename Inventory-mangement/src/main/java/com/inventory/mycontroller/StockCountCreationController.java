package com.inventory.mycontroller;

import java.time.LocalDate;

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

import com.inventory.mydto.InventoryAdjustmentCombinedDto;
import com.inventory.mydto.SCLandingDto;
import com.inventory.mydto.ScReturnDto;
import com.inventory.mydto.StockCountAdhocCreationCombinedDto;
import com.inventory.mydto.StockCountCombinedDto;
import com.inventory.mydto.StockCountCreationDto;
import com.inventory.mydto.StockCountUpdateCombinedDto;
import com.inventory.myservice.StockCountCreationService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/stockcount")
@SecurityRequirement(name = "bearerAuth")
public class StockCountCreationController {

	@Autowired
	private StockCountCreationService scCreationService;

	// Api to create System stock count
	@PostMapping("/Create/SystemStockCount/{store}/{date1}/{date2}")
	public ResponseEntity<String> createSystemStockCount(@PathVariable String store, @PathVariable LocalDate date1,
			@PathVariable LocalDate date2) {
		String countId = scCreationService.createSystemStockCount(store, date1, date2);
		return new ResponseEntity<>(countId, HttpStatus.OK);
	}

	// Api to add products in created System stock count
	@PostMapping("/add/SystemCountProducts")
	public ResponseEntity<String> saveSystemCountProducts(@RequestBody StockCountCreationDto creationDto) {
		String success = scCreationService.saveSystemCountProducts(creationDto);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// Api to create System stock count
	@PostMapping("/Create/AdhocstockCount/{store}/{date1}/{date2}/{reason}")
	public ResponseEntity<ScReturnDto> createAdhocstockCount(@PathVariable String store, @PathVariable LocalDate date1,
			@PathVariable LocalDate date2, @PathVariable String reason) {
		ScReturnDto ScDto = scCreationService.createAdhocstockCount(store, date1, date2, reason);
		return new ResponseEntity<>(ScDto, HttpStatus.OK);
	}

	// Api to add products in created System stock count
	@PostMapping("/add/AdhocProducts")
	public ResponseEntity<String> saveSystemCountProducts(@RequestBody StockCountAdhocCreationCombinedDto adhocDto) {
		String success = scCreationService.saveAdhocProducts(adhocDto);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// Api to get all Stock Counts
	@GetMapping("/all/StockCounts")
	public ResponseEntity<List<SCLandingDto>> getAllStockCounts() {
		List<SCLandingDto> scList = scCreationService.getAllStockCount();
		return new ResponseEntity<>(scList, HttpStatus.OK);
	}

	// Api to get reason Codes
	@GetMapping("/reasoncodes")
	public ResponseEntity<List<String>> getReasonCodes() {
		List<String> codes = scCreationService.getScReasonCodes();
		return new ResponseEntity<>(codes, HttpStatus.OK);
	}

	// Api to get SC products by count id
	@GetMapping("/products/id/{countId}")
	public ResponseEntity<StockCountCombinedDto> getAllInventoryadjustmentProductsByID(@PathVariable String countId) {
		StockCountCombinedDto scProductsList = scCreationService.getStockCountProductsByCountId(countId);
		return new ResponseEntity<>(scProductsList, HttpStatus.OK);
	}

	// Api to update products Qty in created System stock count
	@PostMapping("/update/count/recount")
	public ResponseEntity<String> updateCountRecountInStockCount(
			@RequestBody StockCountUpdateCombinedDto ScUpdateCombinedDto) {
		String success = scCreationService.updateStockCount(ScUpdateCombinedDto);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// Api to get sort dsd by latest date
	@GetMapping("/sort/latest/SC")
	public ResponseEntity<List<SCLandingDto>> sortLatestStockCount() {
		List<SCLandingDto> sortedList = scCreationService.sortStockCountsByLatest();
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to get sort dsd by oldest date
	@GetMapping("/sort/oldest/SC")
	public ResponseEntity<List<SCLandingDto>> sortOldestStockCount() {
		List<SCLandingDto> sortedList = scCreationService.sortStockCountsByOldest();
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to get filtered SC by reason or status
	@GetMapping("/filter/SC/{param}")
	public ResponseEntity<List<SCLandingDto>> filterStockCountsByReasonOrStatus(@PathVariable String param) {
		List<SCLandingDto> sortedList = scCreationService.filterStockCountsByReasonOrStatus(param);
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to do an elastic search on SC by Id
	@GetMapping("/search/SC/{id}")
	public ResponseEntity<List<SCLandingDto>> searchAdjustmentById(@PathVariable String id) {
		List<SCLandingDto> searchedSc = scCreationService.getMatchedStockCounts(id);
		return new ResponseEntity<>(searchedSc, HttpStatus.OK);
	}

	// Api to draft SC
	@PostMapping("/draft/SC/{countType}")
	public ResponseEntity<String> draftStockCount(@RequestBody StockCountAdhocCreationCombinedDto ScUpdateCombinedDto,
			@PathVariable String countType) {
		String success = scCreationService.draftStockCount(ScUpdateCombinedDto, countType);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}
}
