package com.inventory.rtv.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.adjustments.jpa.dto.InventoryAdjustmentCombinedDto;
import com.inventory.dsd.jpa.dto.DSDLandingDto;
import com.inventory.rtv.jpa.dto.RtvCombinedDto;
import com.inventory.rtv.jpa.dto.RtvGetItemsDto;
import com.inventory.rtv.jpa.dto.RtvInfoDto;
import com.inventory.rtv.service.ReturnToVendorService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/returntovendor")
@SecurityRequirement(name = "bearerAuth")
public class ReturnToVendorController {

	@Autowired
	private ReturnToVendorService RTVService;

	// Api to create RTV
	@PostMapping("/create/rtv/{store}/{user}")
	public ResponseEntity<RtvInfoDto> createRTV(@PathVariable String store, @PathVariable String user) {
		RtvInfoDto rtv = RTVService.createRTV(store, user);
		return new ResponseEntity<>(rtv, HttpStatus.OK);
	}

	// Api to add products in created RTV
	@PostMapping("/save/rtv/products")
	public ResponseEntity<String> saveProducts(@RequestBody RtvCombinedDto rtvCombinedDto) {
		String success = RTVService.saveRtvProducts(rtvCombinedDto);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// Api to get reason Codes
	@GetMapping("/reasoncodes")
	public ResponseEntity<List<String>> getReasonCodes() {
		List<String> codes = RTVService.getRtvReasonCodes();
		return new ResponseEntity<>(codes, HttpStatus.OK);
	}

	// Api to get all Rtv
	@GetMapping("/all/rtv")
	public ResponseEntity<List<DSDLandingDto>> getAllInventoryadjustments() {
		List<DSDLandingDto> rtv = RTVService.getAllVendorReturn();
		return new ResponseEntity<>(rtv, HttpStatus.OK);
	}

	// Api to get products in IA
	@GetMapping("/getRtv/products/id/{rtvID}/{store}")
	public ResponseEntity<RtvGetItemsDto> getRtvProductsByID(@PathVariable String rtvID, @PathVariable String store) {
		RtvGetItemsDto products = RTVService.getRTVProductsbyId(rtvID, store);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	// Api to get sort rtv by latest date
	@GetMapping("/sort/latest/rtv")
	public ResponseEntity<List<DSDLandingDto>> sortLatestAdjustments() {
		List<DSDLandingDto> sortedList = RTVService.sortRtvByLatest();
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to get sort rtv by oldest date
	@GetMapping("/sort/oldest/rtv")
	public ResponseEntity<List<DSDLandingDto>> sortOldestAdjustments() {
		List<DSDLandingDto> sortedList = RTVService.sortRtvByOldest();
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to get filtered rtv by reason or status
	@GetMapping("/filter/rtv/{reasonOrStatus}")
	public ResponseEntity<List<DSDLandingDto>> filterRtv(@PathVariable String reasonOrStatus) {
		List<DSDLandingDto> sortedList = RTVService.filtersByReasonOrStatus(reasonOrStatus);
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to do an elastic search on rtv by Id
	@GetMapping("/search/rtv/{id}")
	public ResponseEntity<List<DSDLandingDto>> searchRtvById(@PathVariable String id) {
		List<DSDLandingDto> searchedAdjustment = RTVService.getMatchedRtvByid(id);
		return new ResponseEntity<>(searchedAdjustment, HttpStatus.OK);
	}

	@PostMapping("/save/draft/rtv")
	public ResponseEntity<String> saveDraftRtv(@RequestBody RtvCombinedDto rtvCombinedDto) {
		String success_msg = RTVService.draftRTV(rtvCombinedDto);
		return new ResponseEntity<>(success_msg, HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/delete/byid/{id}")
	public ResponseEntity<String> deleteById(@PathVariable String id) {
		String success = RTVService.deleteRTVbyId(id);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

}
