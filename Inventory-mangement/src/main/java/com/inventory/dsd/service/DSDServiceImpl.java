
package com.inventory.dsd.service;

import java.security.SecureRandom;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.inventory.adjustments.jpa.dto.InventoryAdjustmentCombinedDto;
import com.inventory.adjustments.jpa.dto.InventoryAdjustmentProductsdto;
import com.inventory.dsd.jpa.dto.DSDLandingDto;
import com.inventory.dsd.jpa.dto.DsdCombinedDto;
import com.inventory.dsd.jpa.dto.DsdDto;
import com.inventory.dsd.jpa.dto.DsdItemsdto;
import com.inventory.dsd.jpa.dto.SuppliersProductsDto;
import com.inventory.dsd.jpa.entity.DSD;
import com.inventory.dsd.jpa.entity.DsdItems;
import com.inventory.dsd.jpa.entity.Suppliers;
import com.inventory.dsd.jpa.entity.SuppliersProducts;
import com.inventory.exception.ExceptionHandling;
import com.inventory.myrepository.DsdItemsRepo;
import com.inventory.myrepository.DsdRepo;
import com.inventory.myrepository.DsdSuppliersRepo;
import com.inventory.myrepository.ProductDetailsRepo;
import com.inventory.myrepository.PurchaseOrderItemsRepo;
import com.inventory.myrepository.PurchaseOrderRepo;
import com.inventory.myrepository.StoreRepo;
import com.inventory.myrepository.SuppliersProductsRepo;
import com.inventory.po.jpa.entity.PurchaseOrder;
import com.inventory.po.jpa.entity.PurchaseOrderItems;
import com.inventory.product.jpa.entity.ProductDetails;
import com.inventory.store.jpa.entity.Stores;

import jakarta.transaction.Transactional;

@Service
public class DSDServiceImpl implements DSDService {

	@Autowired
	private ProductDetailsRepo productDetailsRepo;

	@Autowired
	private StoreRepo storeRepo;

	@Autowired
	private DsdRepo dsdRepo;

	@Autowired
	private DsdItemsRepo dsdItemsRepo;

	@Autowired
	private PurchaseOrderItemsRepo itemsRepo;

	@Autowired
	private PurchaseOrderRepo purchaseOrderRepo;

	@Autowired
	private SuppliersProductsRepo suppliersProductsRepo;

	@Autowired
	private DsdSuppliersRepo DsdSuppliersRepo;

