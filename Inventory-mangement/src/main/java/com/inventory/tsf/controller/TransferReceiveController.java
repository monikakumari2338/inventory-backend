package com.inventory.tsf.controller;

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

import com.inventory.dsd.jpa.dto.DSDLandingDto;
import com.inventory.dsd.jpa.dto.DsdDto;
import com.inventory.email.jpa.entity.EmailRequest;
import com.inventory.email.service.EmailService;
import com.inventory.tsf.jpa.dto.TSFCombinedDto;
import com.inventory.tsf.jpa.dto.TSFLandingDto;
import com.inventory.tsf.jpa.dto.TsfDto;
import com.inventory.tsf.jpa.dto.TsfHeadDtoToGetTransfers;
import com.inventory.tsf.jpa.dto.TsfOrderAcceptanceDto;
import com.inventory.tsf.jpa.dto.TsfOrderAcceptanceStoreAndProductsDto;
import com.inventory.tsf.jpa.dto.TsfReceivingItemsAndStoreCombinedDto;
import com.inventory.tsf.jpa.dto.TsfSaveReceivingDto;
import com.inventory.tsf.jpa.dto.TsfShipmentAndStoreCombinedDto;
import com.inventory.tsf.jpa.entity.TsfHead;
import com.inventory.tsf.service.TransferReceiveService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/transferreceive")
@SecurityRequirement(name = "bearerAuth")
public class TransferReceiveController {

	@Autowired
	private TransferReceiveService transferReceiveService;

	@Autowired
	private EmailService emailService;

	// Api to create Transfer-Receive
	@PostMapping("/create/transfer/{storeFrom}/{user}/{storeTo}")
	public ResponseEntity<TsfDto> createRTV(@PathVariable String storeFrom, @PathVariable String user,
			@PathVariable String storeTo) {
		TsfDto tsf = transferReceiveService.createTransfer(storeFrom, user, storeTo);
		return new ResponseEntity<>(tsf, HttpStatus.OK);
	}

