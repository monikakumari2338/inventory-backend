package com.inventory.purchaseorder.controller;

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

import com.inventory.purchaseorder.dto.ASNCombinedDto;
import com.inventory.purchaseorder.dto.ASNPOItemDetailsDto;
import com.inventory.purchaseorder.dto.AsnAndPOCombinedDto;
import com.inventory.purchaseorder.dto.PurchaseOrderCombinedDto;
import com.inventory.purchaseorder.dto.PurchaseOrderCombineddtotoSave;
import com.inventory.purchaseorder.dto.PurchaseOrderItemsGetDto3;
import com.inventory.purchaseorder.dto.PurchaseOrderItemsdto;
import com.inventory.purchaseorder.entity.DraftPurchaseOrderItems;
import com.inventory.purchaseorder.entity.EmailRequest;
import com.inventory.purchaseorder.service.EmailService;
import com.inventory.purchaseorder.service.PurchaseOrderService;

@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService POService;

	@Autowired
	private EmailService emailService;

	@PostMapping("/save/asn")
	public ResponseEntity<ASNCombinedDto> add_ASN(@RequestBody ASNCombinedDto aSNDto) {
		ASNCombinedDto asn = POService.saveASN(aSNDto);
		return new ResponseEntity<>(asn, HttpStatus.OK);
	}

	// Api to save data in Purchase order table
	@PostMapping("/save/po")
	public ResponseEntity<PurchaseOrderCombinedDto> add_PO(
			@RequestBody PurchaseOrderCombinedDto purchaseOrderCombinedDto) {
		PurchaseOrderCombinedDto purchase_order = POService.savePurchaseOrder(purchaseOrderCombinedDto);
		return new ResponseEntity<>(purchase_order, HttpStatus.OK);
	}

	@GetMapping("/findbyPO/{po}")
	public ResponseEntity<List<PurchaseOrderItemsdto>> findbyPO(@PathVariable int po) {
		List<PurchaseOrderItemsdto> purchaseOrderItems = POService.getPoItemsByPoNumber(po);
		return new ResponseEntity<>(purchaseOrderItems, HttpStatus.OK);
	}
	
	@GetMapping("/getPoSummary/{po}")
	public ResponseEntity<List<PurchaseOrderItemsdto>> getPoSummary(@PathVariable int po) {
		List<PurchaseOrderItemsdto> purchaseOrderItems = POService.getPoItemsSummaryByPoNumber(po);
		return new ResponseEntity<>(purchaseOrderItems, HttpStatus.OK);
	}


	@GetMapping("/getitemsby/asnnumber/{asn}")
	public ResponseEntity<List<ASNPOItemDetailsDto>> getItemsByAsnNumber(@PathVariable int asn) {
		List<ASNPOItemDetailsDto> purchaseOrderItems = POService.getPoItemsByAsnNumber(asn);
		return new ResponseEntity<>(purchaseOrderItems, HttpStatus.OK);
	}

	@GetMapping("getall/po/asn")
	public ResponseEntity<AsnAndPOCombinedDto> getAllPoAndAsnOnLoad() {
		AsnAndPOCombinedDto AsnAndPO_List = POService.getAllPOAndASN();
		return new ResponseEntity<>(AsnAndPO_List, HttpStatus.OK);
	}

	@PostMapping("/save/po_receive/{store}")
	public ResponseEntity<String> savePoReceive(@RequestBody PurchaseOrderCombineddtotoSave purchaseOrderCombinedDto,
			@PathVariable String store) {
		String success_msg = POService.savePoToMaster(purchaseOrderCombinedDto, store);
		return new ResponseEntity<>(success_msg, HttpStatus.OK);
	}

	@GetMapping("/completed/asnList/{asnNumber}")
	public ResponseEntity<List<PurchaseOrderItemsGetDto3>> getAsnItemListByAsnnumber(@PathVariable int asnNumber) {
		List<PurchaseOrderItemsGetDto3> items = POService.getPoItemDetailsByAsnNumber(asnNumber);
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

	@PostMapping(value = "send/Po_Discrepancy/Email", consumes = "multipart/form-data")
	public void sendPoDiscrepancyEmail(@ModelAttribute EmailRequest emailRequest) {
		System.out.println("Going to Send email: " + emailRequest.toString());
		emailService.sendDiscrepancyEmail(emailRequest);
	}

	@PostMapping("/save/draft/po")
	public ResponseEntity<String> saveDraftPoReceive(@RequestBody List<DraftPurchaseOrderItems> draftPOItems) {
		String success_msg = POService.saveDraftPoItems(draftPOItems);
		return new ResponseEntity<>(success_msg, HttpStatus.OK);
	}
	
	@GetMapping("/get/draft/items/{Id}")
	public ResponseEntity<List<DraftPurchaseOrderItems>> getDraftItems(@PathVariable int Id) {
		List<DraftPurchaseOrderItems> items = POService.getDraftPoItemsByAsnOrPo(Id);
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

}
