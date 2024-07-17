
package com.inventory.myserviceimpl;

import java.security.SecureRandom;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.inventory.mydto.DSDLandingDto;
import com.inventory.mydto.DsdCombinedDto;
import com.inventory.mydto.DsdDto;
import com.inventory.mydto.DsdItemsdto;
import com.inventory.mydto.InventoryAdjustmentLandingDto;
import com.inventory.mydto.SuppliersProductsDto;
import com.inventory.myentity.DSD;
import com.inventory.myentity.DsdItems;
import com.inventory.myentity.InventoryAdjustment;
import com.inventory.myentity.ProductDetails;
import com.inventory.myentity.PurchaseOrder;
import com.inventory.myentity.PurchaseOrderItems;
import com.inventory.myentity.Stores;
import com.inventory.myentity.Suppliers;
import com.inventory.myentity.SuppliersProducts;
import com.inventory.myexception.ExceptionHandling;
import com.inventory.myrepository.DsdItemsRepo;
import com.inventory.myrepository.DsdRepo;
import com.inventory.myrepository.DsdSuppliersRepo;
import com.inventory.myrepository.ProductDetailsRepo;
import com.inventory.myrepository.ProductRepo;
import com.inventory.myrepository.PurchaseOrderItemsRepo;
import com.inventory.myrepository.PurchaseOrderRepo;
import com.inventory.myrepository.StoreRepo;
import com.inventory.myrepository.SuppliersProductsRepo;
import com.inventory.myservice.DSDService;

@Service
public class DSDServiceImpl implements DSDService {

	@Autowired
	private DsdSuppliersRepo DsdSuppliersRepo;

	@Autowired
	private ProductRepo productRepo;

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

