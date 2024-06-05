package com.inventory.myserviceimpl;

import java.security.SecureRandom;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inventory.mydto.ASNCombinedDto;
import com.inventory.mydto.ASNDto;
import com.inventory.mydto.ASNOnLoadDto;
import com.inventory.mydto.ASNPOItemDetailsDto;
import com.inventory.mydto.PurchaseOrderCombinedDto;
import com.inventory.mydto.PurchaseOrderCombineddtotoSave;
import com.inventory.mydto.PurchaseOrderGetdto;
import com.inventory.mydto.PurchaseOrderItemsGetDto3;
import com.inventory.mydto.PurchaseOrderItemsdto;
import com.inventory.myentity.ASN;
import com.inventory.myentity.ASNPOItemDetails;
import com.inventory.myentity.Category;
import com.inventory.myentity.DraftPurchaseOrderItems;
import com.inventory.myentity.Product;
import com.inventory.myentity.ProductDetails;
import com.inventory.myentity.PurchaseOrder;
import com.inventory.myentity.PurchaseOrderItems;
import com.inventory.myentity.Stores;
import com.inventory.myrepository.ASNPOItemDetailsRepo;
import com.inventory.myrepository.ASNRepo;
import com.inventory.myrepository.CategoryRepo;
import com.inventory.myrepository.DraftPurchaseOrderItemsRepo;
import com.inventory.myrepository.ProductDetailsRepo;
import com.inventory.myrepository.ProductRepo;
import com.inventory.myrepository.PurchaseOrderItemsRepo;
import com.inventory.myrepository.PurchaseOrderRepo;
import com.inventory.myrepository.StoreRepo;
import com.inventory.myservice.PurchaseOrderService;

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
	private DraftPurchaseOrderItemsRepo draftPOItemsRepo;

	@Override
	public ASNCombinedDto saveASN(ASNCombinedDto asnCombinedDto, String asnId) {

		PurchaseOrder purchase_Order = purchaseOrderRepo.findByPoNumber(asnCombinedDto.getAsn().getPoNumber());

		ASN asn = new ASN(asnId, asnCombinedDto.getAsn().getTotalSku(), asnCombinedDto.getAsn().getTotalQty(),
				asnCombinedDto.getAsn().getCreationDate(), asnCombinedDto.getAsn().getStatus(), null,
				asnCombinedDto.getAsn().getSupplier(), purchase_Order);
		asn = asnRepo.save(asn);
		// System.out.println("i : " + purchaseOrder);
		for (int i = 0; i < asnCombinedDto.getAsnDetails().size(); i++) {

			ASNPOItemDetails asnDetails = new ASNPOItemDetails(asnCombinedDto.getAsnDetails().get(i).getItemNumber(),
					asnCombinedDto.getAsnDetails().get(i).getItemName(),
					asnCombinedDto.getAsnDetails().get(i).getExpectedQty(),
					asnCombinedDto.getAsnDetails().get(i).getShippedQty(),
					asnCombinedDto.getAsnDetails().get(i).getRemainingQty(),
					asnCombinedDto.getAsnDetails().get(i).getCategory(),
					asnCombinedDto.getAsnDetails().get(i).getColor(), asnCombinedDto.getAsnDetails().get(i).getPrice(),
					asnCombinedDto.getAsnDetails().get(i).getSize(),
					asnCombinedDto.getAsnDetails().get(i).getImageData(),
					asnCombinedDto.getAsnDetails().get(i).getUpc(), asnCombinedDto.getAsnDetails().get(i).getSku(),
					asnCombinedDto.getAsnDetails().get(i).getTaxPercentage(),
					asnCombinedDto.getAsnDetails().get(i).getTaxCode(), purchase_Order.getExpectedDeliveryDate(),
					asnCombinedDto.getAsnDetails().get(i).getReceivedDate(), asn);

			asnPOItemDetailsRepo.save(asnDetails);
		}
		return asnCombinedDto;

	}

	@Override
	public PurchaseOrderCombinedDto savePurchaseOrder(PurchaseOrderCombinedDto combinedDto, String Id) {

		PurchaseOrder purchaseOrder = new PurchaseOrder(Id, combinedDto.getPurchaseOrderdto().getStatus(),
				combinedDto.getPurchaseOrderdto().getSupplierId(), combinedDto.getPurchaseOrderdto().getCost(),
				combinedDto.getPurchaseOrderdto().getTotalSKU(), combinedDto.getPurchaseOrderdto().getStoreLocation(),
				combinedDto.getPurchaseOrderdto().getCreationDate(),
				combinedDto.getPurchaseOrderdto().getReceiveAfter(),
				combinedDto.getPurchaseOrderdto().getReceiveBefore(),
				combinedDto.getPurchaseOrderdto().getExpectedDeliveryDate(), null);

		purchaseOrderRepo.save(purchaseOrder);

		PurchaseOrder po = purchaseOrderRepo.findFirstByOrderByPoNumberDesc();
		for (int i = 0; i < combinedDto.getPurchaseOrderItemsdto().size(); i++) {
			PurchaseOrderItems purchaseOrderItems = new PurchaseOrderItems(
					combinedDto.getPurchaseOrderItemsdto().get(i).getItemNumber(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getItemName(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getExpectedQty(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getReceivedQty(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getRemainingQty(), 0, null,
					combinedDto.getPurchaseOrderItemsdto().get(i).getCategory(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getColor(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getPrice(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getSize(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getImageData(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getUpc(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getSku(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getTaxPercentage(),
					combinedDto.getPurchaseOrderItemsdto().get(i).getTaxCode(), po);

			itemsRepo.save(purchaseOrderItems);

		}
		return combinedDto;

	}

	@Override
	public List<PurchaseOrderItemsdto> getPoItemsByPoNumber(String poNumber) {
		PurchaseOrder purchaseOrder = purchaseOrderRepo.findByPoNumber(poNumber);
		List<PurchaseOrderItems> purchaseOrderItems = itemsRepo.findAllByPurchaseOrder(purchaseOrder);

		List<PurchaseOrderItemsdto> PurchaseOrderItemsdto = new ArrayList<>();
		for (int i = 0; i < purchaseOrderItems.size(); i++) {
			// System.out.println("asn--" +
			// purchaseOrderItems.get(i).getPurchaseOrder().getAsn());
			if (purchaseOrderItems.get(i).getRemainingQty() != 0) {
				PurchaseOrderItemsdto purchaseOrderItemsdto = new PurchaseOrderItemsdto(
						purchaseOrderItems.get(i).getItemNumber(), purchaseOrderItems.get(i).getItemName(),
						purchaseOrderItems.get(i).getExpectedQty(), purchaseOrderItems.get(i).getReceivedQty(),
						purchaseOrderItems.get(i).getRemainingQty(), purchaseOrderItems.get(i).getCategory(),
						purchaseOrderItems.get(i).getColor(), purchaseOrderItems.get(i).getPrice(),
						purchaseOrderItems.get(i).getSize(), purchaseOrderItems.get(i).getImageData(),
						purchaseOrderItems.get(i).getUpc(), purchaseOrderItems.get(i).getSku(),
						purchaseOrderItems.get(i).getTaxPercentage(), purchaseOrderItems.get(i).getTaxCode(),
						purchaseOrderItems.get(i).getDamageQty(), purchaseOrderItems.get(i).getDamageImage());
				PurchaseOrderItemsdto.add(purchaseOrderItemsdto);
			}

		}
		return PurchaseOrderItemsdto;
	}

	// Function get PO Summary

	// @Override
//	public List<PurchaseOrderItemsdto> getPoItemsSummaryByPoNumber(String poNumber) {
//
//		PurchaseOrder purchaseOrder = purchaseOrderRepo.findByPoNumber(poNumber);
//		List<PurchaseOrderItems> purchaseOrderItems = itemsRepo.findAllByPurchaseOrder(purchaseOrder);
//		List<PurchaseOrderItemsdto> PurchaseOrderItemsdto = new ArrayList<>();
//		for (int i = 0; i < purchaseOrderItems.size(); i++) {
//
//			PurchaseOrderItemsdto purchaseOrderItemsdto = new PurchaseOrderItemsdto(
//					purchaseOrderItems.get(i).getItemNumber(), purchaseOrderItems.get(i).getItemName(),
//					purchaseOrderItems.get(i).getExpectedQty(), purchaseOrderItems.get(i).getReceivedQty(),
//					purchaseOrderItems.get(i).getRemainingQty(), purchaseOrderItems.get(i).getCategory(),
//					purchaseOrderItems.get(i).getColor(), purchaseOrderItems.get(i).getPrice(),
//					purchaseOrderItems.get(i).getSize(), purchaseOrderItems.get(i).getImageData(),
//					purchaseOrderItems.get(i).getUpc(), purchaseOrderItems.get(i).getSku(),
//					purchaseOrderItems.get(i).getTaxPercentage(), purchaseOrderItems.get(i).getTaxCode(),
//					purchaseOrderItems.get(i).getDamageQty(), purchaseOrderItems.get(i).getDamageImage());
//			PurchaseOrderItemsdto.add(purchaseOrderItemsdto);
//
//		}
//		return PurchaseOrderItemsdto;
//	}

	@Override
	public List<ASNPOItemDetailsDto> getPoItemsByAsnNumber(String asnNumber) {

		ASN asn = asnRepo.findByasnNumber(asnNumber);
		List<ASNPOItemDetails> asnPOItemDetails = asnPOItemDetailsRepo.findByAsn(asn);

		List<ASNPOItemDetailsDto> items = new ArrayList<>();

		for (int i = 0; i < asnPOItemDetails.size(); i++) {
			ASNPOItemDetailsDto aSNPOItemDetailsDto = new ASNPOItemDetailsDto(asnPOItemDetails.get(i).getItemNumber(),
					asnPOItemDetails.get(i).getItemName(), asnPOItemDetails.get(i).getExpectedQty(),
					asnPOItemDetails.get(i).getShippedQty(), asnPOItemDetails.get(i).getRemainingQty(),
					asnPOItemDetails.get(i).getCategory(), asnPOItemDetails.get(i).getColor(),
					asnPOItemDetails.get(i).getPrice(), asnPOItemDetails.get(i).getSize(),
					asnPOItemDetails.get(i).getImageData(), asnPOItemDetails.get(i).getUpc(),
					asnPOItemDetails.get(i).getSku(), asnPOItemDetails.get(i).getTaxPercentage(),
					asnPOItemDetails.get(i).getTaxCode(), asnPOItemDetails.get(i).getReceivedDate());
			items.add(aSNPOItemDetailsDto);
		}
		return items;
	}

	@Override
	public List<PurchaseOrderItemsGetDto3> getPoItemDetailsByAsnNumber(String asnNumber) {

		ASN asn = asnRepo.findByasnNumber(asnNumber);
		List<ASNPOItemDetails> asnPOItemDetails = asnPOItemDetailsRepo.findByAsn(asn);

//		List<PurchaseOrder> Po = asn.getPurchaseOrder();
//
//		List<PurchaseOrderItemsGetDto3> purchaseOrderItems = new ArrayList<>();
//
//		for (int i = 0; i < Po.size(); i++) {
//			PurchaseOrder purchaseOrder = purchaseOrderRepo.findByPoNumber(Po.get(i).getPoNumber());
//			List<PurchaseOrderItems> pOrderItems = itemsRepo.findAllByPurchaseOrder(purchaseOrder);
//
//			for (int j = 0; j < pOrderItems.size(); j++) {
//				String sku = pOrderItems.get(j).getSku();
//				java.util.Optional<ASNPOItemDetails> anyEmpAbove40 = asnPOItemDetails.stream()
//						.filter(asn1 -> asn1.getSku().contains(sku)).findAny();
//
//				// System.out.println("anyEmpAbove40 " + anyEmpAbove40);
//				if (!anyEmpAbove40.isEmpty()) {
//					System.out.println("ifffffff");
//					purchaseOrderItems.add(new PurchaseOrderItemsGetDto3(pOrderItems.get(j).getItemNumber(),
//							pOrderItems.get(j).getItemName(), pOrderItems.get(j).getExpectedQty(),
//							pOrderItems.get(j).getReceivedQty(), pOrderItems.get(j).getRemainingQty(),
//							pOrderItems.get(j).getDamageQty(), pOrderItems.get(j).getDamageImage(),
//							pOrderItems.get(j).getSku(), pOrderItems.get(j).getPurchaseOrder().getPoNumber()));
//				}
//
//			}
//
//		}

		// System.out.println("purchaseOrderItems : " + purchaseOrderItems);

		return null;
	}

	@Override
	public String savePoToMaster(PurchaseOrderCombineddtotoSave combinedDto, String storeName) {

		System.out.print("combinedDto : " + combinedDto);
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

					item.setReceivedQty(
							item.getReceivedQty() + combinedDto.getPurchaseOrderItemsdto().get(i).getReceivedQty());
					item.setRemainingQty(Math.abs(
							item.getRemainingQty() - (combinedDto.getPurchaseOrderItemsdto().get(i).getReceivedQty()
									+ combinedDto.getPurchaseOrderItemsdto().get(i).getDamageQty())));
					item.setDamageQty(
							item.getDamageQty() + combinedDto.getPurchaseOrderItemsdto().get(i).getDamageQty());
					item.setDamageImage(combinedDto.getPurchaseOrderItemsdto().get(i).getDamageImage());

					if (item.getRemainingQty() == 0) {
						item.setCompleted(true);
					}

					itemsRepo.save(item);
				}
			}

		}

//		if (combinedDto.getPurchaseOrderItemsdto().get(0).getAsnNumber() != 0) {
//
//			int totalSku = 0;
//			ASN asn = asnRepo.findByasnNumber(combinedDto.getPurchaseOrderItemsdto().get(0).getAsnNumber());
//			asn.setStatus("Complete");
//
//			asn.setAttachedImage(combinedDto.getAttachedImage());
//			asnRepo.save(asn);
//
//			List<PurchaseOrder> po_list = asn.getPurchaseOrder();
//
//			List<PurchaseOrderItemsSaveDto> recievedItems = combinedDto.getPurchaseOrderItemsdto();
//
//			List<PurchaseOrderItemsdto> purchaseOrderItemsdto = new ArrayList<>();
//
//			if (po_list.size() > 1) {
//
//				for (int j = 0; j < recievedItems.size(); j++) {
//					if (recievedItems.get(j).getPoNumber() == 0) {
//
//						purchaseOrderItemsdto.add(new PurchaseOrderItemsdto(recievedItems.get(j).getItemNumber(),
//								recievedItems.get(j).getItemName(), recievedItems.get(j).getExpectedQty(),
//								recievedItems.get(j).getReceivedQty(), 0, recievedItems.get(j).getCategory(),
//								recievedItems.get(j).getColor(), recievedItems.get(j).getPrice(),
//								recievedItems.get(j).getSize(), recievedItems.get(j).getImageData(),
//								recievedItems.get(j).getUpc(), recievedItems.get(j).getSku(),
//								recievedItems.get(j).getTaxPercentage(), recievedItems.get(j).getTaxCode(),
//								recievedItems.get(j).getDamageQty(), recievedItems.get(j).getDamageImage()));
//					}
//					totalSku = totalSku + 1;
//				}
//
//				PurchaseOrder po1 = purchaseOrderRepo.findByPoNumber(po_list.get(0).getPoNumber());
//				PurchaseOrder purchaseOrder = new PurchaseOrder("Complete", po1.getSupplierId(), 0, totalSku, storeName,
//						LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(), null);
//
//				purchaseOrderRepo.save(purchaseOrder);
//				PurchaseOrder po2 = purchaseOrderRepo.findFirstByOrderByPoNumberDesc();
//
//				for (int k = 0; k < purchaseOrderItemsdto.size(); k++) {
//
//					PurchaseOrderItems purchaseOrderItems = new PurchaseOrderItems(
//							purchaseOrderItemsdto.get(k).getItemNumber(), purchaseOrderItemsdto.get(k).getItemName(),
//							purchaseOrderItemsdto.get(k).getExpectedQty(),
//							purchaseOrderItemsdto.get(k).getReceivedQty(), 0, 0, null,
//							purchaseOrderItemsdto.get(k).getCategory(), purchaseOrderItemsdto.get(k).getColor(),
//							purchaseOrderItemsdto.get(k).getPrice(), purchaseOrderItemsdto.get(k).getSize(),
//							purchaseOrderItemsdto.get(k).getImageData(), purchaseOrderItemsdto.get(k).getUpc(),
//							purchaseOrderItemsdto.get(k).getSku(), purchaseOrderItemsdto.get(k).getTaxPercentage(),
//							purchaseOrderItemsdto.get(k).getTaxCode(), po2);
//
//					itemsRepo.save(purchaseOrderItems);
//				}
//			}
//
//			else {
//
//				for (int j = 0; j < recievedItems.size(); j++) {
//					if (recievedItems.get(j).getPoNumber() == 0) {
//
//						PurchaseOrder po1 = purchaseOrderRepo.findByPoNumber(po_list.get(0).getPoNumber());
//
//						PurchaseOrderItems purchaseOrderItems = new PurchaseOrderItems(
//								recievedItems.get(j).getItemNumber(), recievedItems.get(j).getItemName(),
//								recievedItems.get(j).getExpectedQty(), recievedItems.get(j).getReceivedQty(), 0, 0,
//								null, recievedItems.get(j).getCategory(), recievedItems.get(j).getColor(),
//								recievedItems.get(j).getPrice(), recievedItems.get(j).getSize(),
//								recievedItems.get(j).getImageData(), recievedItems.get(j).getUpc(),
//								recievedItems.get(j).getSku(), recievedItems.get(j).getTaxPercentage(),
//								recievedItems.get(j).getTaxCode(), po1);
//
//						itemsRepo.save(purchaseOrderItems);
//					}
//				}
//			}
//
//			for (int i = 0; i < po_list.size(); i++) {
//				po_list.get(i).setAttachedImage(combinedDto.getAttachedImage());
//				List<PurchaseOrderItems> items = itemsRepo.findAllByPurchaseOrder(po_list.get(i));
//				for (int j = 0; j < items.size(); j++) {
//					int qty = items.get(j).getRemainingQty();
//					if (qty != 0) {
//						po_list.get(j).setStatus("PartialReceive");
//						purchaseOrderRepo.save(po_list.get(i));
//						break;
//					}
//				}
//
//				boolean allComplete = items.stream().allMatch((item) -> item.isCompleted() == true);
//				System.out.println("allComplete" + allComplete);
//				if (allComplete == true) {
//					po_list.get(i).setStatus("Complete");
//					purchaseOrderRepo.save(po_list.get(i));
//
//				}
//
//			}
//
//		}
//
//		else {
//			PurchaseOrder PO = purchaseOrderRepo
//					.findByPoNumber(combinedDto.getPurchaseOrderItemsdto().get(0).getPoNumber());
//			List<PurchaseOrderItems> itemsList = itemsRepo.findAllByPurchaseOrder(PO);
//
//			System.out.println("inside else po");
//			List<PurchaseOrderItemsSaveDto> recievedItems = combinedDto.getPurchaseOrderItemsdto();
//			for (int j = 0; j < recievedItems.size(); j++) {
//				if (recievedItems.get(j).getAsnNumber() == 0 && recievedItems.get(j).getPoNumber() == 0) {
//
//					PurchaseOrder po1 = purchaseOrderRepo.findByPoNumber(recievedItems.get(0).getPoNumber());
//
//					PurchaseOrderItems purchaseOrderItems = new PurchaseOrderItems(recievedItems.get(j).getItemNumber(),
//							recievedItems.get(j).getItemName(), recievedItems.get(j).getExpectedQty(),
//							recievedItems.get(j).getReceivedQty(), 0, 0, null, recievedItems.get(j).getCategory(),
//							recievedItems.get(j).getColor(), recievedItems.get(j).getPrice(),
//							recievedItems.get(j).getSize(), recievedItems.get(j).getImageData(),
//							recievedItems.get(j).getUpc(), recievedItems.get(j).getSku(),
//							recievedItems.get(j).getTaxPercentage(), recievedItems.get(j).getTaxCode(), po1);
//
//					itemsRepo.save(purchaseOrderItems);
//				}
//			}
//
//			PO.setAttachedImage(combinedDto.getAttachedImage());
//			for (int j = 0; j < itemsList.size(); j++) {
//				if (itemsList.get(j).getRemainingQty() != 0) {
//					PO.setStatus("PartialReceive");
//					purchaseOrderRepo.save(PO);
//					break;
//				}
//			}
//			boolean allComplete = itemsList.stream().allMatch((item) -> item.isCompleted() == true);
//			System.out.println("allComplete else" + allComplete);
//
//			if (allComplete == true) {
//				PO.setStatus("Complete");
//				purchaseOrderRepo.save(PO);
//
//			}
//		}

		ASN asn = asnRepo.findByasnNumber(combinedDto.getAsnNumber());
		asn.setStatus("Complete");

		asn.setAttachedImage(combinedDto.getAttachedImage());
		asnRepo.save(asn);

		return "Saved Successfully";
	}

	@Override
	public List<PurchaseOrderGetdto> getAllPO() {

		List<PurchaseOrder> purchaseOrder = purchaseOrderRepo.findAll();
		List<PurchaseOrderGetdto> purchaseOrder1 = new ArrayList<>();

		for (int i = 0; i < purchaseOrder.size(); i++) {
//			if (purchaseOrder.get(i).getAsn().isEmpty()) {
			PurchaseOrderGetdto purchaseOrderGetdto = new PurchaseOrderGetdto(purchaseOrder.get(i).getPoNumber(),
					purchaseOrder.get(i).getStatus(), purchaseOrder.get(i).getSupplierId(),
					purchaseOrder.get(i).getCost(), purchaseOrder.get(i).getTotalSKU(),
					purchaseOrder.get(i).getStoreLocation(), purchaseOrder.get(i).getCreationDate(),
					purchaseOrder.get(i).getReceiveAfter(), purchaseOrder.get(i).getReceiveBefore(),
					purchaseOrder.get(i).getExpectedDeliveryDate());
			purchaseOrder1.add(purchaseOrderGetdto);

		}

		return purchaseOrder1;

	}

	@Override
	public List<ASNDto> getAsnByPoNumber(String PoNumber) {

		List<ASN> asnList = asnRepo.findAll();
		System.out.println("asnlist " + asnList);
		List<ASNDto> asnDto = new ArrayList<>();

		for (int i = 0; i < asnList.size(); i++) {
			ASNDto dto = new ASNDto(asnList.get(i).getCreationDate(), asnList.get(i).getStatus(),
					asnList.get(i).getPurchaseOrder().getPoNumber(), asnList.get(i).getSupplier(),
					asnList.get(i).getTotalSKU(), asnList.get(i).getTotalQty());
			asnDto.add(dto);
		}

		return asnDto;

	}

	@Override
	public String saveDraftPoItems(List<DraftPurchaseOrderItems> draftPOItems) {

		System.out.println("draftPOItems : " + draftPOItems);
		if (draftPOItems.get(0).getAsnNumber() == null) {
			PurchaseOrder po = purchaseOrderRepo.findByPoNumber(draftPOItems.get(0).getPoNumber());
			po.setStatus("InProgress");
		} else {
			ASN asn = asnRepo.findByasnNumber(draftPOItems.get(0).getAsnNumber());
			asn.setStatus("InProgress");
		}
		for (int i = 0; i < draftPOItems.size(); i++) {
			draftPOItemsRepo.saveAll(draftPOItems);
		}
		return "Saved Successfully";
	}

	@Override
	public List<DraftPurchaseOrderItems> getDraftPoItemsByAsn(String number) {
		List<DraftPurchaseOrderItems> items = draftPOItemsRepo.findByAsnNumber(number);
		return items;
	}

	// Function to get product in the case when there is ASN
	@Override
	public ASNPOItemDetails getProductFromAsnTable(String sku, String asnNumber) {

		ASN asn = asnRepo.findByasnNumber(asnNumber);
		List<ASNPOItemDetails> items = asnPOItemDetailsRepo.findByAsn(asn);

		ASNPOItemDetails product = items.stream().filter(item -> item.getSku().equals(sku)).findAny().orElse(null);

		return product;

	}

	// Function to get product in the case when there is No ASN
	@Override
	public PurchaseOrderItems getProductFromPoTable(String sku, String poNumber) {

		PurchaseOrder po = purchaseOrderRepo.findByPoNumber(poNumber);
		PurchaseOrderItems item = itemsRepo.findBySkuAndPurchaseOrder(sku, po);

		// ASNPOItemDetails product = items.stream().filter(item ->
		// item.getSku().equals(sku)).findAny().orElse(null);

		return item;

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
