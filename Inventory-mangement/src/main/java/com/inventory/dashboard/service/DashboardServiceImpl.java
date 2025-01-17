package com.inventory.dashboard.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dashboard.jpa.dto.CategoryWiseDashboardDto;
import com.inventory.dashboard.jpa.dto.MyTasksDto;
import com.inventory.myrepository.ProductDetailsRepo;
import com.inventory.myrepository.PurchaseOrderItemsRepo;
import com.inventory.myrepository.PurchaseOrderRepo;
import com.inventory.myrepository.ReturnTovendorInfoRepo;
import com.inventory.myrepository.StockCreationRepo;
import com.inventory.myrepository.StoreRepo;
import com.inventory.myrepository.TsfHeadRepo;
import com.inventory.po.jpa.entity.PurchaseOrder;
import com.inventory.po.jpa.entity.PurchaseOrderItems;
import com.inventory.product.jpa.entity.ProductDetails;
import com.inventory.rtv.jpa.entity.RTVInfo;
import com.inventory.sc.jpa.entity.StockCountCreation;
import com.inventory.store.jpa.entity.Stores;
import com.inventory.tsf.jpa.dto.TransfersStatusDashboardDto;
import com.inventory.tsf.jpa.entity.TsfHead;

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
	public TransfersStatusDashboardDto getTransferStatus(String store) {

		List<Long> transfersRequest = new ArrayList<>();
		List<Long> transferFulfillment = new ArrayList<>();
		List<String> tsfCount1 = Arrays.asList("New Request", "Partially Accepted", "Shipped", "Delivered");
		List<TsfHead> tsfList = tsfHeadRepo.findAllByStoreTo(store);
		List<TsfHead> tsfList1 = tsfHeadRepo.findAllByStoreFrom(store);
		Map<String, Long> tsfStatusCount = tsfList.stream()
				.collect(Collectors.groupingBy(TsfHead::getStatus, Collectors.counting()));
		Map<String, Long> ntsfStatusCount = tsfList1.stream()
				.collect(Collectors.groupingBy(TsfHead::getStatus, Collectors.counting()));

		for (int i = 0; i < tsfCount1.size(); i++) {
			if (tsfStatusCount.get(tsfCount1.get(i)) != null) {
				transfersRequest.add(tsfStatusCount.get(tsfCount1.get(i)));
			} else {
				transfersRequest.add((long) 0);
			}
		}

		for (int i = 0; i < tsfCount1.size(); i++) {
			if (ntsfStatusCount.get(tsfCount1.get(i)) != null) {
				transferFulfillment.add(ntsfStatusCount.get(tsfCount1.get(i)));
			} else {
				transferFulfillment.add((long) 0);
			}
		}

		TransfersStatusDashboardDto tsfDashboardDto = new TransfersStatusDashboardDto(transfersRequest,
				transferFulfillment);

		return tsfDashboardDto;
	}

	@Override
	public List<CategoryWiseDashboardDto> getCategoryWiseVariance(String storeName) {

		List<CategoryWiseDashboardDto> CategoryWiseDto = new ArrayList<>();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate currentDateInLocalDate = LocalDate.now();// .format(formatter);
		LocalDate pastDateInLocalDate = currentDateInLocalDate.minusMonths(3);

		String currentDate = currentDateInLocalDate.format(formatter);
		String pastDate = pastDateInLocalDate.format(formatter);

		List<StockCountCreation> product = creationRepo.findByStatusAndCreationDateBetween("Completed",
				pastDateInLocalDate, currentDateInLocalDate);

		System.out.println("Category wise pro " + product);

		Map<String, Double> totalCountedDict = product.stream().collect(Collectors.groupingBy(
				StockCountCreation::getCategory, Collectors.summingDouble(StockCountCreation::getTotalCountedQty)));
		System.out.println(totalCountedDict);

		Map<String, Double> totalBookedDict = product.stream().collect(Collectors.groupingBy(
				StockCountCreation::getCategory, Collectors.summingDouble(StockCountCreation::getTotalBookQty)));

		// using keySet() for iteration over keys
		for (String name : totalBookedDict.keySet())
			CategoryWiseDto
					.add(new CategoryWiseDashboardDto(name, totalCountedDict.get(name), totalBookedDict.get(name)));

		System.out.println(CategoryWiseDto);

		return CategoryWiseDto;

	}

	@Override
	public HashMap<String, Integer> getInventoryDiscrepancyRatio(String store) {

		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		LocalDate currentDateInLocalDate = LocalDate.now();
//		LocalDate pastDateInLocalDate = currentDateInLocalDate.minusMonths(1);

		Stores store1 = storeRepo.findByStoreName(store);
		List<ProductDetails> items = productDetailsRepo.findAllByStore(store1);

		int sellableStock = items.stream().mapToInt(ProductDetails::getSellableStock).sum();
		int nonsellableStock = items.stream().mapToInt(ProductDetails::getNonSellableStock).sum();
		System.out.println("Sellable " + sellableStock);
		System.out.println("NonSellable " + nonsellableStock);

		List<PurchaseOrder> PO = purchaseOrderRepo.findAllByStoreLocation(store);

		int damageStock = 0;
		for (int i = 0; i < PO.size(); i++) {

			List<PurchaseOrderItems> products = itemsRepo.findAllByPurchaseOrder(PO.get(i));
			damageStock = products.stream().mapToInt(PurchaseOrderItems::getDamageQty).sum();
		}

		HashMap<String, Integer> hashMap = new HashMap<>();

		hashMap.put("sellableStock", sellableStock);
		hashMap.put("nonsellableStock", nonsellableStock);
		hashMap.put("damageStock", damageStock);

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
					new MyTasksDto("Stock In Hand", CompletionPercentageValue, NonsellableStock, "Non-sellable Units"));
		}

		List<PurchaseOrder> PO = purchaseOrderRepo.findByCreationDateBetweenAndStoreLocation(pastDateInLocalDate,
				currentDateInLocalDate, storeName);

		// Pending or Completed PO

		if (!PO.isEmpty()) {

			float CompletionPercentageValue = 0;
			for (int i = 0; i < PO.size(); i++) {
				if (PO.get(i).getStatus().equals("Pending")) {
					pendingPO = pendingPO + 1;

				} else {
					CompletePO = CompletePO + 1;
				}
			}
			CompletionPercentageValue = (float) CompletePO / (CompletePO + pendingPO);
			myTasks.add(new MyTasksDto("PO Receive", CompletionPercentageValue, pendingPO, "Pending"));

		} else {
			myTasks.add(new MyTasksDto("PO Receive", 0, pendingPO, "Pending"));

		}

		// TransferReceive
		List<TsfHead> tsfList = tsfHeadRepo.findByCreationDateBetweenAndStoreTo(pastDateInLocalDate,
				currentDateInLocalDate, storeName);

		System.out.println("tsfList :" + tsfList);
		if (!tsfList.isEmpty()) {
			System.out.println("tsfffffffff");
			float CompletionPercentageValue = 0;
			for (int i = 0; i < tsfList.size(); i++) {
				if (tsfList.get(i).getStatus().equals("Shipped")) {
					shippedTransfers = shippedTransfers + 1;
				} else if (tsfList.get(i).getStatus().equals("Delivered")) {
					CompleteTransfers = CompleteTransfers + 1;
				}
			}
			if (CompleteTransfers != 0) {
				CompletionPercentageValue = (float) CompleteTransfers / (CompleteTransfers + shippedTransfers);
				myTasks.add(
						new MyTasksDto("Transfer Receive", CompletionPercentageValue, shippedTransfers, "In Transit"));
			} else {
				myTasks.add(new MyTasksDto("Transfer Receive", 0, shippedTransfers, "In Transit"));

			}

		}

		// StockCount
		List<StockCountCreation> stockCount = creationRepo.findByCreationDateBetweenAndStore(pastDateInLocalDate,
				currentDateInLocalDate, storeName);

		if (!stockCount.isEmpty()) {
			float CompletionPercentageValue = 0;
			for (int i = 0; i < stockCount.size(); i++) {
				if (stockCount.get(i).getRecountStatus().equals("Completed")
						&& stockCount.get(i).getStatus().equals("Completed")) {
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

		if (!rtvInfo.isEmpty()) {
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
		} else {
			myTasks.add(new MyTasksDto("Return to Vendor", 0, pendingRTV, "Pending"));

		}

//		System.out.println("myTasks RTV: " + myTasks);

		return myTasks;

	}

}