	@Override
	public String saveDsd(DsdCombinedDto dsdCombinedDto) {

		DSD dsd = dsdRepo.findByDsdNumber(dsdCombinedDto.getId());
		dsd.setStatus(dsdCombinedDto.getStatus());
		dsd.setSupplierName(dsdCombinedDto.getSupplierName());
		dsd.setTotalSKU(dsdCombinedDto.getTotalSKU());
		dsd.setAttachedImage(dsdCombinedDto.getAttachedImage());
		dsd.setInvoiceNumber(dsdCombinedDto.getInvoiceNumber());

		dsd = dsdRepo.save(dsd);

		Stores store = storeRepo.findByStoreName(dsd.getStoreLocation());

		for (int i = 0; i < dsdCombinedDto.getDsdItems().size(); i++) {
			DsdItems dsdItem = new DsdItems(dsdCombinedDto.getDsdItems().get(i).getItemNumber(),
					dsdCombinedDto.getDsdItems().get(i).getItemName(),
					dsdCombinedDto.getDsdItems().get(i).getExpectedQty(),
					dsdCombinedDto.getDsdItems().get(i).getReceivedQty(),
					dsdCombinedDto.getDsdItems().get(i).getCategory(), dsdCombinedDto.getDsdItems().get(i).getColor(),
					dsdCombinedDto.getDsdItems().get(i).getSize(), dsdCombinedDto.getDsdItems().get(i).getImageData(),
					dsdCombinedDto.getDsdItems().get(i).getUpc(), dsdCombinedDto.getDsdItems().get(i).getSku(), dsd);

			dsdItemsRepo.save(dsdItem);

			ProductDetails productDetails1 = productDetailsRepo.findBySkuAndStore(dsdItem.getSku(), store);

			int Prev_sellableStock;
			int new_sellableStock;
			int totalSellable = 0;

			if (productDetails1 != null) {
				Prev_sellableStock = productDetails1.getSellableStock();
				new_sellableStock = dsdItem.getReceivedQty();
				totalSellable = Prev_sellableStock + new_sellableStock;

				int total_stock = totalSellable;
				productDetails1.setTotalStock(total_stock);
				productDetails1.setSellableStock(totalSellable);

				productDetailsRepo.save(productDetails1);
			} else {
				throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Incorrect sku found ");
			}

		}

		Suppliers supplier = DsdSuppliersRepo.findBysupplierName(dsdCombinedDto.getSupplierName());
		PurchaseOrder purchaseOrder = new PurchaseOrder(generatePoIdString(), dsdCombinedDto.getStatus(),
				supplier.getSupplierId(), 0, dsdCombinedDto.getTotalSKU(), dsd.getStoreLocation(),
				dsd.getCreationDate(), dsd.getCreationDate(), dsd.getCreationDate(), dsd.getCreationDate(), null);
		dsd.setPoNumber(purchaseOrder.getPoNumber());
		purchaseOrderRepo.save(purchaseOrder);

		for (int i = 0; i < dsdCombinedDto.getDsdItems().size(); i++) {
			PurchaseOrderItems purchaseOrderItems = new PurchaseOrderItems(
					dsdCombinedDto.getDsdItems().get(i).getItemNumber(),
					dsdCombinedDto.getDsdItems().get(i).getItemName(),
					dsdCombinedDto.getDsdItems().get(i).getExpectedQty(),
					dsdCombinedDto.getDsdItems().get(i).getReceivedQty(), 0, 0, null,
					dsdCombinedDto.getDsdItems().get(i).getCategory(), dsdCombinedDto.getDsdItems().get(i).getColor(),
					null, dsdCombinedDto.getDsdItems().get(i).getSize(),
					dsdCombinedDto.getDsdItems().get(i).getImageData(), dsdCombinedDto.getDsdItems().get(i).getUpc(),
					dsdCombinedDto.getDsdItems().get(i).getSku(), null, null, purchaseOrder);

			itemsRepo.save(purchaseOrderItems);

		}

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
			dsd.setStoreLocation(storeName);
			dsd.setCreationDate(date);
			dsd = dsdRepo.save(dsd);

			DsdDto dsdDto = new DsdDto(dsd.getDsdNumber(), dsd.getCreationDate(), dsd.getStoreLocation(), dsd.getUser(),
					dsd.getStatus(), "DSD");
			return dsdDto;
		} else {
			throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Please add the appropriate store ");
		}

	}

	@Override
	public List<DSDLandingDto> getAllDSd() {

		List<DSD> dsd = dsdRepo.findAll();
		// System.out.println("inventory_list " + inventory_list);
		if (dsd.size() == 0) {
			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data");
		}

		List<DSDLandingDto> dsdDto = new ArrayList<>();
		for (int i = 0; i < dsd.size(); i++) {

			dsdDto.add(new DSDLandingDto(dsd.get(i).getDsdNumber(), dsd.get(i).getCreationDate(),
					dsd.get(i).getStatus(), dsd.get(i).getTotalSKU(), dsd.get(i).getSupplierName(), "DSD"));
		}
		return dsdDto;
	}

	@Override
	public DsdCombinedDto getDsdProductsByID(String id) {

		DSD dsd = dsdRepo.findByDsdNumber(id);

		List<DsdItems> dsdItems = dsdItemsRepo.findByDsd(dsd);

		List<DsdItemsdto> itemsDto = new ArrayList<>();

		if (dsdItems.size() == 0) {
			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data");
		}

		for (int i = 0; i < dsdItems.size(); i++) {
			itemsDto.add(new DsdItemsdto(dsdItems.get(i).getItemNumber(), dsdItems.get(i).getItemName(),
					dsdItems.get(i).getReceivedQty(), dsdItems.get(i).getReceivedQty(), dsdItems.get(i).getCategory(),
					dsdItems.get(i).getColor(), dsdItems.get(i).getSize(), dsdItems.get(i).getImageData(),
					dsdItems.get(i).getUpc(), dsdItems.get(i).getSku()));
		}

		DsdCombinedDto dsdCombinedDto = new DsdCombinedDto(id, dsd.getAttachedImage(), dsd.getSupplierName(),
				dsd.getTotalSKU(), dsd.getStatus(), dsd.getInvoiceNumber(), itemsDto);
		return dsdCombinedDto;
	}

	@Override
	public List<DSDLandingDto> sortDsdByLatest() {

		List<DSD> dsdList = dsdRepo.findAllByOrderByCreationDateAsc();

		if (dsdList.size() == 0) {
			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data was created ");
		}
		List<DSDLandingDto> dsdDto = new ArrayList<>();
		for (int i = 0; i < dsdList.size(); i++) {

			dsdDto.add(new DSDLandingDto(dsdList.get(i).getDsdNumber(), dsdList.get(i).getCreationDate(),
					dsdList.get(i).getStatus(), dsdList.get(i).getTotalSKU(), dsdList.get(i).getSupplierName(), "DSD"));
		}
		return dsdDto;
	}

	@Override
	public List<DSDLandingDto> sortDsdByOldest() {

		List<DSD> dsdList = dsdRepo.findAllByOrderByCreationDateAsc();

		if (dsdList.size() == 0) {
			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data was created ");
		}
		List<DSDLandingDto> dsdDto = new ArrayList<>();
		for (int i = 0; i < dsdList.size(); i++) {

			dsdDto.add(new DSDLandingDto(dsdList.get(i).getDsdNumber(), dsdList.get(i).getCreationDate(),
					dsdList.get(i).getStatus(), dsdList.get(i).getTotalSKU(), dsdList.get(i).getSupplierName(), "DSD"));
		}
		return dsdDto;
	}

	@Override
	public List<DSDLandingDto> filtersBySupplier(String name) {

		List<DSD> dsd = dsdRepo.findAllBySupplierName(name);

		if (dsd.size() == 0) {
			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data");
		}

		List<DSDLandingDto> invDto = new ArrayList<>();
		for (int i = 0; i < dsd.size(); i++) {

			invDto.add(new DSDLandingDto(dsd.get(i).getDsdNumber(), dsd.get(i).getCreationDate(),
					dsd.get(i).getStatus(), dsd.get(i).getTotalSKU(), dsd.get(i).getSupplierName(), "DSD"));
		}
		return invDto;
	}

	@Override
	public List<DSDLandingDto> getMatchedDSD(String dsdNumber) {

		List<DSD> dsd = dsdRepo.findByDsdNumberContaining(dsdNumber);

		if (dsd.size() == 0) {
			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data");
		}

		List<DSDLandingDto> invDto = new ArrayList<>();
		for (int i = 0; i < dsd.size(); i++) {

			invDto.add(new DSDLandingDto(dsd.get(i).getDsdNumber(), dsd.get(i).getCreationDate(),
					dsd.get(i).getStatus(), dsd.get(i).getTotalSKU(), dsd.get(i).getSupplierName(), "DSD"));
		}
		return invDto;
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
		sb.append("PO-");
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
					suppliersProducts.get(i).getUpc(), suppliersProducts.get(i).getSku(), suppplier);

			suppliersProductsRepo.save(suppliersProduct);
		}

		return "Products Added Successfully";
	}

	@Override
	public List<String> getMatchedSuppliers(String name) {

		List<Suppliers> suppliers = DsdSuppliersRepo.findBySupplierNameContaining(name);
		List<String> supplierNames = new ArrayList<>();
		for (int i = 0; i < suppliers.size(); i++) {
			supplierNames.add(suppliers.get(i).getSupplierName());
		}
		return supplierNames;
	}

	@Override
	public SuppliersProducts getItemsToAdd(String supplierName, String sku) {

		Suppliers supplier = DsdSuppliersRepo.findBysupplierName(supplierName);
		SuppliersProducts suppliersProduct=suppliersProductsRepo.findBySuppliersAndSku(supplier, sku);
		return suppliersProduct;
	}

}