	@Transactional
	@Override
	public String saveDsd(DsdCombinedDto dsdCombinedDto) {

		DSD dsd = dsdRepo.findByDsdNumber(dsdCombinedDto.getId());
		dsd.setStatus("Completed");
		dsd.setSupplierId(dsdCombinedDto.getSupplierId());
		dsd.setTotalSKU(dsdCombinedDto.getTotalSku());
		dsd.setAttachedImage(dsdCombinedDto.getImageData());
		dsd.setInvoiceNumber(dsdCombinedDto.getInvoiceNumber());

		Stores store = storeRepo.findByStoreName(dsd.getStoreLocation());
		Suppliers supplier = DsdSuppliersRepo.findBySupplierId(dsdCombinedDto.getSupplierId());
		dsd.setSupplierName(supplier.getSupplierName());
		dsd = dsdRepo.save(dsd);

		dsdItemsRepo.deleteAllByDsd(dsd);

		for (int i = 0; i < dsdCombinedDto.getItems().size(); i++) {
			DsdItems dsdItem = new DsdItems(dsdCombinedDto.getItems().get(i).getItemNumber(),
					dsdCombinedDto.getItems().get(i).getItemName(), 0, dsdCombinedDto.getItems().get(i).getQty(),
					dsdCombinedDto.getItems().get(i).getCategory(), dsdCombinedDto.getItems().get(i).getColor(),
					dsdCombinedDto.getItems().get(i).getSize(), dsdCombinedDto.getItems().get(i).getImageData(),
					dsdCombinedDto.getItems().get(i).getImage(), dsdCombinedDto.getItems().get(i).getUpc(),
					dsdCombinedDto.getItems().get(i).getSku(), dsd);

			dsdItemsRepo.save(dsdItem);

			ProductDetails productDetails1 = productDetailsRepo.findBySkuAndStore(dsdItem.getSku(), store);

			int Prev_sellableStock;
			int new_sellableStock;
			int totalSellable = 0;
			int prevTotalStock = 0;

			if (productDetails1 != null) {
				Prev_sellableStock = productDetails1.getSellableStock();
				new_sellableStock = dsdItem.getReceivedQty();
				totalSellable = Prev_sellableStock + new_sellableStock;

				prevTotalStock = productDetails1.getTotalStock();
				int total_stock = prevTotalStock + new_sellableStock;
				productDetails1.setTotalStock(total_stock);
				productDetails1.setSellableStock(totalSellable);

				productDetailsRepo.save(productDetails1);
			} else {
				throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Incorrect sku found ");
			}

		}

		PurchaseOrder purchaseOrder = new PurchaseOrder(generatePoIdString(), "Completed", supplier.getSupplierId(),
				supplier.getSupplierName(), 0, dsdCombinedDto.getTotalSku(), dsdCombinedDto.getItems().size(),
				dsd.getStoreLocation(), dsd.getCreationDate(), dsd.getCreationDate(), dsd.getCreationDate(),
				dsd.getCreationDate(), null);
		dsd.setPoNumber(purchaseOrder.getPoNumber());
		purchaseOrder = purchaseOrderRepo.save(purchaseOrder);

		List<PurchaseOrderItems> purchaseOrderItems = new ArrayList<>();

		for (int i = 0; i < dsdCombinedDto.getItems().size(); i++) {
			purchaseOrderItems.add(new PurchaseOrderItems(dsdCombinedDto.getItems().get(i).getItemNumber(),
					dsdCombinedDto.getItems().get(i).getItemName(), dsdCombinedDto.getItems().get(i).getExpectedQty(),
					0, null, dsdCombinedDto.getItems().get(i).getCategory(),
					dsdCombinedDto.getItems().get(i).getColor(), null, dsdCombinedDto.getItems().get(i).getSize(),
					dsdCombinedDto.getItems().get(i).getImageData(), null, dsdCombinedDto.getItems().get(i).getUpc(),
					dsdCombinedDto.getItems().get(i).getSku(), null, null, purchaseOrder));
			purchaseOrderItems.get(i).setReceivedQty(dsdCombinedDto.getItems().get(i).getQty());

		}

		itemsRepo.saveAll(purchaseOrderItems);

		return "Saved Successfully";
	}

	@Override
	public DsdDto createDsd(String storeName, String user) {

		Stores store = storeRepo.findByStoreName(storeName);
		if (store != null) {
			String dsdId = generateDsdIdString();
			LocalDate date = LocalDate.now();
			DSD dsd = new DSD();
			dsd.setDsdNumber(dsdId);
			dsd.setTotalSKU(0);
			dsd.setStoreLocation(storeName);
			dsd.setCreationDate(date);
			dsd.setUser(user);
			dsd.setStatus("In Progress");
			dsd = dsdRepo.save(dsd);

			DsdDto dsdDto = new DsdDto(dsd.getDsdNumber(), dsd.getCreationDate(), dsd.getStoreLocation(), dsd.getUser(),
					dsd.getStatus(), dsd.getTotalSKU(), "DSD");
			return dsdDto;
		} else {
			throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Please add the appropriate store ");
		}

	}

	@Override
	public List<DSDLandingDto> getAllDSd() {

		List<DSD> dsd = dsdRepo.findAll();

		List<DSDLandingDto> dsdDto = new ArrayList<>();
		for (int i = 0; i < dsd.size(); i++) {

			dsdDto.add(new DSDLandingDto(dsd.get(i).getDsdNumber(), dsd.get(i).getCreationDate(),
					dsd.get(i).getStatus(), dsd.get(i).getTotalSKU(), dsd.get(i).getSupplierId(), "DSD"));
		}
		return dsdDto;
	}

