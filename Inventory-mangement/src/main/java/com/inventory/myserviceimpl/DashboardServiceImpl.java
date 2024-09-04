package com.inventory.myserviceimpl;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.mydto.MyTasksDto;
import com.inventory.myentity.ProductDetails;
import com.inventory.myentity.PurchaseOrder;
import com.inventory.myentity.PurchaseOrderItems;
import com.inventory.myentity.RTVInfo;
import com.inventory.myentity.StockCountCreation;
import com.inventory.myentity.Stores;
import com.inventory.myentity.TsfHead;
import com.inventory.myrepository.ProductDetailsRepo;
import com.inventory.myrepository.PurchaseOrderItemsRepo;
import com.inventory.myrepository.PurchaseOrderRepo;
import com.inventory.myrepository.ReturnTovendorInfoRepo;
import com.inventory.myrepository.StockCreationRepo;
import com.inventory.myrepository.StoreRepo;
import com.inventory.myrepository.TsfHeadRepo;
import com.inventory.myservice.DashboardService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private StoreRepo storeRepo;

	@Autowired
	private ProductDetailsRepo productDetailsRepo;

	@Autowired
	private TsfHeadRepo tsfHeadRepo;

	@Autowired
	private PurchaseOrderItemsRepo itemsRepo;

	@Autowired
	private PurchaseOrderRepo purchaseOrderRepo;

	@Autowired
	private StockCreationRepo creationRepo;

	@Autowired
	private ReturnTovendorInfoRepo rtvInfoRepo;

	@Override
	public HashMap<String, Integer> getInTransfers(String store) {

		int newRequest = 0;
		int accepted = 0;
		int shipped = 0;
		int delivered = 0;
		List<TsfHead> tsfList = tsfHeadRepo.findAllByStoreTo(store);

		for (int i = 0; i < tsfList.size(); i++) {
			String status = tsfList.get(i).getStatus();

			if (status.equals("New Request")) {
				newRequest = newRequest + 1;
			} else if (status.equals("Accepted")) {
				accepted = accepted + 1;
			} else if (status.equals("Shipped")) {
				shipped = shipped + 1;
			} else if (status.equals("Delivered")) {
				delivered = delivered + 1;
			}

		}
		HashMap<String, Integer> hashMap = new HashMap<>();

		hashMap.put("newRequest", newRequest);
		hashMap.put("accepted", accepted);
		hashMap.put("shipped", shipped);
		hashMap.put("delivered", delivered);
		return hashMap;
	}

	@Override
	public HashMap<String, Integer> getOutTransfers(String store) {

		int newRequest = 0;
		int accepted = 0;
		int shipped = 0;
		int delivered = 0;
		List<TsfHead> tsfList = tsfHeadRepo.findAllByStoreFrom(store);

		for (int i = 0; i < tsfList.size(); i++) {
			String status = tsfList.get(i).getStatus();

			if (status.equals("New Request")) {
				newRequest = newRequest + 1;
			} else if (status.equals("Accepted")) {
				accepted = accepted + 1;
			} else if (status.equals("Shipped")) {
				shipped = shipped + 1;
			} else if (status.equals("Delivered")) {
				delivered = delivered + 1;
			}

		}

		HashMap<String, Integer> hashMap = new HashMap<>();

		hashMap.put("newRequest", newRequest);
		hashMap.put("accepted", accepted);
		hashMap.put("shipped", shipped);
		hashMap.put("delivered", delivered);
		return hashMap;
	}

	@Override
	public HashMap<String, Float> getCategoryWiseVariance(String storeName) {

		int sportsWearVariance = 0;
		int WomenwearVariance = 0;
		int FootwearVariance = 0;
		int HandbagsVariance = 0;

		int sportsWearTotalBookQty = 0;
		int WomenwearTotalBookQty = 0;
		int FootwearTotalBookQty = 0;
		int HandbagsTotalBookQty = 0;

		int sportsWearCount = 0;
		int WomenwearCount = 0;
		int FootwearCount = 0;
		int HandbagsCount = 0;

		float sportsWearVarianceAvg = 0;
		float WomenwearVarianceAvg = 0;
		float FootwearVarianceAvg = 0;
		float HandbagsVarianceAvg = 0;

		float sportsWearVarianceAvgPercentage = 0;
		float WomenwearVarianceAvgPercentage = 0;
		float FootwearVarianceAvgPercentage = 0;
		float HandbagsVarianceAvgPercentage = 0;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate currentDateInLocalDate = LocalDate.now();// .format(formatter);
		LocalDate pastDateInLocalDate = currentDateInLocalDate.minusMonths(1);

		String currentDate = currentDateInLocalDate.format(formatter);
		String pastDate = pastDateInLocalDate.format(formatter);

		List<StockCountCreation> product = creationRepo.findByCreationDateBetween(pastDateInLocalDate,
				currentDateInLocalDate);
		System.out.println("product :" + product);
		for (int j = 0; j < product.size(); j++) {

			if (product.get(j).getCategory().equals("Sportswear")) {

				sportsWearVariance = sportsWearVariance + product.get(j).getTotalVarianceQty();
				sportsWearTotalBookQty = sportsWearTotalBookQty + product.get(j).getTotalBookQty();
				sportsWearCount++;
			}
			if (product.get(j).getCategory().equals("Womenwear")) {

				WomenwearVariance = WomenwearVariance + product.get(j).getTotalVarianceQty();
				WomenwearTotalBookQty = WomenwearTotalBookQty + product.get(j).getTotalBookQty();
				WomenwearCount++;
			}
			if (product.get(j).getCategory().equals("Footwear")) {

				FootwearVariance = FootwearVariance + product.get(j).getTotalVarianceQty();
				FootwearTotalBookQty = FootwearTotalBookQty + product.get(j).getTotalBookQty();
				FootwearCount++;
			}
			if (product.get(j).getCategory().equals("Handbags")) {

				HandbagsVariance = HandbagsVariance + product.get(j).getTotalVarianceQty();
				HandbagsTotalBookQty = HandbagsTotalBookQty + product.get(j).getTotalBookQty();
				HandbagsCount++;
			}

		}

		if (sportsWearCount != 0) {
			sportsWearVarianceAvg = sportsWearVariance / sportsWearCount;
			sportsWearVarianceAvgPercentage = (sportsWearVarianceAvg / sportsWearTotalBookQty);
		}

		else if (WomenwearCount != 0) {
			WomenwearVarianceAvg = WomenwearVariance / WomenwearCount;
			WomenwearVarianceAvgPercentage = (WomenwearVarianceAvg / WomenwearTotalBookQty) * 100;
		}

		else if (FootwearCount != 0) {
			FootwearVarianceAvg = FootwearVariance / FootwearCount;
			FootwearVarianceAvgPercentage = (FootwearVarianceAvg / FootwearTotalBookQty) * 100;
		}

		else if (HandbagsCount != 0) {
			HandbagsVarianceAvg = HandbagsVariance / HandbagsCount;
			HandbagsVarianceAvgPercentage = (HandbagsVarianceAvg / HandbagsTotalBookQty) * 100;
		}

		HashMap<String, Float> hashMap = new HashMap<>();

		hashMap.put("sportsWearVarianceAvgPercentage", sportsWearVarianceAvgPercentage);
		hashMap.put("WomenwearVarianceAvgPercentage", WomenwearVarianceAvgPercentage);
		hashMap.put("FootwearVarianceAvgPercentage", FootwearVarianceAvgPercentage);
		hashMap.put("HandbagsVarianceAvgPercentage", HandbagsVarianceAvgPercentage);

		System.out.println("sportsWearVariance : " + sportsWearVariance);
		System.out.println("FootwearVariance : " + FootwearVariance);
		System.out.println("HandbagsVariance : " + HandbagsVariance);
		System.out.println("WomenwearVariance : " + WomenwearVariance);
		System.out.println("sportsWearCount : " + sportsWearCount);
		System.out.println("HandbagsCount : " + HandbagsCount);
		System.out.println("FootwearCount : " + FootwearCount);
		System.out.println("WomenwearCount : " + WomenwearCount);

		System.out.println("----------------------------------------------------------------------------");

		System.out.println("sportsWearTotalBookQty : " + sportsWearTotalBookQty);
		System.out.println("WomenwearTotalBookQty : " + WomenwearTotalBookQty);
		System.out.println("FootwearTotalBookQty : " + FootwearTotalBookQty);
		System.out.println("HandbagsTotalBookQty : " + HandbagsTotalBookQty);

		System.out.println("----------------------------------------------------------------------------");

		System.out.println("sportsWearVarianceAvg : " + sportsWearVarianceAvg);
		System.out.println("WomenwearVarianceAvg : " + WomenwearVarianceAvg);
		System.out.println("FootwearVarianceAvg : " + FootwearVarianceAvg);
		System.out.println("HandbagsVarianceAvg : " + HandbagsVarianceAvg);
		System.out.println("sportsWearVarianceAvgPercentage : " + sportsWearVarianceAvgPercentage);
		System.out.println("WomenwearVarianceAvgPercentage : " + WomenwearVarianceAvgPercentage);
		System.out.println("FootwearVarianceAvgPercentage : " + FootwearVarianceAvgPercentage);
		System.out.println("HandbagsVarianceAvgPercentage : " + HandbagsVarianceAvgPercentage);

		return hashMap;

	}

	@Override
	public HashMap<String, Integer> getInventoryDiscrepancyRatio(String store) {

		int stockOk = 0;
		int excess = 0;
		int shortQty = 0;
		int damaged = 0;

		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate currentDateInLocalDate = LocalDate.now();// .format(formatter);
		LocalDate pastDateInLocalDate = currentDateInLocalDate.minusMonths(1);

//		String currentDate = currentDateInLocalDate.format(formatter);
//		String pastDate = pastDateInLocalDate.format(formatter);

		List<PurchaseOrder> PO = purchaseOrderRepo.findByCreationDateBetweenAndStoreLocation(pastDateInLocalDate,
				currentDateInLocalDate, store);

		for (int i = 0; i < PO.size(); i++) {

			List<PurchaseOrderItems> products = itemsRepo.findAllByPurchaseOrder(PO.get(i));

			for (int j = 0; j < products.size(); j++) {
				if (products.get(j).getReceivedQty() > products.get(j).getExpectedQty()) {
					excess = excess + (products.get(j).getReceivedQty() - products.get(j).getExpectedQty());

				}
				if (products.get(j).getReceivedQty() < products.get(j).getExpectedQty()) {
					shortQty = shortQty + (products.get(j).getExpectedQty() - products.get(j).getReceivedQty());

				}
				if (products.get(j).getDamageQty() != 0) {
					damaged = damaged + products.get(j).getDamageQty();
				}
				stockOk = stockOk + (products.get(j).getReceivedQty() - products.get(j).getDamageQty());
			}
		}

		HashMap<String, Integer> hashMap = new HashMap<>();

		hashMap.put("stockOk", stockOk);
		hashMap.put("excess", excess);
		hashMap.put("shortQty", shortQty);
		hashMap.put("damaged", damaged);
		return hashMap;
	}

	// My tasks API Function

	@Override
	public List<MyTasksDto> getMyTasks(String storeName) {

		List<MyTasksDto> myTasks = new ArrayList<>();

		int sellableStock = 0;
		int NonsellableStock = 0;
		int pendingPO = 0;
		int CompletePO = 0;
		int shippedTransfers = 0;
		int CompleteTransfers = 0;
		int pendingStockCount = 0;
		int CompletedStockCount = 0;
		int pendingRTV = 0;
		int CompletedRTV = 0;

		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate currentDateInLocalDate = LocalDate.now();// .format(formatter);
		LocalDate pastDateInLocalDate = currentDateInLocalDate.minusMonths(1);

//		String currentDate = currentDateInLocalDate.format(formatter);
//		String pastDate = pastDateInLocalDate.format(formatter);

		Stores store = storeRepo.findByStoreName(storeName);
		List<ProductDetails> items = productDetailsRepo.findAllByStore(store);

		// stock in hand

		if (items != null) {

			for (int i = 0; i < items.size(); i++) {
				sellableStock = sellableStock + items.get(i).getSellableStock();
				NonsellableStock = NonsellableStock + items.get(i).getNonSellableStock();
			}

			float CompletionPercentageValue = (float) sellableStock / (sellableStock + NonsellableStock);

			myTasks.add(
					new MyTasksDto("Stock In Hand", CompletionPercentageValue, NonsellableStock, "Non sellable units"));
		}

		List<PurchaseOrder> PO = purchaseOrderRepo.findByCreationDateBetweenAndStoreLocation(pastDateInLocalDate,
				currentDateInLocalDate, storeName);

		// Pending or Complete PO

		if (PO != null) {

			float CompletionPercentageValue = 0;
			for (int i = 0; i < PO.size(); i++) {
				if (PO.get(i).getStatus().equals("pending")) {
					pendingPO = pendingPO + 1;

				} else {
					CompletePO = CompletePO + 1;
				}
			}
			CompletionPercentageValue = (float) CompletePO / (CompletePO + pendingPO);
			myTasks.add(new MyTasksDto("PO Receive", CompletionPercentageValue, pendingPO, "Pending"));

		}

		// TransferReceive
		List<TsfHead> tsfList = tsfHeadRepo.findByCreationDateBetweenAndStoreTo(pastDateInLocalDate,
				currentDateInLocalDate, storeName);

		if (tsfList != null) {
			float CompletionPercentageValue = 0;
			for (int i = 0; i < tsfList.size(); i++) {
				if (tsfList.get(i).getStatus().equals("Shipped")) {
					shippedTransfers = shippedTransfers + 1;
				} else if (tsfList.get(i).getStatus().equals("Delivered")) {
					CompleteTransfers = CompleteTransfers + 1;
				}
			}
			CompletionPercentageValue = (float) CompleteTransfers / (CompleteTransfers + shippedTransfers);
			myTasks.add(new MyTasksDto("Transfer Receive", CompletionPercentageValue, shippedTransfers, "In Transit"));
		}

		// StockCount
		List<StockCountCreation> stockCount = creationRepo.findByCreationDateBetweenAndStore(pastDateInLocalDate,
				currentDateInLocalDate, storeName);

		if (stockCount != null) {
			float CompletionPercentageValue = 0;
			for (int i = 0; i < stockCount.size(); i++) {
				if (stockCount.get(i).getRecountStatus().equals("complete")
						&& stockCount.get(i).getStatus().equals("complete")) {
					CompletedStockCount = CompletedStockCount + 1;
				} else {
					pendingStockCount = pendingStockCount + 1;
				}
			}
			CompletionPercentageValue = (float) CompletedStockCount / (CompletedStockCount + pendingStockCount);
			myTasks.add(new MyTasksDto("Stock Count", CompletionPercentageValue, pendingStockCount, "Pending"));
		}

		// RTV
		List<RTVInfo> rtvInfo = rtvInfoRepo.findByCreationDateBetweenAndStoreId(pastDateInLocalDate,
				currentDateInLocalDate, store.getStoreId());

		if (rtvInfo != null) {
			float CompletionPercentageValue = 0;
			for (int i = 0; i < rtvInfo.size(); i++) {
				if (rtvInfo.get(i).getStatus().equals("Dispatched")) {
					CompletedRTV = CompletedRTV + 1;

				} else {
					pendingRTV = pendingRTV + 1;
				}
			}

			CompletionPercentageValue = (float) CompletedRTV / (CompletedRTV + pendingRTV);
			myTasks.add(new MyTasksDto("Return to Vendor", CompletionPercentageValue, pendingRTV, "Pending"));
		}

//		System.out.println("sellableStock " + sellableStock);
//		System.out.println("NonsellableStock " + NonsellableStock);
//		System.out.println("pendingPO " + pendingPO);
//		System.out.println("CompletePO " + CompletePO);
//		System.out.println("shippedTransfers " + shippedTransfers);
//		System.out.println("CompleteTransfers " + CompleteTransfers);
//		System.out.println("pendingStockCount " + pendingStockCount);
//		System.out.println("CompletedStockCount " + CompletedStockCount);
//		System.out.println("pendingRTV " + pendingRTV);
//		System.out.println("CompleteRTV " + CompletedRTV);
//
//		System.out.println("myTasks RTV: " + myTasks);

		return myTasks;

	}

}
