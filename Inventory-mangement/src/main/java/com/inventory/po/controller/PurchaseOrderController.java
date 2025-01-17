package com.inventory.po.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.adjustments.jpa.dto.InventoryAdjustmentCombinedDto;
import com.inventory.email.jpa.entity.EmailRequest;
import com.inventory.email.service.EmailService;
import com.inventory.po.jpa.dto.ASNCombinedDto;
import com.inventory.po.jpa.dto.ASNDto;
import com.inventory.po.jpa.dto.ASNOnLoadDto;
import com.inventory.po.jpa.dto.ASNPOItemDetailsDto;
import com.inventory.po.jpa.dto.POLandingDto;
import com.inventory.po.jpa.dto.PurchaseOrderCombinedDto;
import com.inventory.po.jpa.dto.PurchaseOrderCombineddtotoSave;
import com.inventory.po.jpa.dto.PurchaseOrderGetProductDto;
import com.inventory.po.jpa.entity.DraftPurchaseOrderItems;
import com.inventory.po.jpa.entity.PurchaseOrderItems;
import com.inventory.po.service.PurchaseOrderService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/purchaseOrder")
@SecurityRequirement(name = "bearerAuth")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService POService;

	@Autowired
	private EmailService emailService;

	@PostMapping("/create/asn")
	public ResponseEntity<String> add_ASN(@RequestBody ASNCombinedDto aSNDto) {
		String asnId = POService.generateAsnIdString();
		String asn = POService.saveASN(aSNDto, asnId);
		return new ResponseEntity<>(asn, HttpStatus.OK);
	}

	// Api to save data in Purchase order table
	@PostMapping("/create/po")
	public ResponseEntity<PurchaseOrderCombinedDto> add_PO(
			@RequestBody PurchaseOrderCombinedDto purchaseOrderCombinedDto) {
		String PO_ID = POService.generateRandomString();
		PurchaseOrderCombinedDto purchase_order = POService.savePurchaseOrder(purchaseOrderCombinedDto, PO_ID);
		return new ResponseEntity<>(purchase_order, HttpStatus.OK);
	}

	@GetMapping("/getitemsby/asnnumber/{asn}")
	public ResponseEntity<List<ASNPOItemDetailsDto>> getItemsByAsnNumber(@PathVariable String asn) {
		List<ASNPOItemDetailsDto> purchaseOrderItems = POService.getPoItemsByAsnNumber(asn);
		return new ResponseEntity<>(purchaseOrderItems, HttpStatus.OK);
	}

	@GetMapping("getall/po")
	public ResponseEntity<List<POLandingDto>> getAllPoOnLoad() {
		List<POLandingDto> PoList = POService.getAllPO();
		return new ResponseEntity<>(PoList, HttpStatus.OK);
	}

	@PostMapping("/save/po_receive/{store}")
	public ResponseEntity<String> savePoReceive(@RequestBody PurchaseOrderCombineddtotoSave purchaseOrderCombinedDto,
			@PathVariable String store) {
		String success_msg = POService.savePoToMaster(purchaseOrderCombinedDto, store);
		return new ResponseEntity<>(success_msg, HttpStatus.OK);
	}

	@PostMapping(value = "send/Po_Discrepancy/Email", consumes = "multipart/form-data")
	public void sendPoDiscrepancyEmail(@ModelAttribute EmailRequest emailRequest) {
		System.out.println("Going to Send email: " + emailRequest.toString());
		emailService.sendDiscrepancyEmail(emailRequest);
	}

	@PostMapping("/save/draft/po/")
	public ResponseEntity<String> saveDraftPoReceive(@RequestBody ASNCombinedDto asnCombinedDto,
			@RequestParam(required = false) String asnNumber) {
		String success_msg = POService.draftASN(asnCombinedDto, asnNumber);
		return new ResponseEntity<>(success_msg, HttpStatus.OK);
	}

	@GetMapping("/get/asn/list/by/ponumber/{po}")
	public ResponseEntity<List<ASNOnLoadDto>> getAsnList(@PathVariable String po) {
		List<ASNOnLoadDto> asnList = POService.getAsnByPoNumber(po);
		return new ResponseEntity<>(asnList, HttpStatus.OK);
	}

	@GetMapping("/get/itemBy/po/{poNumber}/{sku}/{type}")
	public ResponseEntity<PurchaseOrderGetProductDto> getProductFromPO(@PathVariable String poNumber,
			@PathVariable String sku, @PathVariable String type) {
		PurchaseOrderGetProductDto item = POService.getProductFromPoTable(sku, poNumber, type);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	// Api to get sort dsd by latest date
	@GetMapping("/sort/latest/po")
	public ResponseEntity<List<POLandingDto>> sortLatestPo() {
		List<POLandingDto> sortedList = POService.sortPoByLatest();
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to get sort dsd by oldest date
	@GetMapping("/sort/oldest/po")
	public ResponseEntity<List<POLandingDto>> sortOldestPo() {
		List<POLandingDto> sortedList = POService.sortPoByOldest();
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}

	// Api to get filtered adjustments by reason or status
	@GetMapping("/filter/po/{param}")
	public ResponseEntity<List<POLandingDto>> filterPurchaseOrder(@PathVariable String param) {
		List<POLandingDto> filteredList = POService.filtersByStatusOrSupplierName(param);
		return new ResponseEntity<>(filteredList, HttpStatus.OK);
	}

	// Api to get Matched PO
	@GetMapping("/getMatched/Po/{po}")
	public ResponseEntity<List<POLandingDto>> getMatchedDsd(@PathVariable String po) {
		List<POLandingDto> Po = POService.getMatchedPo(po);
		return new ResponseEntity<>(Po, HttpStatus.OK);
	}

}