	@Override
	public DsdCombinedDto getDsdProductsByID(String id) {

		DSD dsd = dsdRepo.findByDsdNumber(id);

		List<DsdItems> dsdItems = dsdItemsRepo.findByDsd(dsd);

		List<DsdItemsdto> itemsDto = new ArrayList<>();

//		if (dsdItems.size() == 0) {
//			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data");
//		}

		for (int i = 0; i < dsdItems.size(); i++) {
			itemsDto.add(new DsdItemsdto(dsdItems.get(i).getItemNumber(), dsdItems.get(i).getItemName(),
					dsdItems.get(i).getReceivedQty(), dsdItems.get(i).getReceivedQty(), dsdItems.get(i).getCategory(),
					dsdItems.get(i).getColor(), dsdItems.get(i).getSize(), dsdItems.get(i).getImageData(),
					dsdItems.get(i).getImage(), dsdItems.get(i).getUpc(), dsdItems.get(i).getSku(), "DSD"));
		}

		DsdCombinedDto dsdCombinedDto = new DsdCombinedDto(id, dsd.getStatus(), dsd.getSupplierId(),
				dsd.getInvoiceNumber(), dsd.getAttachedImage(), dsd.getTotalSKU(), itemsDto);
		return dsdCombinedDto;
	}

	@Override
	public List<DSDLandingDto> sortDsdByLatest() {

		List<DSD> dsdList = dsdRepo.findAllByOrderByCreationDateDesc();

//		if (dsdList.size() == 0) {
//			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data was created ");
//		}
		List<DSDLandingDto> dsdDto = new ArrayList<>();
		for (int i = 0; i < dsdList.size(); i++) {

			dsdDto.add(new DSDLandingDto(dsdList.get(i).getDsdNumber(), dsdList.get(i).getCreationDate(),
					dsdList.get(i).getStatus(), dsdList.get(i).getTotalSKU(), dsdList.get(i).getSupplierId(), "DSD"));
		}
		return dsdDto;
	}

	@Override
	public List<DSDLandingDto> sortDsdByOldest() {

		List<DSD> dsdList = dsdRepo.findAllByOrderByCreationDateAsc();

//		if (dsdList.size() == 0) {
//			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data was created ");
//		}
		List<DSDLandingDto> dsdDto = new ArrayList<>();
		for (int i = 0; i < dsdList.size(); i++) {

			dsdDto.add(new DSDLandingDto(dsdList.get(i).getDsdNumber(), dsdList.get(i).getCreationDate(),
					dsdList.get(i).getStatus(), dsdList.get(i).getTotalSKU(), dsdList.get(i).getSupplierId(), "DSD"));
		}
		return dsdDto;
	}

	@Override
	public List<DSDLandingDto> filtersBySupplierNameOrStatus(String param) {

		List<DSD> dsd = dsdRepo.findBySupplierNameOrStatus(param, param);

//		if (dsd.size() == 0) {
//			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data");
//		}

		List<DSDLandingDto> invDto = new ArrayList<>();
		for (int i = 0; i < dsd.size(); i++) {

			invDto.add(new DSDLandingDto(dsd.get(i).getDsdNumber(), dsd.get(i).getCreationDate(),
					dsd.get(i).getStatus(), dsd.get(i).getTotalSKU(), dsd.get(i).getSupplierId(), "DSD"));
		}
		return invDto;
	}

	@Override
	public List<DSDLandingDto> getMatchedDSD(String dsdNumber) {

		List<DSD> dsd = dsdRepo.findByDsdNumberContaining(dsdNumber);

//		if (dsd.size() == 0) {
//			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data");
//		}

		List<DSDLandingDto> invDto = new ArrayList<>();
		for (int i = 0; i < dsd.size(); i++) {

			invDto.add(new DSDLandingDto(dsd.get(i).getDsdNumber(), dsd.get(i).getCreationDate(),
					dsd.get(i).getStatus(), dsd.get(i).getTotalSKU(), dsd.get(i).getSupplierId(), "DSD"));
		}
		return invDto;
	}

