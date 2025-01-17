package com.inventory.rtv.service;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.inventory.adjustments.jpa.dto.InventoryAdjustmentProductsdto;
import com.inventory.dsd.jpa.dto.DSDLandingDto;
import com.inventory.dsd.jpa.entity.Suppliers;
import com.inventory.exception.ExceptionHandling;
import com.inventory.myrepository.ProductDetailsRepo;
import com.inventory.myrepository.ReturnTovendorInfoRepo;
import com.inventory.myrepository.ReturnTovendorProductsRepo;
import com.inventory.myrepository.RtvReasonCodesRepo;
import com.inventory.myrepository.StoreRepo;
import com.inventory.myrepository.SuppliersRepo;
import com.inventory.product.jpa.entity.ProductDetails;
import com.inventory.rtv.jpa.dto.RtvCombinedDto;
import com.inventory.rtv.jpa.dto.RtvGetItemsDto;
import com.inventory.rtv.jpa.dto.RtvInfoDto;
import com.inventory.rtv.jpa.entity.RTVInfo;
import com.inventory.rtv.jpa.entity.RTVProducts;
import com.inventory.rtv.jpa.entity.RtvReasonCodes;
import com.inventory.store.jpa.entity.Stores;

import jakarta.transaction.Transactional;

import java.security.SecureRandom;
import java.time.LocalDate;

@Service
public class ReturnToVendorServiceImpl implements ReturnToVendorService {

	@Autowired
	private ReturnTovendorInfoRepo rtvInfoRepo;

	@Autowired
	private ReturnTovendorProductsRepo rtvProductsRepo;

	@Autowired
	private RtvReasonCodesRepo rtvReasonCodesRepo;

	@Autowired
	private SuppliersRepo suppliersRepo;

	@Autowired
	private StoreRepo storeRepo;

	@Autowired
	private ProductDetailsRepo productDetailsRepo;

	@Override
	public RtvInfoDto createRTV(String storeName, String user) {

		Stores store = storeRepo.findByStoreName(storeName);
		if (store != null) {
			String rtvId = generateRtvIdString();
			LocalDate date = LocalDate.now();
			RTVInfo rtvInfo = new RTVInfo();

			rtvInfo.setRtvID(rtvId);
			rtvInfo.setStoreId(store.getStoreId());
			rtvInfo.setCreatedBy(user);
			rtvInfo.setCreationDate(date);
			rtvInfo.setStatus("In Progress");
			rtvInfo = rtvInfoRepo.save(rtvInfo);

			RtvInfoDto rtvInfoDto = new RtvInfoDto(rtvInfo.getRtvID(), rtvInfo.getCreationDate(), storeName,
					rtvInfo.getCreatedBy(), "RTV", rtvInfo.getStatus());
			return rtvInfoDto;
		} else {
			throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Please add the appropriate store ");
		}

	}

