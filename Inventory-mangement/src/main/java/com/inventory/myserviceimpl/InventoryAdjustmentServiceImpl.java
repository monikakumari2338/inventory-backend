package com.inventory.myserviceimpl;

import java.security.SecureRandom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.inventory.mydto.InventoryAdjustmentCombinedDto;
import com.inventory.mydto.InventoryAdjustmentLandingDto;
import com.inventory.mydto.InventoryAdjustmentProductsdto;
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

import jakarta.transaction.Transactional;

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

		List<InventoryAdjustmentProducts> adj = invAdjProductsRepo.findByInvAdjustment(inventoryAdjustment);
		if (adj.isEmpty()) {

			InventoryAdjustmentProducts inventoryAdjustmentProduct = new InventoryAdjustmentProducts();
			for (int i = 0; i < InvAdjCombinedDto.getItems().size(); i++) {

				inventoryAdjustmentProduct = new InventoryAdjustmentProducts(
						InvAdjCombinedDto.getItems().get(i).getItemNumber(),
						InvAdjCombinedDto.getItems().get(i).getItemName(),
						InvAdjCombinedDto.getItems().get(i).getCategory(),
						InvAdjCombinedDto.getItems().get(i).getColor(), InvAdjCombinedDto.getItems().get(i).getSize(),
						InvAdjCombinedDto.getItems().get(i).getSku(), InvAdjCombinedDto.getItems().get(i).getUpc(),
						InvAdjCombinedDto.getItems().get(i).getQty(), InvAdjCombinedDto.getItems().get(i).getImage(),
						inventoryAdjustment);

				inventoryAdjustmentProduct = invAdjProductsRepo.save(inventoryAdjustmentProduct);

			}
		}

		else {

			invAdjProductsRepo.deleteAllByInvAdjustment(inventoryAdjustment);
			InventoryAdjustmentProducts inventoryAdjustmentProduct = new InventoryAdjustmentProducts();
			for (int i = 0; i < InvAdjCombinedDto.getItems().size(); i++) {

				inventoryAdjustmentProduct = new InventoryAdjustmentProducts(
						InvAdjCombinedDto.getItems().get(i).getItemNumber(),
						InvAdjCombinedDto.getItems().get(i).getItemName(),
						InvAdjCombinedDto.getItems().get(i).getCategory(),
						InvAdjCombinedDto.getItems().get(i).getColor(), InvAdjCombinedDto.getItems().get(i).getSize(),
						InvAdjCombinedDto.getItems().get(i).getSku(), InvAdjCombinedDto.getItems().get(i).getUpc(),
						InvAdjCombinedDto.getItems().get(i).getQty(), InvAdjCombinedDto.getItems().get(i).getImage(),
						inventoryAdjustment);

				inventoryAdjustmentProduct = invAdjProductsRepo.save(inventoryAdjustmentProduct);

			}

		}

		for (int i = 0; i < InvAdjCombinedDto.getItems().size(); i++) {

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
					// System.out.println("damage");
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
					// System.out.println("stock in");
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
		inventoryAdjustment = invAdjRepo.save(inventoryAdjustment);
		// System.out.println("inventoryAdjustmentProduct : - " +
		// inventoryAdjustmentProduct);

		return "Products saved successfully";

	}

	@Override
	public String IaSaveAsDraft(InventoryAdjustmentCombinedDto InvAdjCombinedDto) {

		InventoryAdjustment inventoryAdjustment = invAdjRepo.findByAdjId(InvAdjCombinedDto.getId());
		inventoryAdjustment.setReason(InvAdjCombinedDto.getReason());
		inventoryAdjustment.setImageData(InvAdjCombinedDto.getImageData());
		inventoryAdjustment.setTotalSku(InvAdjCombinedDto.getTotalSku());

		InventoryAdjustmentProducts inventoryAdjustmentProduct = new InventoryAdjustmentProducts();
		for (int i = 0; i < InvAdjCombinedDto.getItems().size(); i++) {

			inventoryAdjustmentProduct = new InventoryAdjustmentProducts(
					InvAdjCombinedDto.getItems().get(i).getItemNumber(),
					InvAdjCombinedDto.getItems().get(i).getItemName(),
					InvAdjCombinedDto.getItems().get(i).getCategory(), InvAdjCombinedDto.getItems().get(i).getColor(),
					InvAdjCombinedDto.getItems().get(i).getSize(), InvAdjCombinedDto.getItems().get(i).getSku(),
					InvAdjCombinedDto.getItems().get(i).getUpc(), InvAdjCombinedDto.getItems().get(i).getQty(),
					InvAdjCombinedDto.getItems().get(i).getImage(), inventoryAdjustment);

			inventoryAdjustmentProduct = invAdjProductsRepo.save(inventoryAdjustmentProduct);

		}
		inventoryAdjustment.setStatus(InvAdjCombinedDto.getStatus());
		inventoryAdjustment = invAdjRepo.save(inventoryAdjustment);

		return "Save as Draft saved successfully";
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
//		System.out.println("reasonCodes" + reasonCodes);
		return reasonCodesList;
	}

	@Override
	public List<InventoryAdjustmentLandingDto> sortInventoryAdjustmentByLatest() {

		List<InventoryAdjustment> inventory_list = new ArrayList<>();
		inventory_list = invAdjRepo.findAllByOrderByDateDesc();
//		if (inventory_list.size() == 0) {
//			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data was created ");
//		}
		List<InventoryAdjustmentLandingDto> invDto = new ArrayList<>();
		for (int i = 0; i < inventory_list.size(); i++) {

			invDto.add(new InventoryAdjustmentLandingDto(inventory_list.get(i).getAdjId(),
					inventory_list.get(i).getDate(), inventory_list.get(i).getStatus(),
					inventory_list.get(i).getTotalSku(), inventory_list.get(i).getReason(), "IA"));
		}
		return invDto;
	}

	@Override
	public List<InventoryAdjustmentLandingDto> sortInventoryAdjustmentByOldest() {

		List<InventoryAdjustment> inventory_list = new ArrayList<>();
		inventory_list = invAdjRepo.findAllByOrderByDateAsc();
		// System.out.println("inventory_list " + inventory_list);
//		if (inventory_list.size() == 0) {
//			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data was created ");
//		}
		List<InventoryAdjustmentLandingDto> invDto = new ArrayList<>();
		for (int i = 0; i < inventory_list.size(); i++) {

			invDto.add(new InventoryAdjustmentLandingDto(inventory_list.get(i).getAdjId(),
					inventory_list.get(i).getDate(), inventory_list.get(i).getStatus(),
					inventory_list.get(i).getTotalSku(), inventory_list.get(i).getReason(), "IA"));
		}
		return invDto;
	}

	@Override
	public List<InventoryAdjustmentLandingDto> getAllInventoryAdjustment() {

		List<InventoryAdjustment> inventory_list = new ArrayList<>();
		inventory_list = invAdjRepo.findAll();
		// System.out.println("inventory_list " + inventory_list);
//		if (inventory_list.size() == 0) {
//			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data");
//		}

		List<InventoryAdjustmentLandingDto> invDto = new ArrayList<>();
		for (int i = 0; i < inventory_list.size(); i++) {

			invDto.add(new InventoryAdjustmentLandingDto(inventory_list.get(i).getAdjId(),
					inventory_list.get(i).getDate(), inventory_list.get(i).getStatus(),
					inventory_list.get(i).getTotalSku(), inventory_list.get(i).getReason(), "IA"));
		}
		return invDto;
	}

	@Override
	public List<InventoryAdjustmentLandingDto> filtersByReasonOrStatus(String param) {

		List<InventoryAdjustment> inventory_list = new ArrayList<>();
		inventory_list = invAdjRepo.findByReasonOrStatus(param, param);
		// System.out.println("inventory_list " + inventory_list);
//		if (inventory_list.size() == 0) {
//			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data");
//		}

		List<InventoryAdjustmentLandingDto> invDto = new ArrayList<>();
		for (int i = 0; i < inventory_list.size(); i++) {

			invDto.add(new InventoryAdjustmentLandingDto(inventory_list.get(i).getAdjId(),
					inventory_list.get(i).getDate(), inventory_list.get(i).getStatus(),
					inventory_list.get(i).getTotalSku(), inventory_list.get(i).getReason(), "IA"));
		}
		return invDto;
	}

	@Override
	public InventoryAdjustmentCombinedDto getInventoryAdjustmentProductsByID(String id) {
		InventoryAdjustment inventoryAdjustment = invAdjRepo.findByAdjId(id);

		List<InventoryAdjustmentProducts> inventoryProducts_list = invAdjProductsRepo
				.findByInvAdjustment(inventoryAdjustment);

		List<InventoryAdjustmentProductsdto> itemsDto = new ArrayList<>();

//		if (inventoryProducts_list.size() == 0) {
//			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data");
//		}

		for (int i = 0; i < inventoryProducts_list.size(); i++) {
			itemsDto.add(new InventoryAdjustmentProductsdto(inventoryProducts_list.get(i).getItemNumber(),
					inventoryProducts_list.get(i).getItemName(), inventoryProducts_list.get(i).getCategory(),
					inventoryProducts_list.get(i).getColor(), inventoryProducts_list.get(i).getSize(),
					inventoryProducts_list.get(i).getSku(), inventoryProducts_list.get(i).getUpc(),
					inventoryProducts_list.get(i).getAdjQty(), inventoryProducts_list.get(i).getProof()));
		}

		InventoryAdjustmentCombinedDto invCombinedDto = new InventoryAdjustmentCombinedDto(id,
				inventoryAdjustment.getImageData(), inventoryAdjustment.getTotalSku(), inventoryAdjustment.getReason(),
				inventoryAdjustment.getStatus(), itemsDto);
		return invCombinedDto;
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

	@Override
	public List<InventoryAdjustmentLandingDto> getMatchedInvAdjByid(String id) {
		List<InventoryAdjustment> inventory_list = invAdjRepo.findByAdjIdContaining(id);
//		if (inventory_list.size() == 0) {
//			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "No data found with the Id");
//		}

		List<InventoryAdjustmentLandingDto> invDto = new ArrayList<>();
		for (int i = 0; i < inventory_list.size(); i++) {

			invDto.add(new InventoryAdjustmentLandingDto(inventory_list.get(i).getAdjId(),
					inventory_list.get(i).getDate(), inventory_list.get(i).getStatus(),
					inventory_list.get(i).getTotalSku(), inventory_list.get(i).getReason(), "IA"));
		}
		return invDto;
	}

	@Override
	public List<InventoryAdjustmentProductsdto> getSearchedItemInAdjustment(String id, String sku) {
		InventoryAdjustment adjustment = invAdjRepo.findByAdjId(id);

		List<InventoryAdjustmentProducts> inventoryProducts_list = invAdjProductsRepo
				.findByInvAdjustmentAndSkuContaining(adjustment, sku);

		List<InventoryAdjustmentProductsdto> invProductsdto = new ArrayList<>();

		for (int i = 0; i < inventoryProducts_list.size(); i++) {

			invProductsdto.add(new InventoryAdjustmentProductsdto(inventoryProducts_list.get(i).getItemNumber(),
					inventoryProducts_list.get(i).getItemName(), inventoryProducts_list.get(i).getCategory(),
					inventoryProducts_list.get(i).getColor(), inventoryProducts_list.get(i).getSize(),
					inventoryProducts_list.get(i).getSku(), inventoryProducts_list.get(i).getUpc(),
					inventoryProducts_list.get(i).getAdjQty(), inventoryProducts_list.get(i).getProof()));
		}
		return invProductsdto;
	}

	@Override
	public List<InventoryAdjustmentProductsdto> getSearchedItemInAdjustmentByName(String id, String name) {
		InventoryAdjustment adjustment = invAdjRepo.findByAdjId(id);

		List<InventoryAdjustmentProducts> inventoryProducts_list = invAdjProductsRepo
				.findByInvAdjustmentAndItemNameContaining(adjustment, name);

		List<InventoryAdjustmentProductsdto> invProductsdto = new ArrayList<>();

		for (int i = 0; i < inventoryProducts_list.size(); i++) {

			invProductsdto.add(new InventoryAdjustmentProductsdto(inventoryProducts_list.get(i).getItemNumber(),
					inventoryProducts_list.get(i).getItemName(), inventoryProducts_list.get(i).getCategory(),
					inventoryProducts_list.get(i).getColor(), inventoryProducts_list.get(i).getSize(),
					inventoryProducts_list.get(i).getSku(), inventoryProducts_list.get(i).getUpc(),
					inventoryProducts_list.get(i).getAdjQty(), inventoryProducts_list.get(i).getProof()));
		}
		return invProductsdto;
	}

	@Override
	public String deleteByIaId(String id) {
		InventoryAdjustment adjustment = invAdjRepo.findByAdjId(id);
		if (adjustment.getStatus().equals("In Progress") || adjustment.getStatus().equals("Saved")) {
			invAdjRepo.deleteByAdjId(id);
			return "Deleted Successfully";
		} else {
			return "Incorrect Id";
		}

	}

	// Scheduler to delete all orphan adjustments
	@Scheduled(cron = "0 01 16 * * ?") // This cron expression means the task will run at 10:30 PM every day
	@Transactional
	public void cleanUpOrphanedTableAEntries() {
		List<InventoryAdjustment> orphanedEntries = invAdjRepo.findAllWithoutInvProducts();
		invAdjRepo.deleteAll(orphanedEntries);
	}
}
