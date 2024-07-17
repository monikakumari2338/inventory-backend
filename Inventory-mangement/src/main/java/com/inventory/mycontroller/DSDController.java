package com.inventory.mycontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.mydto.DsdCombinedDto;
import com.inventory.mydto.SuppliersProductsDto;
import com.inventory.myentity.DSD;
import com.inventory.myentity.EmailRequest;
import com.inventory.myentity.SuppliersProducts;
import com.inventory.myservice.DSDService;
import com.inventory.myservice.EmailService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/dsd")
@SecurityRequirement(name = "bearerAuth")
public class DSDController {

	@Autowired
	private DSDService dsdService;

	@Autowired
	private EmailService emailService;

//	// Api to get dsd items on the basis of supplier
//	@GetMapping("/findby/supplier/{supplier}")
//	public ResponseEntity<List<DsdInvoice>> getDSD(@PathVariable int supplier) {
//		List<DsdInvoice> DsdReceiveItemsdto = dsdService.getDsdSupplierInvoices(supplier);
//		return new ResponseEntity<>(DsdReceiveItemsdto, HttpStatus.OK);
//	}
//
	// Api to save dsd items in Dsd and master table
	@PostMapping("/savedsd")
	public ResponseEntity<String> saveDSDItems(@RequestBody DsdCombinedDto dsdCombinedDto) {
		String msg = dsdService.saveDsd(dsdCombinedDto);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	// Api to get all DSD
//	@GetMapping("/getAlldsd")
//	public ResponseEntity<List<DSD>> getAllDSd() {
//		List<DSD> dsd_list = dsdService.getAllDSd();
//		return new ResponseEntity<>(dsd_list, HttpStatus.OK);
//	}

	// Api to get dsd products
//	@GetMapping("/get/dsdItems/{dsdNumber}")
//	public ResponseEntity<List<DsdItemsGetdto>> getDSdItems(@PathVariable int dsdNumber) {
//		List<DsdItemsGetdto> dsdItems = dsdService.getAllDSdItems(dsdNumber);
//		return new ResponseEntity<>(dsdItems, HttpStatus.OK);
//	}

	// Api to get damage dsd products
//	@GetMapping("/get/damage/dsdItems/{dsdNumber}")
//	public ResponseEntity<List<DsdItemsGetdto>> getDamageDSdItems(@PathVariable int dsdNumber) {
//		List<DsdItemsGetdto> dsdItems = dsdService.getDamageDSdItems(dsdNumber);
//		return new ResponseEntity<>(dsdItems, HttpStatus.OK);
//	}

	// Api to save dsd items in Dsd and master table
	@PostMapping("/save/supplier/products")
	public ResponseEntity<String> saveSupplierItems(@RequestBody List<SuppliersProductsDto> SuppliersProducts) {
		String msg = dsdService.SaveSupplierProducts(SuppliersProducts);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	// Api to get Matched suppliers
	@GetMapping("/getMatched/suppliers/{supplierName}")
	public ResponseEntity<List<String>> getMatchedSuppliers(@PathVariable String supplierName) {
		List<String> suppliers = dsdService.getMatchedSuppliers(supplierName);
		return new ResponseEntity<>(suppliers, HttpStatus.OK);
	}

	// Api to get product from suppliers product table
	@GetMapping("/add/dsd/products/{supplierName}/{sku}")
	public ResponseEntity<SuppliersProducts> getItemsToAddInDSD(@PathVariable String supplierName,
			@PathVariable String sku) {
		SuppliersProducts product = dsdService.getItemsToAdd(supplierName, sku);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PostMapping(value = "send/Dsd_Discrepancy/Email", consumes = "multipart/form-data")
	public void sendPoDiscrepancyEmail(@ModelAttribute EmailRequest emailRequest) {
		System.out.println("Going to Send email: " + emailRequest.toString());
		emailService.sendDsdDiscrepancyEmail(emailRequest);
	}

}