	// Api to add products in created Transfer
	@PostMapping("/add/tsf/products")
	public ResponseEntity<String> saveProducts(@RequestBody TSFCombinedDto tsfCombinedDto) {
		String success = transferReceiveService.saveTansfer(tsfCombinedDto);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// Api to get all Transfers Reason Codes
	@GetMapping("/get/reasoncodes")
	public ResponseEntity<List<String>> getAllASN() {
		List<String> tsfReasonCodes = transferReceiveService.getTsfReasonCodes();
		return new ResponseEntity<>(tsfReasonCodes, HttpStatus.OK);
	}

	// Api to get IN Transfer
	@GetMapping("/get/intransfers/{store}")
	public ResponseEntity<List<TsfHeadDtoToGetTransfers>> getInTransfers(@PathVariable String store) {
		List<TsfHeadDtoToGetTransfers> transfers = transferReceiveService.getInTransfers(store);
		return new ResponseEntity<>(transfers, HttpStatus.OK);
	}

	// Api to get OUT Transfer
	@GetMapping("/get/outtransfers/{store}")
	public ResponseEntity<List<TsfHeadDtoToGetTransfers>> getOutTransfers(@PathVariable String store) {
		List<TsfHeadDtoToGetTransfers> transfers = transferReceiveService.getOutTransfers(store);
		return new ResponseEntity<>(transfers, HttpStatus.OK);
	}

	// Api to get Transfer-Receive products on the basis of transferId
	@GetMapping("/getProducts/byTransferid/{transferid}")
	public ResponseEntity<TsfOrderAcceptanceStoreAndProductsDto> getTsfProductsById(@PathVariable String transferid) {
		TsfOrderAcceptanceStoreAndProductsDto products = transferReceiveService.getTsfProductsById(transferid);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	// Api to update TSF Head and TSF Details
	@PostMapping("/update/orderAcceptance")
	public ResponseEntity<String> updateTsfOnOrderAcceptance(@RequestBody TsfOrderAcceptanceDto tsfOrderAcceptanceDto) {
		// System.out.println("tsfOrderAcceptanceDto " + tsfOrderAcceptanceDto);
		String success_msg = transferReceiveService.updateTsfHeadandTsfDetails(tsfOrderAcceptanceDto);
		return new ResponseEntity<>(success_msg, HttpStatus.OK);
	}

	// Api to get Transfer-Receive products on the basis of transferId for Shipment
	@GetMapping("/getShipmentProducts/byTransferid/{transferid}")
	public ResponseEntity<TsfShipmentAndStoreCombinedDto> getTsfProductsByIdForShipment(
			@PathVariable String transferid) {
		TsfShipmentAndStoreCombinedDto products = transferReceiveService.getTsfProductsByIdForShipment(transferid);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	// Api to update TSF Head and TSF Details
	@PostMapping("/ship/tsf/{store}")
	public ResponseEntity<String> shipTsf(@RequestBody TsfOrderAcceptanceDto tsfOrderAcceptanceDto,
			@PathVariable String store) {
		String success_msg = transferReceiveService.ShipTsf(tsfOrderAcceptanceDto, store);
		return new ResponseEntity<>(success_msg, HttpStatus.OK);
	}

	// Api to get Transfer-Receive products on the basis of transferId to Receive
	@GetMapping("/getReceiving/items/byTransferid/{transferid}")
	public ResponseEntity<TsfReceivingItemsAndStoreCombinedDto> getTsfProductsByIdForReceiving(
			@PathVariable String transferid) {
		TsfReceivingItemsAndStoreCombinedDto products = transferReceiveService.getTsfToReceive(transferid);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	// Api to receive Transfer-Receive
	@PostMapping("/receive/transfer")
	public ResponseEntity<String> saveTsfInMaster(@RequestBody  TsfSaveReceivingDto tsfSaveReceivingDto) {
		String sucess_msg = transferReceiveService.SaveTSF(tsfSaveReceivingDto);
		return new ResponseEntity<>(sucess_msg, HttpStatus.OK);
	}

	// Api to send TSF Discrepancy Email
	@PostMapping(value = "send/Tsf_Discrepancy/Email", consumes = "multipart/form-data")
	public void sendPoDiscrepancyEmail(@ModelAttribute EmailRequest emailRequest) {
		System.out.println("Going to Send email: " + emailRequest.toString());
		emailService.sendTransfersDiscrepancyEmail(emailRequest);
	}

	// Api to get sort In Tsf by latest date
	@GetMapping("/sort/latest/In/Tsf/{store}")
	public ResponseEntity<List<TSFLandingDto>> sortLatestTransfers(@PathVariable String store) {
		List<TSFLandingDto> sortedList = transferReceiveService.sortInTsfByLatest(store);
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to get sort In Tsf by oldest date
	@GetMapping("/sort/oldest/In/Tsf/{store}")
	public ResponseEntity<List<TSFLandingDto>> sortOldestTransfers(@PathVariable String store) {
		List<TSFLandingDto> sortedList = transferReceiveService.sortInTsfByOldest(store);
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to get filtered In Tsf by reason or status
	@GetMapping("/filter/In/Tsf/{reasonOrStatus}/{store}")
	public ResponseEntity<List<TSFLandingDto>> filterTsf(@PathVariable String reasonOrStatus,
			@PathVariable String store) {
		List<TSFLandingDto> sortedList = transferReceiveService.filtersInTsfByReasonOrStatus(reasonOrStatus, store);
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to do an elastic search on In Tsf by Id
	@GetMapping("/search/In/Tsf/{id}/{store}")
	public ResponseEntity<List<TSFLandingDto>> searchRtvById(@PathVariable String id, @PathVariable String store) {
		List<TSFLandingDto> searchedAdjustment = transferReceiveService.getMatchedInTransfersByid(id, store);
		return new ResponseEntity<>(searchedAdjustment, HttpStatus.OK);
	}

	// Api to get sort Out Tsf by latest date
	@GetMapping("/sort/latest/Out/Tsf/{store}")
	public ResponseEntity<List<TSFLandingDto>> sortLatestOutTransfers(@PathVariable String store) {
		List<TSFLandingDto> sortedList = transferReceiveService.sortOutTsfByLatest(store);
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to get sort Out Tsf by oldest date
	@GetMapping("/sort/oldest/Out/Tsf/{store}")
	public ResponseEntity<List<TSFLandingDto>> sortOldestOutTransfers(@PathVariable String store) {
		List<TSFLandingDto> sortedList = transferReceiveService.sortOutTsfByOldest(store);
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to get filtered Out Tsf by reason or status
	@GetMapping("/filter/Out/Tsf/{reasonOrStatus}/{store}")
	public ResponseEntity<List<TSFLandingDto>> filterOutTsf(@PathVariable String reasonOrStatus,
			@PathVariable String store) {
		List<TSFLandingDto> sortedList = transferReceiveService.filtersOutTsfByReasonOrStatus(reasonOrStatus, store);
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to do an elastic search on Out Tsf by Id
	@GetMapping("/search/Out/Tsf/{id}/{store}")
	public ResponseEntity<List<TSFLandingDto>> searchOutTsfById(@PathVariable String id, @PathVariable String store) {
		List<TSFLandingDto> searchedAdjustment = transferReceiveService.getMatchedOutTransfersByid(id, store);
		return new ResponseEntity<>(searchedAdjustment, HttpStatus.OK);
	}

}
