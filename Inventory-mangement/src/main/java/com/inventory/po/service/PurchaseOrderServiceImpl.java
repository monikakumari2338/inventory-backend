package com.inventory.po.service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dsd.jpa.entity.Suppliers;
import com.inventory.dsd.jpa.entity.SuppliersProducts;
import com.inventory.myrepository.ASNPOItemDetailsRepo;
import com.inventory.myrepository.ASNRepo;
import com.inventory.myrepository.CategoryRepo;
import com.inventory.myrepository.ProductDetailsRepo;
import com.inventory.myrepository.ProductRepo;
import com.inventory.myrepository.PurchaseOrderItemsRepo;
import com.inventory.myrepository.PurchaseOrderRepo;
import com.inventory.myrepository.StoreRepo;
import com.inventory.myrepository.SuppliersProductsRepo;
import com.inventory.myrepository.SuppliersRepo;
import com.inventory.po.jpa.dto.ASNCombinedDto;
import com.inventory.po.jpa.dto.ASNOnLoadDto;
import com.inventory.po.jpa.dto.ASNPOItemDetailsDto;
import com.inventory.po.jpa.dto.POLandingDto;
import com.inventory.po.jpa.dto.PurchaseOrderCombinedDto;
import com.inventory.po.jpa.dto.PurchaseOrderCombineddtotoSave;
import com.inventory.po.jpa.dto.PurchaseOrderGetProductDto;
import com.inventory.po.jpa.dto.PurchaseorderProductsdto;
import com.inventory.po.jpa.entity.ASN;
import com.inventory.po.jpa.entity.ASNPOItemDetails;
import com.inventory.po.jpa.entity.PurchaseOrder;
import com.inventory.po.jpa.entity.PurchaseOrderItems;
import com.inventory.product.jpa.entity.Category;
import com.inventory.product.jpa.entity.Product;
import com.inventory.product.jpa.entity.ProductDetails;
import com.inventory.store.jpa.entity.Stores;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ProductDetailsRepo productDetailsRepo;

	@Autowired
	private PurchaseOrderItemsRepo itemsRepo;

	@Autowired
	private PurchaseOrderRepo purchaseOrderRepo;

	@Autowired
	private ASNRepo asnRepo;

	@Autowired
	private ASNPOItemDetailsRepo asnPOItemDetailsRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private StoreRepo storeRepo;

	@Autowired
	private SuppliersProductsRepo suppliersProductsRepo;

	@Autowired
	private SuppliersRepo suppliersRepo;

	@Override
	public String saveASN(ASNCombinedDto asnCombinedDto, String asnId) {

		PurchaseOrder purchase_Order = purchaseOrderRepo.findByPoNumber(asnCombinedDto.getAsn().getPoNumber());

		ASN asn = new ASN(asnId, asnCombinedDto.getAsnDetails().size(), asnCombinedDto.getAsn().getTotalQty(),
				asnCombinedDto.getAsn().getCreationDate(), "Pending", null, asnCombinedDto.getAsn().getSupplier(),
				purchase_Order);
		asn = asnRepo.save(asn);

		int qty = 0;
		for (int i = 0; i < asnCombinedDto.getAsnDetails().size(); i++) {

			ASNPOItemDetails asnDetails = new ASNPOItemDetails(asnCombinedDto.getAsnDetails().get(i).getItemNumber(),
					asnCombinedDto.getAsnDetails().get(i).getItemName(),
					asnCombinedDto.getAsnDetails().get(i).getExpectedQty(),
					asnCombinedDto.getAsnDetails().get(i).getShippedQty(),
					asnCombinedDto.getAsnDetails().get(i).getExpectedQty(),
					asnCombinedDto.getAsnDetails().get(i).getReceivedQty(),
					asnCombinedDto.getAsnDetails().get(i).getDamageQty(),
					asnCombinedDto.getAsnDetails().get(i).getDamageImage(),
					asnCombinedDto.getAsnDetails().get(i).getCategory(),
					asnCombinedDto.getAsnDetails().get(i).getColor(), asnCombinedDto.getAsnDetails().get(i).getPrice(),
					asnCombinedDto.getAsnDetails().get(i).getSize(),
					asnCombinedDto.getAsnDetails().get(i).getImageData(),
					asnCombinedDto.getAsnDetails().get(i).getImage(), asnCombinedDto.getAsnDetails().get(i).getUpc(),
					asnCombinedDto.getAsnDetails().get(i).getSku(),
					asnCombinedDto.getAsnDetails().get(i).getTaxPercentage(),
					asnCombinedDto.getAsnDetails().get(i).getTaxCode(), purchase_Order.getExpectedDeliveryDate(),
					asnCombinedDto.getAsnDetails().get(i).getReceivedDate(), asn);

			qty = (qty + asnCombinedDto.getAsnDetails().get(i).getExpectedQty());
			asnPOItemDetailsRepo.save(asnDetails);
		}

		purchaseOrderRepo.save(purchase_Order);
		asn.setTotalQty(qty);
		asn = asnRepo.save(asn);
		return asn.getAsnNumber();

	}

	// Purchase order Creation Function
	@Override
	public PurchaseOrderCombinedDto savePurchaseOrder(PurchaseOrderCombinedDto combinedDto, String Id) {

		int poCost = 0;
		Suppliers supplier = suppliersRepo.findBySupplierId(combinedDto.getPurchaseOrderdto().getSupplierId());

		PurchaseOrder purchaseOrder = new PurchaseOrder(Id, "Pending",
				combinedDto.getPurchaseOrderdto().getSupplierId(), combinedDto.getPurchaseOrderdto().getSupplierName(),
				combinedDto.getPurchaseOrderItemsdto().size(), combinedDto.getPurchaseOrderdto().getStoreLocation(),
				combinedDto.getPurchaseOrderdto().getCreationDate(),
				combinedDto.getPurchaseOrderdto().getReceiveAfter(),
				combinedDto.getPurchaseOrderdto().getReceiveBefore(),
				combinedDto.getPurchaseOrderdto().getExpectedDeliveryDate(), null);

		purchaseOrder = purchaseOrderRepo.save(purchaseOrder);

		int qty = 0;
		// PurchaseOrder po = purchaseOrderRepo.findFirstByOrderByPoNumberDesc();
		for (int i = 0; i < combinedDto.getPurchaseOrderItemsdto().size(); i++) {

			SuppliersProducts supplierProduct = suppliersProductsRepo
					.findBySkuAndSuppliers(combinedDto.getPurchaseOrderItemsdto().get(i).getSku(), supplier);

			PurchaseOrderItems purchaseOrderItems = new PurchaseOrderItems(
					combinedDto.getPurchaseOrderItemsdto().get(i).getItemNumber(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getItemName(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getExpectedQty(), 0, null,
					combinedDto.getPurchaseOrderItemsdto().get(i).getCategory(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getColor(), supplierProduct.getPrice(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getSize(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getImageData(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getImage(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getUpc(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getSku(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getTaxPercentage(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getTaxCode(), purchaseOrder);

			purchaseOrderItems.setRemainingQty(combinedDto.getPurchaseOrderItemsdto().get(i).getExpectedQty());
			qty = qty + combinedDto.getPurchaseOrderItemsdto().get(i).getExpectedQty();
			poCost = poCost + Integer.parseInt(supplierProduct.getPrice());
			itemsRepo.save(purchaseOrderItems);

		}
		purchaseOrder.setTotalItems(qty);
		purchaseOrder.setCost(poCost);
		purchaseOrderRepo.save(purchaseOrder);
		return combinedDto;

	}

	@Override
	public List<ASNPOItemDetailsDto> getPoItemsByAsnNumber(String asnNumber) {

		ASN asn = asnRepo.findByasnNumber(asnNumber);
		List<ASNPOItemDetails> asnPOItemDetails = asnPOItemDetailsRepo.findByAsn(asn);

		List<ASNPOItemDetailsDto> items = new ArrayList<>();

		for (int i = 0; i < asnPOItemDetails.size(); i++) {
			ASNPOItemDetailsDto aSNPOItemDetailsDto = new ASNPOItemDetailsDto(asnPOItemDetails.get(i).getItemNumber(),
					asnPOItemDetails.get(i).getItemName(), asnPOItemDetails.get(i).getExpectedQty(),
					asnPOItemDetails.get(i).getShippedQty(), asnPOItemDetails.get(i).getRemainingQty(),
					asnPOItemDetails.get(i).getReceivedQty(), asnPOItemDetails.get(i).getDamageQty(),
					asnPOItemDetails.get(i).getDamageImage(), asnPOItemDetails.get(i).getCategory(),
					asnPOItemDetails.get(i).getColor(), asnPOItemDetails.get(i).getPrice(),
					asnPOItemDetails.get(i).getSize(), asnPOItemDetails.get(i).getImageData(),
					asnPOItemDetails.get(i).getImage(), asnPOItemDetails.get(i).getUpc(),
					asnPOItemDetails.get(i).getSku(), asnPOItemDetails.get(i).getTaxPercentage(),
					asnPOItemDetails.get(i).getTaxCode(), asnPOItemDetails.get(i).getReceivedDate(), "PO");
			items.add(aSNPOItemDetailsDto);
		}
		return items;
	}

	@Override
	public String savePoToMaster(PurchaseOrderCombineddtotoSave combinedDto, String storeName) {

		// System.out.print("combinedDto : " + combinedDto);
		Stores store = storeRepo.findByStoreName(storeName);
		for (int i = 0; i < combinedDto.getPurchaseOrderItemsdto().size(); i++) {
			Category category = categoryRepo
					.findByCategory(combinedDto.getPurchaseOrderItemsdto().get(i).getCategory());
			Product product = productRepo
					.findByItemNumber(combinedDto.getPurchaseOrderItemsdto().get(i).getItemNumber());

			if (product == null) {

				Product product1 = new Product(combinedDto.getPurchaseOrderItemsdto().get(i).getItemNumber(),
						combinedDto.getPurchaseOrderItemsdto().get(i).getItemName(), category);
				productRepo.save(product1);

				Product product2 = productRepo
						.findByItemNumber(combinedDto.getPurchaseOrderItemsdto().get(i).getItemNumber());
				ProductDetails productDetails2 = new ProductDetails(
						combinedDto.getPurchaseOrderItemsdto().get(i).getColor(),
						combinedDto.getPurchaseOrderItemsdto().get(i).getPrice(),
						combinedDto.getPurchaseOrderItemsdto().get(i).getSize(),
						combinedDto.getPurchaseOrderItemsdto().get(i).getReceivedQty(), 0,
						combinedDto.getPurchaseOrderItemsdto().get(i).getImageData(), store, product2,
						combinedDto.getPurchaseOrderItemsdto().get(i).getUpc(),
						combinedDto.getPurchaseOrderItemsdto().get(i).getSku());

				int total_stock = combinedDto.getPurchaseOrderItemsdto().get(i).getReceivedQty()
						+ combinedDto.getPurchaseOrderItemsdto().get(i).getDamageQty();
				productDetails2.setSellableStock(combinedDto.getPurchaseOrderItemsdto().get(i).getReceivedQty());
				productDetails2.setNonSellableStock(combinedDto.getPurchaseOrderItemsdto().get(i).getDamageQty());
				productDetails2.setTotalStock(total_stock);
				productDetailsRepo.save(productDetails2);

			}

			else {

				ProductDetails productDetails1 = productDetailsRepo
						.findBySkuAndStore(combinedDto.getPurchaseOrderItemsdto().get(i).getSku(), store);

//				System.out.println("productDetails1 : " + productDetails1 + " sku : "
//						+ combinedDto.getPurchaseOrderItemsdto().get(i).getSku());
				int Prev_sellableStock;
				int new_sellableStock;
				int totalSellable = 0;
				int new_nonSellableStock;
				int totalNonSellable = 0;

				if (productDetails1 != null) {
					Prev_sellableStock = productDetails1.getSellableStock();
					new_sellableStock = combinedDto.getPurchaseOrderItemsdto().get(i).getReceivedQty();
					totalSellable = Prev_sellableStock + new_sellableStock;

					int nonSellable_stock = productDetails1.getNonSellableStock();
					new_nonSellableStock = combinedDto.getPurchaseOrderItemsdto().get(i).getDamageQty();
					totalNonSellable = nonSellable_stock + new_nonSellableStock;

					int total_stock = totalSellable + totalNonSellable;
					productDetails1.setTotalStock(total_stock);
					productDetails1.setSellableStock(totalSellable);
					productDetails1.setNonSellableStock(totalNonSellable);
					productDetailsRepo.save(productDetails1);
					// System.out.println("inside iff");
				}

				else {

					ProductDetails productDetails2 = new ProductDetails(
							combinedDto.getPurchaseOrderItemsdto().get(i).getColor(),
							combinedDto.getPurchaseOrderItemsdto().get(i).getPrice(),
							combinedDto.getPurchaseOrderItemsdto().get(i).getSize(),
							combinedDto.getPurchaseOrderItemsdto().get(i).getReceivedQty(), 0,
							combinedDto.getPurchaseOrderItemsdto().get(i).getImageData(), store, product,
							combinedDto.getPurchaseOrderItemsdto().get(i).getUpc(),
							combinedDto.getPurchaseOrderItemsdto().get(i).getSku());

					int total_stock = combinedDto.getPurchaseOrderItemsdto().get(i).getReceivedQty()
							+ combinedDto.getPurchaseOrderItemsdto().get(i).getDamageQty();
					productDetails2.setSellableStock(combinedDto.getPurchaseOrderItemsdto().get(i).getReceivedQty());
					productDetails2.setNonSellableStock(combinedDto.getPurchaseOrderItemsdto().get(i).getDamageQty());
					productDetails2.setTotalStock(total_stock);
					System.out.println("Test3: ");
					productDetailsRepo.save(productDetails2);
					// System.out.println("inside else");
				}

			}

			PurchaseOrder PO = purchaseOrderRepo
					.findByPoNumber(combinedDto.getPurchaseOrderItemsdto().get(0).getPoNumber());

			if (PO != null) {
				PurchaseOrderItems item = itemsRepo
						.findBySkuAndPurchaseOrder(combinedDto.getPurchaseOrderItemsdto().get(i).getSku(), PO);
				if (item != null) {

					int newRemainingQty = item.getRemainingQty()
							- (combinedDto.getPurchaseOrderItemsdto().get(i).getReceivedQty()
									+ combinedDto.getPurchaseOrderItemsdto().get(i).getDamageQty());

					item.setReceivedQty(
							item.getReceivedQty() + combinedDto.getPurchaseOrderItemsdto().get(i).getReceivedQty());
					if (newRemainingQty >= 0) {
						item.setRemainingQty(newRemainingQty);
					} else {
						item.setRemainingQty(0);
					}

					item.setDamageQty(
							item.getDamageQty() + combinedDto.getPurchaseOrderItemsdto().get(i).getDamageQty());
					item.setDamageImage(combinedDto.getPurchaseOrderItemsdto().get(i).getDamageImage());

					if (item.getRemainingQty() == 0) {
						item.setCompleted(true);
					}

					itemsRepo.save(item);
				}
			}

			ASN asn = asnRepo.findByasnNumber(combinedDto.getAsnNumber());
			ASNPOItemDetails asnItem = asnPOItemDetailsRepo.findByAsnAndSku(asn,
					combinedDto.getPurchaseOrderItemsdto().get(i).getSku());
			// System.out.println("asnItem : " + asnItem);
			if (asnItem != null) {
				int newRemainingQty = asnItem.getRemainingQty()
						- (combinedDto.getPurchaseOrderItemsdto().get(i).getReceivedQty());

				asnItem.setReceivedQty(combinedDto.getPurchaseOrderItemsdto().get(i).getReceivedQty());

				if (newRemainingQty >= 0) {
					asnItem.setRemainingQty(newRemainingQty);
				} else {
					asnItem.setRemainingQty(0);
				}

				asnPOItemDetailsRepo.save(asnItem);
			}

		}
		PurchaseOrder PO = purchaseOrderRepo
				.findByPoNumber(combinedDto.getPurchaseOrderItemsdto().get(0).getPoNumber());
		List<PurchaseOrderItems> items = itemsRepo.findAllByPurchaseOrder(PO);
		boolean allItemsCompleted = items.stream().allMatch(PurchaseOrderItems::isCompleted);

		if (allItemsCompleted) {
			PO.setStatus("Completed");
		} else {
			PO.setStatus("In Progress");
		}
		purchaseOrderRepo.save(PO);

		ASN asn = asnRepo.findByasnNumber(combinedDto.getAsnNumber());
		System.out.println("asn : " + asn);
		asn.setStatus("Completed");
		asn.setReceivingDate(LocalDate.now());

		asn.setAttachedImage(combinedDto.getAttachedImage());
		asnRepo.save(asn);
		System.out.println("asn after  : " + asn);
		return "Saved Successfully";
	}

	@Override
	public List<POLandingDto> getAllPO() {

		List<PurchaseOrder> purchaseOrder = purchaseOrderRepo.findAll();

		List<POLandingDto> poDto = new ArrayList<>();

//		List<ASNPOItemDetails> aSNPOItemDetails = asnPOItemDetailsRepo.findAll();
//		Map<String, Integer> damageAsnObject = aSNPOItemDetails.stream()
//				.collect(Collectors.groupingBy(aspodetail -> aspodetail.getAsn().getAsnNumber(),
//						Collectors.summingInt(ASNPOItemDetails::getDamageQty)));
//
//		Map<String, Integer> remainingAsnObject = aSNPOItemDetails.stream()
//				.collect(Collectors.groupingBy(aspodetail -> aspodetail.getAsn().getAsnNumber(),
//						Collectors.summingInt(ASNPOItemDetails::getRemainingQty)));
//
//		Map<String, Integer> receivedAsnObject = aSNPOItemDetails.stream()
//				.collect(Collectors.groupingBy(aspodetail -> aspodetail.getAsn().getAsnNumber(),
//						Collectors.summingInt(ASNPOItemDetails::getReceivedQty)));

		for (int i = 0; i < purchaseOrder.size(); i++) {

//			List<ASN> asnList = asnRepo.findByPurchaseOrder(purchaseOrder.get(i));
//			List<String> uniqueAsn = asnList.stream().map(asn -> asn.getAsnNumber()).distinct()
//					.collect(Collectors.toList());
			// System.out.println("uniqueAsn : " + uniqueAsn);

//			int totalDamageQty = uniqueAsn.stream().filter(damageAsnObject::containsKey).mapToInt(damageAsnObject::get)
//					.sum();
//			int totalReceivedQty = uniqueAsn.stream().filter(receivedAsnObject::containsKey)
//					.mapToInt(receivedAsnObject::get).sum();
//			int totalRemainingQty = uniqueAsn.stream().filter(remainingAsnObject::containsKey)
//					.mapToInt(remainingAsnObject::get).sum();

			PurchaseOrder po = purchaseOrderRepo.findByPoNumber(purchaseOrder.get(i).getPoNumber());

			List<PurchaseOrderItems> items = itemsRepo.findAllByPurchaseOrder(po);
			int totalReceivedQty = items.stream().mapToInt(PurchaseOrderItems::getReceivedQty).sum();
			int totalRemainingQty = items.stream().mapToInt(PurchaseOrderItems::getRemainingQty).sum();
			int totalDamageQty = items.stream().mapToInt(PurchaseOrderItems::getDamageQty).sum();

			List<ASN> asn = asnRepo.findByPurchaseOrder(po);

			poDto.add(new POLandingDto(purchaseOrder.get(i).getPoNumber(), purchaseOrder.get(i).getCreationDate(),
					purchaseOrder.get(i).getStatus(), purchaseOrder.get(i).getTotalSKU(),
					purchaseOrder.get(i).getTotalItems(), asn.size(), totalRemainingQty, po.getTotalItems(),
					totalReceivedQty, totalDamageQty, purchaseOrder.get(i).getSupplierId(), "PO"));
		}

		return poDto;

	}

	@Override
	public List<ASNOnLoadDto> getAsnByPoNumber(String PoNumber) {

		PurchaseOrder po = purchaseOrderRepo.findByPoNumber(PoNumber);
		List<ASN> asnList = asnRepo.findByPurchaseOrder(po);
		System.out.println("asnlist " + asnList);

		List<ASNPOItemDetails> aSNPOItemDetails = asnPOItemDetailsRepo.findAll();

		Map<String, Integer> receivedAsnObject = aSNPOItemDetails.stream()
				.collect(Collectors.groupingBy(aspodetail -> aspodetail.getAsn().getAsnNumber(),
						Collectors.summingInt(ASNPOItemDetails::getReceivedQty)));
		List<ASNOnLoadDto> asnDto = new ArrayList<>();

		for (int i = 0; i < asnList.size(); i++) {

			int totalQty = receivedAsnObject.get(asnList.get(i).getAsnNumber());
			// System.out.println("Total Qty:- "+ totalQty);
			ASNOnLoadDto dto = new ASNOnLoadDto(asnList.get(i).getCreationDate(), asnList.get(i).getReceivingDate(),
					asnList.get(i).getStatus(), asnList.get(i).getAsnNumber(),
					asnList.get(i).getPurchaseOrder().getPoNumber(), asnList.get(i).getSupplier(),
					asnList.get(i).getTotalSKU(), asnList.get(i).getTotalQty(), totalQty);
			asnDto.add(dto);
		}

		return asnDto;

	}

	@Override
	public String draftASN(ASNCombinedDto asnCombinedDto, String asnNumber) {

		System.out.println("asnNumber : " + asnNumber);
		PurchaseOrder purchase_Order = purchaseOrderRepo.findByPoNumber(asnCombinedDto.getAsn().getPoNumber());

		if (asnNumber == null || asnNumber.length() == 0 || asnNumber.isBlank()) {
			int qty = 0;
			System.out.println("inside if");
			ASN asn = new ASN(generateAsnIdString(), asnCombinedDto.getAsn().getCreationDate(), "Saved",
					asnCombinedDto.getAsn().getSupplier(), purchase_Order);

			asn = asnRepo.save(asn);

			for (int i = 0; i < asnCombinedDto.getAsnDetails().size(); i++) {
				ASNPOItemDetails asnDetails = new ASNPOItemDetails(
						asnCombinedDto.getAsnDetails().get(i).getItemNumber(),
						asnCombinedDto.getAsnDetails().get(i).getItemName(),
						asnCombinedDto.getAsnDetails().get(i).getExpectedQty(),
						asnCombinedDto.getAsnDetails().get(i).getShippedQty(),
						asnCombinedDto.getAsnDetails().get(i).getRemainingQty(),
						asnCombinedDto.getAsnDetails().get(i).getReceivedQty(),
						asnCombinedDto.getAsnDetails().get(i).getDamageQty(),
						asnCombinedDto.getAsnDetails().get(i).getDamageImage(),
						asnCombinedDto.getAsnDetails().get(i).getCategory(),
						asnCombinedDto.getAsnDetails().get(i).getColor(),
						asnCombinedDto.getAsnDetails().get(i).getPrice(),
						asnCombinedDto.getAsnDetails().get(i).getSize(),
						asnCombinedDto.getAsnDetails().get(i).getImageData(),
						asnCombinedDto.getAsnDetails().get(i).getImage(),
						asnCombinedDto.getAsnDetails().get(i).getUpc(), asnCombinedDto.getAsnDetails().get(i).getSku(),
						asnCombinedDto.getAsnDetails().get(i).getTaxPercentage(),
						asnCombinedDto.getAsnDetails().get(i).getTaxCode(), purchase_Order.getExpectedDeliveryDate(),
						asnCombinedDto.getAsnDetails().get(i).getReceivedDate(), asn);

				asnPOItemDetailsRepo.save(asnDetails);
				qty = (qty + asnCombinedDto.getAsnDetails().get(i).getExpectedQty());
				asnPOItemDetailsRepo.save(asnDetails);
			}
			asn.setStatus("Saved");
			asn.setTotalQty(qty);
			asn.setTotalSKU(asnCombinedDto.getAsnDetails().size());
			asnRepo.save(asn);

		}

		else {
			int qty = 0;
			ASN asn = asnRepo.findByasnNumber(asnNumber);

			asnPOItemDetailsRepo.deleteAllByAsn(asn);
			for (int i = 0; i < asnCombinedDto.getAsnDetails().size(); i++) {
				ASNPOItemDetails asnDetails = new ASNPOItemDetails(
						asnCombinedDto.getAsnDetails().get(i).getItemNumber(),
						asnCombinedDto.getAsnDetails().get(i).getItemName(),
						asnCombinedDto.getAsnDetails().get(i).getExpectedQty(),
						asnCombinedDto.getAsnDetails().get(i).getShippedQty(),
						(asnCombinedDto.getAsnDetails().get(i).getExpectedQty()
								- asnCombinedDto.getAsnDetails().get(i).getReceivedQty()),
						asnCombinedDto.getAsnDetails().get(i).getReceivedQty(),
						asnCombinedDto.getAsnDetails().get(i).getDamageQty(),
						asnCombinedDto.getAsnDetails().get(i).getDamageImage(),
						asnCombinedDto.getAsnDetails().get(i).getCategory(),
						asnCombinedDto.getAsnDetails().get(i).getColor(),
						asnCombinedDto.getAsnDetails().get(i).getPrice(),
						asnCombinedDto.getAsnDetails().get(i).getSize(),
						asnCombinedDto.getAsnDetails().get(i).getImageData(),
						asnCombinedDto.getAsnDetails().get(i).getImage(),
						asnCombinedDto.getAsnDetails().get(i).getUpc(), asnCombinedDto.getAsnDetails().get(i).getSku(),
						asnCombinedDto.getAsnDetails().get(i).getTaxPercentage(),
						asnCombinedDto.getAsnDetails().get(i).getTaxCode(), purchase_Order.getExpectedDeliveryDate(),
						asnCombinedDto.getAsnDetails().get(i).getReceivedDate(), asn);

				qty = (qty + asnCombinedDto.getAsnDetails().get(i).getExpectedQty());
				asnPOItemDetailsRepo.save(asnDetails);
			}

			asn.setStatus("Saved");
			asn.setTotalQty(qty);
			asn.setTotalSKU(asnCombinedDto.getAsnDetails().size());
			System.out.println("asn :" + asn);
			asnRepo.save(asn);

		}
		return "Draft Saved Successfully";

	}

	// Function to get all product ASN table
	@Override
	public List<ASNPOItemDetails> getAllProductFromAsnTable(String asnNumber) {

		ASN asn = asnRepo.findByasnNumber(asnNumber);
		List<ASNPOItemDetails> items = asnPOItemDetailsRepo.findByAsn(asn);

		// ASNPOItemDetails product = items.stream().filter(item ->
		// item.getSku().equals(sku)).findAny().orElse(null);

		return items;

	}

	// Function to get product in the case when there is No ASN
	@Override
	public PurchaseOrderGetProductDto getProductFromPoTable(String sku, String poNumber, String type) {

		PurchaseOrder po = purchaseOrderRepo.findByPoNumber(poNumber);
		List<PurchaseOrderItems> item = itemsRepo.findBySkuContainingAndPurchaseOrder(sku, po);
		// System.out.println("item : " + item);

		List<PurchaseorderProductsdto> itemsDto = new ArrayList<>();

		for (int i = 0; i < item.size(); i++) {
			itemsDto.add(new PurchaseorderProductsdto(item.get(i).getItemNumber(), item.get(i).getItemName(),
					item.get(i).getCategory(), item.get(i).getColor(), item.get(i).getSize(), item.get(i).getSku(),
					item.get(i).getUpc(), item.get(i).getExpectedQty(), item.get(i).getReceivedQty(),
					item.get(i).getRemainingQty(), null, item.get(i).getImageData()));
			itemsDto.get(i).setType(type);
		}

		PurchaseOrderGetProductDto productDto = new PurchaseOrderGetProductDto(null, null, 0, null, null, itemsDto);

		return productDto;

	}

	@Override
	public List<POLandingDto> sortPoByOldest() {

		List<PurchaseOrder> purchaseOrder = new ArrayList<>();
		purchaseOrder = purchaseOrderRepo.findAllByOrderByCreationDateAsc();

		List<POLandingDto> poDto = new ArrayList<>();

		for (int i = 0; i < purchaseOrder.size(); i++) {
			PurchaseOrder po = purchaseOrderRepo.findByPoNumber(purchaseOrder.get(i).getPoNumber());

			List<ASN> asn = asnRepo.findByPurchaseOrder(po);

			List<PurchaseOrderItems> items = itemsRepo.findAllByPurchaseOrder(po);
			int totalReceivedQty = items.stream().mapToInt(PurchaseOrderItems::getReceivedQty).sum();
			int totalRemainingQty = items.stream().mapToInt(PurchaseOrderItems::getRemainingQty).sum();
			int totalDamageQty = items.stream().mapToInt(PurchaseOrderItems::getDamageQty).sum();

			poDto.add(new POLandingDto(purchaseOrder.get(i).getPoNumber(), purchaseOrder.get(i).getCreationDate(),
					purchaseOrder.get(i).getStatus(), purchaseOrder.get(i).getTotalSKU(),
					purchaseOrder.get(i).getTotalItems(), asn.size(), totalRemainingQty, po.getTotalItems(),
					totalReceivedQty, totalDamageQty, purchaseOrder.get(i).getSupplierId(), "PO"));
		}
		return poDto;
	}

	@Override
	public List<POLandingDto> sortPoByLatest() {

		List<PurchaseOrder> purchaseOrder = purchaseOrderRepo.findAllByOrderByCreationDateDesc();

		List<POLandingDto> poDto = new ArrayList<>();

		for (int i = 0; i < purchaseOrder.size(); i++) {
			PurchaseOrder po = purchaseOrderRepo.findByPoNumber(purchaseOrder.get(i).getPoNumber());

			List<ASN> asn = asnRepo.findByPurchaseOrder(po);

			List<PurchaseOrderItems> items = itemsRepo.findAllByPurchaseOrder(po);
			int totalReceivedQty = items.stream().mapToInt(PurchaseOrderItems::getReceivedQty).sum();
			int totalRemainingQty = items.stream().mapToInt(PurchaseOrderItems::getRemainingQty).sum();
			int totalDamageQty = items.stream().mapToInt(PurchaseOrderItems::getDamageQty).sum();

			poDto.add(new POLandingDto(purchaseOrder.get(i).getPoNumber(), purchaseOrder.get(i).getCreationDate(),
					purchaseOrder.get(i).getStatus(), purchaseOrder.get(i).getTotalSKU(),
					purchaseOrder.get(i).getTotalItems(), asn.size(), totalRemainingQty, po.getTotalItems(),
					totalReceivedQty, totalDamageQty, purchaseOrder.get(i).getSupplierId(), "PO"));
		}
		return poDto;
	}

	@Override
	public List<POLandingDto> filtersByStatusOrSupplierName(String param) {

		List<PurchaseOrder> purchaseOrder = purchaseOrderRepo.findByStatusOrSupplierName(param, param);

		List<POLandingDto> poDto = new ArrayList<>();

		for (int i = 0; i < purchaseOrder.size(); i++) {
			PurchaseOrder po = purchaseOrderRepo.findByPoNumber(purchaseOrder.get(i).getPoNumber());

			List<ASN> asn = asnRepo.findByPurchaseOrder(po);

			List<PurchaseOrderItems> items = itemsRepo.findAllByPurchaseOrder(po);
			int totalReceivedQty = items.stream().mapToInt(PurchaseOrderItems::getReceivedQty).sum();
			int totalRemainingQty = items.stream().mapToInt(PurchaseOrderItems::getRemainingQty).sum();
			int totalDamageQty = items.stream().mapToInt(PurchaseOrderItems::getDamageQty).sum();

			poDto.add(new POLandingDto(purchaseOrder.get(i).getPoNumber(), purchaseOrder.get(i).getCreationDate(),
					purchaseOrder.get(i).getStatus(), purchaseOrder.get(i).getTotalSKU(),
					purchaseOrder.get(i).getTotalItems(), asn.size(), totalRemainingQty, po.getTotalItems(),
					totalReceivedQty, totalDamageQty, purchaseOrder.get(i).getSupplierId(), "PO"));
		}
		return poDto;
	}

	@Override
	public List<POLandingDto> getMatchedPo(String poNumber) {

		List<PurchaseOrder> purchaseOrder = purchaseOrderRepo.findByPoNumberContaining(poNumber);

		List<POLandingDto> poDto = new ArrayList<>();

		for (int i = 0; i < purchaseOrder.size(); i++) {
			PurchaseOrder po = purchaseOrderRepo.findByPoNumber(purchaseOrder.get(i).getPoNumber());

			List<ASN> asn = asnRepo.findByPurchaseOrder(po);

			List<PurchaseOrderItems> items = itemsRepo.findAllByPurchaseOrder(po);
			int totalReceivedQty = items.stream().mapToInt(PurchaseOrderItems::getReceivedQty).sum();
			int totalRemainingQty = items.stream().mapToInt(PurchaseOrderItems::getRemainingQty).sum();
			int totalDamageQty = items.stream().mapToInt(PurchaseOrderItems::getDamageQty).sum();

			poDto.add(new POLandingDto(purchaseOrder.get(i).getPoNumber(), purchaseOrder.get(i).getCreationDate(),
					purchaseOrder.get(i).getStatus(), purchaseOrder.get(i).getTotalSKU(),
					purchaseOrder.get(i).getTotalItems(), asn.size(), totalRemainingQty, po.getTotalItems(),
					totalReceivedQty, totalDamageQty, purchaseOrder.get(i).getSupplierId(), "PO"));
		}
		return poDto;
	}

	@Override
	public String generateRandomString() {
		final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		final SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(10);
		sb.append("PO-");
		for (int i = 0; i < 12; i++) {
			sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

		}
		return sb.toString();
	}

	@Override
	public String generateAsnIdString() {
		final String CHARACTERS = "0123456789";
		final SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(10);
		sb.append("ASN");
		for (int i = 0; i < 12; i++) {
			sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

		}
		return sb.toString();
	}

}
