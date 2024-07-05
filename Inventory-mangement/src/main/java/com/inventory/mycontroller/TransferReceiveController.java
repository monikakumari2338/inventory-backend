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

import com.inventory.mydto.TSFCombinedDto;
import com.inventory.mydto.TsfDetailsDto;
import com.inventory.mydto.TsfDetailsGetReceivingDto;
import com.inventory.mydto.TsfDetailsShipmentDto;
import com.inventory.mydto.TsfHeadDtoToGetTransfers;
import com.inventory.mydto.TsfOrderAcceptanceDto;
import com.inventory.mydto.TsfOrderAcceptanceStoreAndProductsDto;
import com.inventory.mydto.TsfReceivingItemsAndStoreCombinedDto;
import com.inventory.mydto.TsfSaveReceivingDto;
import com.inventory.mydto.TsfShipmentAndStoreCombinedDto;
import com.inventory.myentity.EmailRequest;
import com.inventory.myentity.TsfHead;
import com.inventory.myentity.TsfReasonCodes;
import com.inventory.myservice.EmailService;
import com.inventory.myservice.TransferReceiveService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/transferreceive")
@SecurityRequirement(name = "bearerAuth")
public class TransferReceiveController {

	@Autowired
	private TransferReceiveService transferReceiveService;

	@Autowired
	private EmailService emailService;

	// Api to create Transfer-Receive
	@PostMapping("/create/transfer")
	public ResponseEntity<String> saveTransferReceive(@RequestBody TSFCombinedDto tsfCombinedDto) {
		String tsfID = transferReceiveService.generateTsfId();
		String sucess_msg = transferReceiveService.createTansfer(tsfCombinedDto, tsfID);
		return new ResponseEntity<>(sucess_msg, HttpStatus.OK);
	}

	// Api to get all Transfers Reason Codes
	@GetMapping("/get/reasoncodes")
	public ResponseEntity<List<TsfReasonCodes>> getAllASN() {
		List<TsfReasonCodes> tsfReasonCodes = transferReceiveService.getTsfReasonCodes();
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
	public ResponseEntity<List<TsfHead>> getOutTransfers(@PathVariable String store) {
		List<TsfHead> transfers = transferReceiveService.getOutTransfers(store);
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

	// Api to create Transfer-Receive
	@PostMapping("/save/transfer")
	public ResponseEntity<String> saveTsfInMaster(@RequestBody TsfSaveReceivingDto tsfSaveReceivingDto) {
		String sucess_msg = transferReceiveService.SaveTSF(tsfSaveReceivingDto);
		return new ResponseEntity<>(sucess_msg, HttpStatus.OK);
	}

	// Api to send TSF Discrepancy Email
	@PostMapping(value = "send/Tsf_Discrepancy/Email", consumes = "multipart/form-data")
	public void sendPoDiscrepancyEmail(@ModelAttribute EmailRequest emailRequest) {
		System.out.println("Going to Send email: " + emailRequest.toString());
		emailService.sendTransfersDiscrepancyEmail(emailRequest);
	}

//	// Api to get all asn id mapped with transfer receive
//	@GetMapping("/alltransferreceive")
//	public ResponseEntity<List<TransferReceiveInfo>> getAllTransferReceive() {
//		List<TransferReceiveInfo> transferInfoList = transferReceiveService.getAllTransferReceive();
//		return new ResponseEntity<>(transferInfoList, HttpStatus.OK);
//	}

}