	@Override
	public List<DsdItemsdto> getSearchedItemInDsd(String id, String sku) {
		DSD dsd = dsdRepo.findByDsdNumber(id);

		List<DsdItems> dsdItems = dsdItemsRepo.findByDsdAndSkuContaining(dsd, sku);

		List<DsdItemsdto> dsdItemsdto = new ArrayList<>();

		for (int i = 0; i < dsdItems.size(); i++) {

			dsdItemsdto.add(new DsdItemsdto(dsdItems.get(i).getItemNumber(), dsdItems.get(i).getItemName(),
					dsdItems.get(i).getExpectedQty(), dsdItems.get(i).getReceivedQty(), dsdItems.get(i).getCategory(),
					dsdItems.get(i).getColor(), dsdItems.get(i).getSize(), dsdItems.get(i).getImageData(),
					dsdItems.get(i).getImage(), dsdItems.get(i).getUpc(), dsdItems.get(i).getSku(), "DSD"));
		}
		return dsdItemsdto;
	}

	public String generateDsdIdString() {
		final String CHARACTERS = "0123456789";
		final SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(10);
		sb.append("DSD");
		for (int i = 0; i < 12; i++) {
			sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

		}
		return sb.toString();
	}

	public String generatePoIdString() {
		final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		final SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(10);
		sb.append("PO-DSD");
		for (int i = 0; i < 12; i++) {
			sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

		}
		return sb.toString();
	}

	// Add products in DSD Suppliers
	@Override
	public String SaveSupplierProducts(List<SuppliersProductsDto> suppliersProducts) {

		for (int i = 0; i < suppliersProducts.size(); i++) {

			Suppliers suppplier = DsdSuppliersRepo.findBySupplierId(suppliersProducts.get(i).getSupplierId());
			SuppliersProducts suppliersProduct = new SuppliersProducts(suppliersProducts.get(i).getItemNumber(),
					suppliersProducts.get(i).getItemName(), suppliersProducts.get(i).getColor(),
					suppliersProducts.get(i).getPrice(), suppliersProducts.get(i).getSize(),
					suppliersProducts.get(i).getCategory(), suppliersProducts.get(i).getImageData(),
					suppliersProducts.get(i).getUpc(), suppliersProducts.get(i).getSku(),
					suppliersProducts.get(i).getStore(), suppplier);

			suppliersProductsRepo.save(suppliersProduct);
		}

		return "Products Added Successfully";
	}

	@Override
	public Map<String, String> getMatchedSuppliers(String param) {

		List<Suppliers> suppliers = DsdSuppliersRepo.findBySupplierIdContainingOrSupplierNameContaining(param, param);
		System.out.println("suppliers : " + suppliers);
		Map<String, String> suppliersMap = new HashMap<>();

		for (int i = 0; i < suppliers.size(); i++) {
			suppliersMap.put(suppliers.get(i).getSupplierId(), suppliers.get(i).getSupplierName());
		}
		return suppliersMap;
	}

//	@Override
//	public List<String> getMatchedSuppliersBySupplierId(String id) {
//
//		System.out.println("id" + id);
//		List<Suppliers> suppliers = DsdSuppliersRepo.findBySupplierIdContaining(id);
//		System.out.println("suppliers" + suppliers);
//		List<String> supplierNames = new ArrayList<>();
//		for (int i = 0; i < suppliers.size(); i++) {
//			supplierNames.add(suppliers.get(i).getSupplierName());
//		}
//		return supplierNames;
//	}

	// Api to get product from suppliers table
	@Override
	public InventoryAdjustmentCombinedDto getItemsToAdd(String supplierId, String sku, String storeName, String type) {

		Suppliers supplier = DsdSuppliersRepo.findBySupplierId(supplierId);
		List<SuppliersProducts> suppliersProduct = suppliersProductsRepo.findBySkuContainingAndSuppliersAndStore(sku,
				supplier, storeName);

		List<InventoryAdjustmentProductsdto> itemsDto = new ArrayList<>();
		for (int i = 0; i < suppliersProduct.size(); i++) {

			itemsDto.add(new InventoryAdjustmentProductsdto(suppliersProduct.get(i).getItemNumber(),
					suppliersProduct.get(i).getItemName(), suppliersProduct.get(i).getCategory(),
					suppliersProduct.get(i).getColor(), suppliersProduct.get(i).getSize(),
					suppliersProduct.get(i).getSku(), suppliersProduct.get(i).getUpc(), 0, null,
					suppliersProduct.get(i).getImageData(), type));
			// itemsDto.get(i).setType(type);
		}
		InventoryAdjustmentCombinedDto productDto = new InventoryAdjustmentCombinedDto(null, null, 0, null, null,
				itemsDto);

		return productDto;

	}

