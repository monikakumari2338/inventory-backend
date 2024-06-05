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

import com.inventory.mydto.ASNCombinedDto;
import com.inventory.mydto.ASNDto;
import com.inventory.mydto.ASNOnLoadDto;
import com.inventory.mydto.ASNPOItemDetailsDto;
import com.inventory.mydto.AsnAndPOCombinedDto;
import com.inventory.mydto.PurchaseOrderCombinedDto;
import com.inventory.mydto.PurchaseOrderCombineddtotoSave;
import com.inventory.mydto.PurchaseOrderGetdto;
import com.inventory.mydto.PurchaseOrderItemsGetDto3;
import com.inventory.mydto.PurchaseOrderItemsdto;
import com.inventory.myentity.ASN;
import com.inventory.myentity.ASNPOItemDetails;
import com.inventory.myentity.DraftPurchaseOrderItems;
import com.inventory.myentity.EmailRequest;
import com.inventory.myentity.PurchaseOrderItems;
import com.inventory.myservice.EmailService;
import com.inventory.myservice.PurchaseOrderService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/purchaseOrder")
@SecurityRequirement(name = "bearerAuth")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService POService;

	@Autowired
	private EmailService emailService;

	@PostMapping("/save/asn")
	public ResponseEntity<ASNCombinedDto> add_ASN(@RequestBody ASNCombinedDto aSNDto) {
		String asnId = POService.generateAsnIdString();
		ASNCombinedDto asn = POService.saveASN(aSNDto, asnId);
		return new ResponseEntity<>(asn, HttpStatus.OK);
	}

	// Api to save data in Purchase order table
	@PostMapping("/save/po")
	public ResponseEntity<PurchaseOrderCombinedDto> add_PO(
			@RequestBody PurchaseOrderCombinedDto purchaseOrderCombinedDto) {
		String PO_ID = POService.generateRandomString();
		PurchaseOrderCombinedDto purchase_order = POService.savePurchaseOrder(purchaseOrderCombinedDto, PO_ID);
		return new ResponseEntity<>(purchase_order, HttpStatus.OK);
	}

	@GetMapping("/findbyPO/{po}")
	public ResponseEntity<List<PurchaseOrderItemsdto>> findbyPO(@PathVariable String po) {
		List<PurchaseOrderItemsdto> purchaseOrderItems = POService.getPoItemsByPoNumber(po);
		return new ResponseEntity<>(purchaseOrderItems, HttpStatus.OK);
	}

//	@GetMapping("/getPoSummary/{po}")
//	public ResponseEntity<List<PurchaseOrderItemsdto>> getPoSummary(@PathVariable String po) {
//		List<PurchaseOrderItemsdto> purchaseOrderItems = POService.getPoItemsSummaryByPoNumber(po);
//		return new ResponseEntity<>(purchaseOrderItems, HttpStatus.OK);
//	}

	@GetMapping("/getitemsby/asnnumber/{asn}")
	public ResponseEntity<List<ASNPOItemDetailsDto>> getItemsByAsnNumber(@PathVariable String asn) {
		List<ASNPOItemDetailsDto> purchaseOrderItems = POService.getPoItemsByAsnNumber(asn);
		return new ResponseEntity<>(purchaseOrderItems, HttpStatus.OK);
	}

	@GetMapping("getall/po")
	public ResponseEntity<List<PurchaseOrderGetdto>> getAllPoOnLoad() {
		List<PurchaseOrderGetdto> PoList = POService.getAllPO();
		return new ResponseEntity<>(PoList, HttpStatus.OK);
	}

	@PostMapping("/save/po_receive/{store}")
	public ResponseEntity<String> savePoReceive(@RequestBody PurchaseOrderCombineddtotoSave purchaseOrderCombinedDto,
			@PathVariable String store) {
		String success_msg = POService.savePoToMaster(purchaseOrderCombinedDto, store);
		return new ResponseEntity<>(success_msg, HttpStatus.OK);
	}

	@GetMapping("/completed/asnList/{asnNumber}")
	public ResponseEntity<List<PurchaseOrderItemsGetDto3>> getAsnItemListByAsnnumber(@PathVariable String asnNumber) {
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
	public ResponseEntity<List<DraftPurchaseOrderItems>> getDraftItems(@PathVariable String Id) {
		List<DraftPurchaseOrderItems> items = POService.getDraftPoItemsByAsn(Id);
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

	@GetMapping("/get/asn/list/by/ponumber/{po}")
	public ResponseEntity<List<ASNDto>> getAsnList(@PathVariable String po) {
		List<ASNDto> asnList = POService.getAsnByPoNumber(po);
		return new ResponseEntity<>(asnList, HttpStatus.OK);
	}

	@GetMapping("/get/itemBy/asn/{asnNumber}/{sku}")
	public ResponseEntity<ASNPOItemDetails> getProductFromASN(@PathVariable String asnNumber,
			@PathVariable String sku) {
		ASNPOItemDetails item = POService.getProductFromAsnTable(sku, asnNumber);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	@GetMapping("/get/itemBy/po/{poNumber}/{sku}")
	public ResponseEntity<PurchaseOrderItems> getProductFromPO(@PathVariable String poNumber,
			@PathVariable String sku) {
		PurchaseOrderItems item = POService.getProductFromPoTable(sku, poNumber);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

}