	@Transactional
	@Override
	public String saveRtvProducts(RtvCombinedDto rtvCombinedDto) {

		RTVInfo rtv = rtvInfoRepo.findByrtvID(rtvCombinedDto.getId());
		Suppliers supplier = suppliersRepo.findBySupplierId(rtvCombinedDto.getSupplierId());
		LocalDate date = LocalDate.now();
		Stores store = storeRepo.findByStoreId(rtv.getStoreId());

		rtv.setSupplierId(rtvCombinedDto.getSupplierId());
		rtv.setSupplierName(supplier.getSupplierName());
		rtv.setTotalSku(rtvCombinedDto.getItems().size());
		rtv.setStatus("Dispatched");
		rtv.setDefaultReasonCode(rtvCombinedDto.getReason());
		rtv.setDispatchedUser(rtvCombinedDto.getDispatchedUser());
		rtv.setDispatchedDate(date);
		rtv.setProof(rtvCombinedDto.getImage());

		rtv = rtvInfoRepo.save(rtv);

		RTVProducts rtvProducts = new RTVProducts();
		int totalItems = 0;

		rtvProductsRepo.deleteAllByRtvInfo(rtv);
		for (int i = 0; i < rtvCombinedDto.getItems().size(); i++) {

			rtvProducts = new RTVProducts(rtvCombinedDto.getItems().get(i).getImage(),
					rtvCombinedDto.getItems().get(i).getQty(), rtvCombinedDto.getItems().get(i).getUpc(),
					rtvCombinedDto.getItems().get(i).getSku(), rtv);

			rtvProductsRepo.save(rtvProducts);

			totalItems = totalItems + rtvCombinedDto.getItems().get(i).getQty();
			ProductDetails product = productDetailsRepo.findBySkuAndStore(rtvCombinedDto.getItems().get(i).getSku(),
					store);

			if (product == null) {
				throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Incorrect sku found ");

			} else if (product.getSku().equals(rtvCombinedDto.getItems().get(i).getSku())) {

				int totalStock = product.getTotalStock();
				int newStock = totalStock - rtvCombinedDto.getItems().get(i).getQty();
				int nonSellable = product.getNonSellableStock();
				if (nonSellable >= rtvCombinedDto.getItems().get(i).getQty()) {
					int newNonSellable = nonSellable - rtvCombinedDto.getItems().get(i).getQty();

					product.setNonSellableStock(newNonSellable);
					product.setTotalStock(newStock);
					productDetailsRepo.save(product);
				} else {
					throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "Return quantity can't exceed system quantity");
				}

			}
		}
		rtv.setTotalItems(totalItems);
		rtv = rtvInfoRepo.save(rtv);
		return "Products saved successfully";

	}

	// Function to get all RTV

	@Override
	public List<DSDLandingDto> getAllVendorReturn() {

		List<RTVInfo> rtvInfo = rtvInfoRepo.findAll();

		List<DSDLandingDto> dsdDto = new ArrayList<>();
		for (int i = 0; i < rtvInfo.size(); i++) {

			dsdDto.add(new DSDLandingDto(rtvInfo.get(i).getRtvID(), rtvInfo.get(i).getCreationDate(),
					rtvInfo.get(i).getStatus(), rtvInfo.get(i).getTotalSku(), rtvInfo.get(i).getSupplierId(), "RTV"));
		}
		return dsdDto;
	}

	@Override
	public List<DSDLandingDto> sortRtvByLatest() {

		List<RTVInfo> rtvList = rtvInfoRepo.findAllByOrderByCreationDateDesc();

		List<DSDLandingDto> dsdDto = new ArrayList<>();
		for (int i = 0; i < rtvList.size(); i++) {

			dsdDto.add(new DSDLandingDto(rtvList.get(i).getRtvID(), rtvList.get(i).getCreationDate(),
					rtvList.get(i).getStatus(), rtvList.get(i).getTotalSku(), rtvList.get(i).getSupplierId(), "RTV"));
		}
		return dsdDto;
	}

	@Override
	public List<DSDLandingDto> sortRtvByOldest() {

		List<RTVInfo> rtvList = rtvInfoRepo.findAllByOrderByCreationDateAsc();

		List<DSDLandingDto> dsdDto = new ArrayList<>();
		for (int i = 0; i < rtvList.size(); i++) {

			dsdDto.add(new DSDLandingDto(rtvList.get(i).getRtvID(), rtvList.get(i).getCreationDate(),
					rtvList.get(i).getStatus(), rtvList.get(i).getTotalSku(), rtvList.get(i).getSupplierId(), "RTV"));
		}
		return dsdDto;
	}

	@Override
	public List<DSDLandingDto> getMatchedRtvByid(String id) {
		List<RTVInfo> rtvList = rtvInfoRepo.findByRtvIDContaining(id);

		List<DSDLandingDto> dsdDto = new ArrayList<>();
		for (int i = 0; i < rtvList.size(); i++) {

			dsdDto.add(new DSDLandingDto(rtvList.get(i).getRtvID(), rtvList.get(i).getCreationDate(),
					rtvList.get(i).getStatus(), rtvList.get(i).getTotalSku(), rtvList.get(i).getSupplierId(), "RTV"));
		}
		return dsdDto;
	}

	@Override
	public List<DSDLandingDto> filtersByReasonOrStatus(String param) {

		List<RTVInfo> rtvList = rtvInfoRepo.findByDefaultReasonCodeOrStatus(param, param);

		List<DSDLandingDto> dsdDto = new ArrayList<>();
		for (int i = 0; i < rtvList.size(); i++) {

			dsdDto.add(new DSDLandingDto(rtvList.get(i).getRtvID(), rtvList.get(i).getCreationDate(),
					rtvList.get(i).getStatus(), rtvList.get(i).getTotalSku(), rtvList.get(i).getSupplierId(), "RTV"));
		}
		return dsdDto;
	}

	// Function to get RTV Products by Id
	@Override
	public RtvGetItemsDto getRTVProductsbyId(String rtvId, String storeName) {

		Stores store = storeRepo.findByStoreName(storeName);
		RTVInfo rtv = rtvInfoRepo.findByrtvID(rtvId);
		List<RTVProducts> rtvProducts = rtvProductsRepo.findByrtvInfo(rtv);
		List<InventoryAdjustmentProductsdto> itemsDto = new ArrayList<>();

		for (int i = 0; i < rtvProducts.size(); i++) {

			ProductDetails product = productDetailsRepo.findBySkuAndStore(rtvProducts.get(i).getSku(), store);

			itemsDto.add(new InventoryAdjustmentProductsdto(product.getProduct().getItemNumber(),
					product.getProduct().getitemName(), product.getProduct().getCategory().getCategory(),
					product.getColor(), product.getSize(), rtvProducts.get(i).getSku(), rtvProducts.get(i).getUpc(),
					rtvProducts.get(i).getReturnQty(), rtvProducts.get(i).getAttachedImage(), product.getImageData(),
					"RTV"));
		}

		RtvGetItemsDto rtvDto = new RtvGetItemsDto(rtvId, rtv.getProof(), rtv.getTotalSku(), rtv.getDefaultReasonCode(),
				rtv.getSupplierId(), rtv.getStatus(), itemsDto);
		return rtvDto;
	}

	@Override
	public String draftRTV(RtvCombinedDto rtvCombinedDto) {

		int qty = 0;
		RTVInfo rtv = rtvInfoRepo.findByrtvID(rtvCombinedDto.getId());
		Suppliers supplier = suppliersRepo.findBySupplierId(rtvCombinedDto.getSupplierId());

		rtv.setSupplierId(rtvCombinedDto.getSupplierId());
		rtv.setSupplierName(supplier.getSupplierName());
		rtv.setTotalSku(rtvCombinedDto.getItems().size());
		rtv.setDefaultReasonCode(rtvCombinedDto.getReason());
		rtv.setProof(rtvCombinedDto.getImage());

		rtv = rtvInfoRepo.save(rtv);

		rtvProductsRepo.deleteAllByRtvInfo(rtv);
		for (int i = 0; i < rtvCombinedDto.getItems().size(); i++) {
			RTVProducts rtvProducts = new RTVProducts(rtvCombinedDto.getItems().get(i).getImage(),
					rtvCombinedDto.getItems().get(i).getQty(), rtvCombinedDto.getItems().get(i).getUpc(),
					rtvCombinedDto.getItems().get(i).getSku(), rtv);

			qty = (qty + rtvCombinedDto.getItems().get(i).getQty());
			rtvProductsRepo.save(rtvProducts);

		}
		rtv.setStatus("Saved");
		rtv.setTotalItems(qty);
		rtv.setTotalSku(rtvCombinedDto.getItems().size());
		rtvInfoRepo.save(rtv);

		return "Draft Saved Successfully";

	}

	@Override
	public List<String> getRtvReasonCodes() {
		List<RtvReasonCodes> reasonCodes = rtvReasonCodesRepo.findAll();
		List<String> reasonCodesList = new ArrayList<>();
		for (int i = 0; i < reasonCodes.size(); i++) {
			reasonCodesList.add(reasonCodes.get(i).getReasonCode());
		}
		return reasonCodesList;
	}

	@Override
	public String deleteRTVbyId(String id) {
		RTVInfo rtv = rtvInfoRepo.findByRtvID(id);
		if (rtv.getStatus().equals("In Progress") || rtv.getStatus().equals("Saved")) {
			rtvInfoRepo.deleteByRtvID(id);
			return "Deleted Successfully";
		} else {
			return "Incorrect Id";
		}

	}

	public String generateRtvIdString() {
		final String CHARACTERS = "0123456789";
		final SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(10);
		sb.append("RTV");
		for (int i = 0; i < 12; i++) {
			sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

		}
		return sb.toString();
	}
}
