package com.inventory.purchaseorder.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.inventory.purchaseorder.dto.InventoryAdjustmentCombinedDto;
import com.inventory.purchaseorder.entity.InventoryAdjustment;
import com.inventory.purchaseorder.entity.InventoryAdjustmentProducts;
import com.inventory.purchaseorder.entity.ProductDetails;
import com.inventory.purchaseorder.entity.ReasonCodes;
import com.inventory.purchaseorder.entity.Stores;
import com.inventory.purchaseorder.exception.ExceptionHandling;
import com.inventory.purchaseorder.repository.InventoryAdjustmentProductsRepo;
import com.inventory.purchaseorder.repository.InventoryAdjustmentRepo;
import com.inventory.purchaseorder.repository.ProductDetailsRepo;
import com.inventory.purchaseorder.repository.StoreRepo;
import com.inventory.purchaseorder.service.InventoryAdjustmentService;
import com.inventory.purchaseorder.repository.ReasonCodesRepo;

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
	public String saveInventoryAdjustment(InventoryAdjustmentCombinedDto InvAdjCombinedDto) {

		System.out.println("InvAdjCombinedDto: " + InvAdjCombinedDto);
		InventoryAdjustment inventoryAdjustment = new InventoryAdjustment(InvAdjCombinedDto.getInvCombined().getAdjId(),
				InvAdjCombinedDto.getInvCombined().getImage(), InvAdjCombinedDto.getInvCombined().getTotalSku(),
				InvAdjCombinedDto.getInvCombined().getDate());
		invAdjRepo.save(inventoryAdjustment);
		for (int i = 0; i < InvAdjCombinedDto.getProductDto().size(); i++) {

			InventoryAdjustment inventoryAdjustment1 = invAdjRepo
					.findByAdjId(InvAdjCombinedDto.getInvCombined().getAdjId());

			InventoryAdjustmentProducts inventoryAdjustmentProducts = new InventoryAdjustmentProducts(
					InvAdjCombinedDto.getProductDto().get(i).getItemNumber(),
					InvAdjCombinedDto.getProductDto().get(i).getItemName(),
					InvAdjCombinedDto.getProductDto().get(i).getCategory(),
					InvAdjCombinedDto.getProductDto().get(i).getSku(),
					InvAdjCombinedDto.getProductDto().get(i).getUpc(),
					InvAdjCombinedDto.getProductDto().get(i).getStore(),
					InvAdjCombinedDto.getProductDto().get(i).getReason(),
					InvAdjCombinedDto.getProductDto().get(i).getStatus(),
					InvAdjCombinedDto.getProductDto().get(i).getUser(),
					InvAdjCombinedDto.getProductDto().get(i).getAdjQty(),
					InvAdjCombinedDto.getProductDto().get(i).getImage(), inventoryAdjustment1);

			invAdjProductsRepo.save(inventoryAdjustmentProducts);

			String sku = InvAdjCombinedDto.getProductDto().get(i).getSku();
			Stores store = storeRepo.findByStoreName(InvAdjCombinedDto.getProductDto().get(i).getStore());
			ProductDetails product = productDetailsRepo.findBySkuAndStore(sku, store);

			if (product.getSku().equals(sku)) {

				if (InvAdjCombinedDto.getProductDto().get(i).getReason().equals("Damage")) {
					int totalStock = product.getTotalStock();
					int newStock = totalStock + InvAdjCombinedDto.getProductDto().get(i).getAdjQty();
					int nonSellable = product.getNonSellableStock();
					int newNonSellable = nonSellable + InvAdjCombinedDto.getProductDto().get(i).getAdjQty();
					product.setTotalStock(newStock);
					product.setNonSellableStock(newNonSellable);
					System.out.println("damage");
					productDetailsRepo.save(product);
				}

				else if (InvAdjCombinedDto.getProductDto().get(i).getReason().equals("Stock In")) {
					int totalStock = product.getTotalStock();
					int newStock = totalStock + InvAdjCombinedDto.getProductDto().get(i).getAdjQty();
					int sellable = product.getSellableStock();
					int newSellable = sellable + InvAdjCombinedDto.getProductDto().get(i).getAdjQty();
					product.setTotalStock(newStock);
					product.setSellableStock(newSellable);
					productDetailsRepo.save(product);
					System.out.println("stock in");
				}

				else {
					int totalStock = product.getTotalStock();
					int newStock = totalStock - InvAdjCombinedDto.getProductDto().get(i).getAdjQty();
					int sellable = product.getSellableStock();
					int newSellable = sellable - InvAdjCombinedDto.getProductDto().get(i).getAdjQty();
					product.setTotalStock(newStock);
					product.setSellableStock(newSellable);
					productDetailsRepo.save(product);
					System.out.println("theft");
				}
			}

		}

		return "Products saved successfully";
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
		//System.out.println("inventoryAdjustment " + inventoryAdjustment);
		inventoryProducts_list = invAdjProductsRepo.findByInvAdjustment(inventoryAdjustment);
		//System.out.println("inventory_list " + inventoryProducts_list);
		if (inventoryProducts_list.size() == 0) {
			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data");
		}
		return inventoryProducts_list;
	}
//
//	@Override
//	public List<InventoryAdjustment> getMatchedInvAdjByid(String id) {
//		List<InventoryAdjustment> inventoryAdjustment = invAdjRepo.findByAdjIdContaining(id);
//		return inventoryAdjustment;
//	}
}
