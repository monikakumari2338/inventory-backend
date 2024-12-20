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
import com.inventory.purchaseorder.dto.ReturnToVendorCombinedDto;
import com.inventory.purchaseorder.entity.RTVInfo;
import com.inventory.purchaseorder.entity.RTVProducts;
import com.inventory.purchaseorder.entity.RtvReasonCodes;
import com.inventory.purchaseorder.entity.Suppliers;
import com.inventory.purchaseorder.service.ReturnToVendorService;

@RestController
@RequestMapping("/returntovendor")
public class ReturnToVendorController {

	@Autowired
	private ReturnToVendorService RTVService;

	// Api to save RTV list
	@PostMapping("/create/rtv")
	public ResponseEntity<String> add_Products(@RequestBody ReturnToVendorCombinedDto RTVCombinedDto) {
		String id = RTVService.generateRandomString();
		String success_msg = RTVService.saveProducts(RTVCombinedDto, id);
		return new ResponseEntity<>(success_msg, HttpStatus.OK);
	}

	// Api to get RTV Items by ID
	@GetMapping("/rtvitems/{rtvId}")
	public ResponseEntity<List<RTVProducts>> getRTVProducts(@PathVariable String rtvId) {
		List<RTVProducts> rtvProducts = RTVService.getRTVProductsbyId(rtvId);
		return new ResponseEntity<>(rtvProducts, HttpStatus.OK);
	}

	// Api to get RTV list
	@GetMapping("/getallrtv")
	public ResponseEntity<List<RTVInfo>> getAllRTV() {
		List<RTVInfo> AllRtv = RTVService.getAllVendorReturn();
		return new ResponseEntity<>(AllRtv, HttpStatus.OK);
	}

	// Api to get Dispatch RTV by id
	@GetMapping("/dispatch/rtv/{rtvId}")
	public ResponseEntity<String> dispatchRTV(@PathVariable String rtvId) {
		String msg = RTVService.dispatchRTV(rtvId);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	// Api to get all suppliers
	@GetMapping("/getall/suppliers")
	public ResponseEntity<List<Suppliers>> getAllSuppliers() {
		List<Suppliers> suppliers = RTVService.getAllSuppliers();
		return new ResponseEntity<>(suppliers, HttpStatus.OK);
	}

	// Api to get RTV list
	@GetMapping("/getall/reasonCodes")
	public ResponseEntity<List<RtvReasonCodes>> getRtvReasonCodes() {
		List<RtvReasonCodes> reasonCodes = RTVService.getRtvReasonCodes();
		return new ResponseEntity<>(reasonCodes, HttpStatus.OK);
	}

	@GetMapping("/matched/supplier/{name}")
	public ResponseEntity<List<Suppliers>> getMatchedSuppliersBySupplierName(@PathVariable String name) {
		List<Suppliers> suppliers = RTVService.getMatchedSuppliersBySupplierName(name);
		return new ResponseEntity<>(suppliers, HttpStatus.OK);
	}

}
