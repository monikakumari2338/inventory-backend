package com.inventory.myserviceimpl;

import java.security.SecureRandom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.inventory.mydto.InventoryAdjustmentCombinedDto;
import com.inventory.mydto.InventoryAdjustmentdto;
import com.inventory.myentity.InventoryAdjustment;
import com.inventory.myentity.InventoryAdjustmentProducts;
import com.inventory.myentity.ProductDetails;
import com.inventory.myentity.ReasonCodes;
import com.inventory.myentity.Stores;
import com.inventory.myexception.ExceptionHandling;
import com.inventory.myrepository.InventoryAdjustmentProductsRepo;
import com.inventory.myrepository.InventoryAdjustmentRepo;
import com.inventory.myrepository.ProductDetailsRepo;
import com.inventory.myrepository.ReasonCodesRepo;
import com.inventory.myrepository.StoreRepo;
import com.inventory.myservice.InventoryAdjustmentService;

@Service
public class InventoryAdjustmentServiceImpl implements InventoryAdjustmentService {

	@Autowired
	private InventoryAdjustmentRepo invAdjRepo;

	@Autowired
	private InventoryAdjustmentProductsRepo invAdjProductsRepo;

	@Autowired
	private ProductDetailsRepo productDetailsRepo;

	@Autowired
	private StoreRepo storeRepo;

	@Autowired
	private ReasonCodesRepo reasonCodesRepo;

	@Override
	public String saveInventoryAdjustmentProducts(InventoryAdjustmentCombinedDto InvAdjCombinedDto) {

		InventoryAdjustment inventoryAdjustment = invAdjRepo.findByAdjId(InvAdjCombinedDto.getId());
		inventoryAdjustment.setReason(InvAdjCombinedDto.getReason());
		inventoryAdjustment.setImageData(InvAdjCombinedDto.getImageData());
		inventoryAdjustment.setTotalSku(InvAdjCombinedDto.getTotalSku());
		inventoryAdjustment = invAdjRepo.save(inventoryAdjustment);

		InventoryAdjustmentProducts inventoryAdjustmentProduct = new InventoryAdjustmentProducts();
		for (int i = 0; i < InvAdjCombinedDto.getItems().size(); i++) {

			inventoryAdjustmentProduct = new InventoryAdjustmentProducts(
					InvAdjCombinedDto.getItems().get(i).getItemNumber(),
					InvAdjCombinedDto.getItems().get(i).getItemName(),
					InvAdjCombinedDto.getItems().get(i).getCategory(), InvAdjCombinedDto.getItems().get(i).getSku(),
					InvAdjCombinedDto.getItems().get(i).getUpc(), InvAdjCombinedDto.getItems().get(i).getQty(),
					InvAdjCombinedDto.getItems().get(i).getImage(), inventoryAdjustment);

			inventoryAdjustmentProduct = invAdjProductsRepo.save(inventoryAdjustmentProduct);

			String sku = InvAdjCombinedDto.getItems().get(i).getSku();
			Stores store = storeRepo.findByStoreName(inventoryAdjustment.getStore());
			ProductDetails product = productDetailsRepo.findBySkuAndStore(sku, store);

			if (product == null) {
				throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Incorrect sku found ");
			} else if (product.getSku().equals(sku)) {

				if (InvAdjCombinedDto.getReason().equals("Damage")) {
					int totalStock = product.getTotalStock();
					int newStock = totalStock + InvAdjCombinedDto.getItems().get(i).getQty();
					int nonSellable = product.getNonSellableStock();
					int newNonSellable = nonSellable + InvAdjCombinedDto.getItems().get(i).getQty();
					product.setTotalStock(newStock);
					product.setNonSellableStock(newNonSellable);
					System.out.println("damage");
					productDetailsRepo.save(product);
				}

				else if (InvAdjCombinedDto.getReason().equals("Stock In")) {
					int totalStock = product.getTotalStock();
					int newStock = totalStock + InvAdjCombinedDto.getItems().get(i).getQty();
					int sellable = product.getSellableStock();
					int newSellable = sellable + InvAdjCombinedDto.getItems().get(i).getQty();
					product.setTotalStock(newStock);
					product.setSellableStock(newSellable);
					productDetailsRepo.save(product);
					System.out.println("stock in");
				}

				else {
					int totalStock = product.getTotalStock();
					int newStock = totalStock - InvAdjCombinedDto.getItems().get(i).getQty();
					int sellable = product.getSellableStock();
					int newSellable = sellable - InvAdjCombinedDto.getItems().get(i).getQty();
					product.setTotalStock(newStock);
					product.setSellableStock(newSellable);
					productDetailsRepo.save(product);
					System.out.println("theft");
				}
			}

		}
		inventoryAdjustment.setStatus(InvAdjCombinedDto.getStatus());
		// System.out.println("inventoryAdjustmentProduct : - " +
		// inventoryAdjustmentProduct);

		return "Products saved successfully";
	}

