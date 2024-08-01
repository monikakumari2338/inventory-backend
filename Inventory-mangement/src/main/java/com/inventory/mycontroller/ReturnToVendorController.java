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
import com.inventory.mydto.InventoryAdjustmentCombinedDto;
import com.inventory.mydto.RtvCombinedDto;
import com.inventory.mydto.RtvInfoDto;
import com.inventory.myservice.ReturnToVendorService;

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

	
}
