//package com.inventory.purchaseorder.controller;
//
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.inventory.purchaseorder.dto.ProductCombineddto;
//import com.inventory.purchaseorder.dto.TransferReceiveInfodto;
//import com.inventory.purchaseorder.dto.TransferReceiveProductsdto;
//import com.inventory.purchaseorder.entity.ASN;
//import com.inventory.purchaseorder.entity.DsdInvoice;
//import com.inventory.purchaseorder.entity.PurchaseOrder;
//import com.inventory.purchaseorder.entity.TransferReceiveInfo;
//import com.inventory.purchaseorder.service.TransferReceiveService;
//
//@RestController
//@RequestMapping("/transferreceive")
//public class TransferReceiveController {
//
//	@Autowired
//	private TransferReceiveService transferReceiveService;
//
//	// Api to save Transfer-Receive info in the Transfer Receive info table
//	@PostMapping("/save/transfer/info")
//	public ResponseEntity<String> saveTransferReceiveInfo(@RequestBody TransferReceiveInfodto transferReceiveInfo) {
//		String sucess_msg = transferReceiveService.save_transferInfo(transferReceiveInfo);
//		return new ResponseEntity<>(sucess_msg, HttpStatus.OK);
//	}
//
//	// Api to save Transfer-Receive products in the Transfer Receive products table
//	@PostMapping("/save/transfer/products")
//	public ResponseEntity<TransferReceiveProductsdto> saveTransferReceiveProducts(
//			@RequestBody TransferReceiveProductsdto transferReceiveProductsdto) {
//		TransferReceiveProductsdto transferReceiveProductsdto1 = transferReceiveService
//				.saveTransferReceive(transferReceiveProductsdto);
//		return new ResponseEntity<>(transferReceiveProductsdto1, HttpStatus.OK);
//	}
//
//	// Api to get Transfer-Receive id on the basis of ASN
//	@GetMapping("/getall/transferid/{asnNumber}")
//	public ResponseEntity<List<TransferReceiveInfodto>> getDSD(@PathVariable String asnNumber) {
//		List<TransferReceiveInfodto> transferReceiveInfo = transferReceiveService.getTransferId(asnNumber);
//		return new ResponseEntity<>(transferReceiveInfo, HttpStatus.OK);
//	}
//
//	@PostMapping("/savetransferproduct/{transferid}")
//	public ResponseEntity<List<ProductCombineddto>> saveDsdProducts(
//			@RequestBody List<ProductCombineddto> productCombineddto, @PathVariable int transferid) {
//		List<ProductCombineddto> DsdReceiveItemsdto1 = transferReceiveService
//				.saveTransferRecieveProducts(productCombineddto, transferid);
//		return new ResponseEntity<>(DsdReceiveItemsdto1, HttpStatus.OK);
//	}
//
//	// Api to get Transfer-Receive products on the basis of transferId
//	@GetMapping("/findby/transferid/{transferid}")
//	public ResponseEntity<List<TransferReceiveProductsdto>> getTransferReceiveProducts(@PathVariable int transferid) {
//		List<TransferReceiveProductsdto> transferReceiveProductsdto = transferReceiveService
//				.getTransferReceiveProducts(transferid);
//		return new ResponseEntity<>(transferReceiveProductsdto, HttpStatus.OK);
//	}
//
//	//Api to get all asn id mapped with transfer receive 
//	@GetMapping("/asn")
//	public ResponseEntity<Set<String>> getAllASN() {
//		Set<String> asnList = transferReceiveService.getAllAsnIdFromTransferReceive();
//		return new ResponseEntity<>(asnList, HttpStatus.OK);
//	}
//	
//	//Api to get all asn id mapped with transfer receive 
//		@GetMapping("/alltransferreceive")
//		public ResponseEntity<List<TransferReceiveInfo>> getAllTransferReceive() {
//			List<TransferReceiveInfo> transferInfoList = transferReceiveService.getAllTransferReceive();
//			return new ResponseEntity<>(transferInfoList, HttpStatus.OK);
//		}
//
//}