	@Override
	public InventoryAdjustmentdto createInventoryAdjustment(String storeName, String user) {

		Stores store = storeRepo.findByStoreName(storeName);
		if (store != null) {
			String iAId = generateIAIdString();
			LocalDate date = LocalDate.now();
			InventoryAdjustment inventoryAdjustment = new InventoryAdjustment();
			inventoryAdjustment.setAdjId(iAId);
			inventoryAdjustment.setDate(date);
			inventoryAdjustment.setStatus("In Progress");
			inventoryAdjustment.setStore(storeName);
			inventoryAdjustment.setUser(user);
			inventoryAdjustment = invAdjRepo.save(inventoryAdjustment);

			InventoryAdjustmentdto adjDto = new InventoryAdjustmentdto(inventoryAdjustment.getAdjId(),
					inventoryAdjustment.getDate(), inventoryAdjustment.getStore(), inventoryAdjustment.getUser(),
					inventoryAdjustment.getStatus(), "IA");
			return adjDto;
		} else {
			throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Please add the appropriate store ");
		}

	}

	@Override
	public List<String> getAllReasonCodes() {
		List<ReasonCodes> reasonCodes = reasonCodesRepo.findAll();
		List<String> reasonCodesList = new ArrayList<>();
		for (int i = 0; i < reasonCodes.size(); i++) {
			reasonCodesList.add(reasonCodes.get(i).getReason());
		}
		System.out.println("reasonCodes" + reasonCodes);
		return reasonCodesList;
	}

//	@Override
//	public List<InventoryAdjustment> getInventoryAdjustment(LocalDate date) {
//
//		List<InventoryAdjustment> inventory_list = new ArrayList<>();
//		inventory_list = invAdjRepo.findByDate(date);
//		System.out.println("inventory_list " + inventory_list);
//		if (inventory_list.size() == 0) {
//			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data was created on " + date);
//		}
//		return inventory_list;
//	}

	@Override
	public List<InventoryAdjustment> getAllInventoryAdjustment() {

		List<InventoryAdjustment> inventory_list = new ArrayList<>();
		inventory_list = invAdjRepo.findAll();
		System.out.println("inventory_list " + inventory_list);
		if (inventory_list.size() == 0) {
			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data");
		}
		return inventory_list;
	}

	@Override
	public List<InventoryAdjustmentProducts> getInventoryAdjustmentProductsByID(String id) {

		List<InventoryAdjustmentProducts> inventoryProducts_list = new ArrayList<>();
		InventoryAdjustment inventoryAdjustment = invAdjRepo.findByAdjId(id);
		// System.out.println("inventoryAdjustment " + inventoryAdjustment);
		inventoryProducts_list = invAdjProductsRepo.findByInvAdjustment(inventoryAdjustment);
		// System.out.println("inventory_list " + inventoryProducts_list);
		if (inventoryProducts_list.size() == 0) {
			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data");
		}
		return inventoryProducts_list;
	}

	public String generateIAIdString() {
		final String CHARACTERS = "0123456789";
		final SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(10);
		sb.append("IA");
		for (int i = 0; i < 12; i++) {
			sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

		}
		return sb.toString();
	}
//
//	@Override
//	public List<InventoryAdjustment> getMatchedInvAdjByid(String id) {
//		List<InventoryAdjustment> inventoryAdjustment = invAdjRepo.findByAdjIdContaining(id);
//		return inventoryAdjustment;
//	}
}