	// Api to get unique product by sku from suppliers table
	@Override
	public InventoryAdjustmentCombinedDto getSupplierItem(String supplierId, String sku, String storeName) {

		Suppliers supplier = DsdSuppliersRepo.findBySupplierId(supplierId);
		SuppliersProducts suppliersProduct = suppliersProductsRepo.findBySkuAndSuppliersAndStore(sku, supplier,
				storeName);
		System.out.println("suppliersProduct :" + suppliersProduct);
		List<InventoryAdjustmentProductsdto> itemsDto = new ArrayList<>();
		InventoryAdjustmentCombinedDto productDto = new InventoryAdjustmentCombinedDto();
		if (suppliersProduct != null) {

			Stores store1 = storeRepo.findByStoreName(storeName);
			ProductDetails Product = productDetailsRepo.findBySkuAndStore(sku, store1);

			itemsDto.add(new InventoryAdjustmentProductsdto(Product.getProduct().getItemNumber(),
					Product.getProduct().getitemName(), Product.getProduct().getCategory().getCategory(),
					Product.getColor(), Product.getSize(), Product.getSku(), Product.getUpc(),
					Product.getSellableStock(), null, Product.getImageData(), null));

			productDto = new InventoryAdjustmentCombinedDto(null, null, Product.getSellableStock(), null, null,
					itemsDto);
			System.out.println("inside");
			return productDto;
		} else {
			return null;
		}

	}

	@Override
	public String deleteByDsdNumber(String dsdNumber) {
		DSD dsd = dsdRepo.findByDsdNumber(dsdNumber);
		if (dsd.getStatus().equals("In Progress") || dsd.getStatus().equals("Saved")) {
			dsdRepo.deleteByDsdNumber(dsdNumber);
			return "Deleted Successfully";
		} else {
			return "Incorrect Id";
		}

	}

	// Scheduler to delete all orphan Dsd
	@Scheduled(cron = "0 01 16 * * ?") // This cron expression means the task will run at 10:30 PM every day
	@Transactional
	public void cleanUpOrphanedTableAEntries() {
		List<DSD> orphanedEntries = dsdRepo.findAllWithoutDsdItem();
		dsdRepo.deleteAll(orphanedEntries);
	}

	@Override
	public String DsdSaveAsDraft(DsdCombinedDto dsdCombinedDto) {

		DSD dsd = dsdRepo.findByDsdNumber(dsdCombinedDto.getId());
		dsd.setSupplierId(dsdCombinedDto.getSupplierId());
		dsd.setAttachedImage(dsdCombinedDto.getImageData());
		dsd.setTotalSKU(dsdCombinedDto.getTotalSku());
		dsd.setInvoiceNumber(dsdCombinedDto.getInvoiceNumber());

		DsdItems dsdItem = new DsdItems();
		dsdItemsRepo.deleteAllByDsd(dsd);
		for (int i = 0; i < dsdCombinedDto.getItems().size(); i++) {

			dsdItem = new DsdItems(dsdCombinedDto.getItems().get(i).getItemNumber(),
					dsdCombinedDto.getItems().get(i).getItemName(), 0, dsdCombinedDto.getItems().get(i).getQty(),
					dsdCombinedDto.getItems().get(i).getCategory(), dsdCombinedDto.getItems().get(i).getColor(),
					dsdCombinedDto.getItems().get(i).getSize(), dsdCombinedDto.getItems().get(i).getImageData(),
					dsdCombinedDto.getItems().get(i).getImage(), dsdCombinedDto.getItems().get(i).getUpc(),
					dsdCombinedDto.getItems().get(i).getSku(), dsd);

			dsdItem = dsdItemsRepo.save(dsdItem);

		}
		dsd.setStatus("In Progress");
		dsd = dsdRepo.save(dsd);

		return "Save as Draft saved successfully";
	}

}
