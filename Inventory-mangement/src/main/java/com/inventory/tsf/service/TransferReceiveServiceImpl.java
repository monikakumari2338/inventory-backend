package com.inventory.tsf.service;

import java.security.SecureRandom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.inventory.exception.ExceptionHandling;
import com.inventory.myrepository.CategoryRepo;
import com.inventory.myrepository.ProductDetailsRepo;
import com.inventory.myrepository.ProductRepo;
import com.inventory.myrepository.StoreRepo;
import com.inventory.myrepository.TsfDetailsRepo;
import com.inventory.myrepository.TsfHeadRepo;
import com.inventory.myrepository.TsfReasonCodesRepo;
import com.inventory.product.jpa.entity.ProductDetails;
import com.inventory.store.jpa.entity.Stores;
import com.inventory.tsf.jpa.dto.TSFCombinedDto;
import com.inventory.tsf.jpa.dto.TSFLandingDto;
import com.inventory.tsf.jpa.dto.TsfDetailsDto;
import com.inventory.tsf.jpa.dto.TsfDetailsGetReceivingDto;
import com.inventory.tsf.jpa.dto.TsfDetailsShipmentDto;
import com.inventory.tsf.jpa.dto.TsfDto;
import com.inventory.tsf.jpa.dto.TsfHeadDtoToGetTransfers;
import com.inventory.tsf.jpa.dto.TsfOrderAcceptanceDto;
import com.inventory.tsf.jpa.dto.TsfOrderAcceptanceStoreAndProductsDto;
import com.inventory.tsf.jpa.dto.TsfReceivingItemsAndStoreCombinedDto;
import com.inventory.tsf.jpa.dto.TsfSaveReceivingDto;
import com.inventory.tsf.jpa.dto.TsfShipmentAndStoreCombinedDto;
import com.inventory.tsf.jpa.entity.TsfDetails;
import com.inventory.tsf.jpa.entity.TsfHead;
import com.inventory.tsf.jpa.entity.TsfReasonCodes;

import jakarta.transaction.Transactional;

@Service
public class TransferReceiveServiceImpl implements TransferReceiveService {

	@Autowired
	private TsfHeadRepo tsfHeadRepo;

	@Autowired
	private StoreRepo storeRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private TsfDetailsRepo tsfDetailsRepo;

	@Autowired
	private TsfReasonCodesRepo tsfReasonCodesRepo;

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ProductDetailsRepo productDetailsRepo;

	// function to get All TSF Reason Codes
	@Override
	public List<String> getTsfReasonCodes() {
		List<TsfReasonCodes> reasonCodes = tsfReasonCodesRepo.findAll();
		List<String> reasonCodesList = new ArrayList<>();
		for (int i = 0; i < reasonCodes.size(); i++) {
			reasonCodesList.add(reasonCodes.get(i).getReasonCode());
		}
		return reasonCodesList;
	}

	// Function to create Transfer
	@Override
	public TsfDto createTransfer(String storeFrom, String user, String storeTo) {

		Stores storeFromExist = storeRepo.findByStoreName(storeFrom);
		Stores storeToExist = storeRepo.findByStoreName(storeTo);
		if (storeFromExist != null && storeToExist != null) {
			String tsfId = generateTsfId();
			LocalDate date = LocalDate.now();
			TsfHead tsf = new TsfHead();
			tsf.setTsfId(tsfId);
			tsf.setTotalReqQty(0);
			tsf.setStoreFrom(storeFrom);
			tsf.setStoreTo(storeTo);
			tsf.setCreationDate(date);
			tsf.setCreatedBy(user);
			tsf.setStatus("In Progress");
			tsf = tsfHeadRepo.save(tsf);

			TsfDto tsfDto = new TsfDto(tsf.getTsfId(), tsf.getCreationDate(), tsf.getStoreFrom(), tsf.getStoreTo(),
					tsf.getCreatedBy(), tsf.getStatus(), tsf.getTotalReqQty(), "TSFIN");
			return tsfDto;
		} else {
			throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Please add the appropriate store ");
		}

	}

	// Function to add products in Transfer
	@Override
	@Transactional
	public String saveTansfer(TSFCombinedDto tsfCombinedDto) {

		int requestedQty = 0;

		TsfHead tsf = tsfHeadRepo.findByTsfId(tsfCombinedDto.getId());
		tsf.setReasonCode(tsfCombinedDto.getReason());
		tsf.setAttachedProof(tsfCombinedDto.getImage());
		tsf.setNotAfter(tsfCombinedDto.getNotAfter());
		tsf.setNotBefore(tsfCombinedDto.getNotBefore());
		tsf.setStatus("New Request");
		List<TsfDetails> tsfProducts = new ArrayList<>();

		Stores store = storeRepo.findByStoreName(tsf.getStoreTo());

		for (int i = 0; i < tsfCombinedDto.getTsfDetailsDto().size(); i++) {
			ProductDetails product = productDetailsRepo
					.findBySkuAndStore(tsfCombinedDto.getTsfDetailsDto().get(i).getSku(), store);

			if (product != null && product.getSellableStock() >= tsfCombinedDto.getTsfDetailsDto().get(i).getQty()) {
				tsfProducts.add(new TsfDetails(tsfCombinedDto.getTsfDetailsDto().get(i).getQty(), 0, 0, 0, 0, null,
						tsfCombinedDto.getTsfDetailsDto().get(i).getUpc(),
						tsfCombinedDto.getTsfDetailsDto().get(i).getSku(), tsf));

				requestedQty = requestedQty + tsfCombinedDto.getTsfDetailsDto().get(i).getQty();
			} else {
				throw new RuntimeException("Expected qty can't exceed available store qty!");
			}

			tsf.setTotalReqQty(requestedQty);
			tsf = tsfHeadRepo.save(tsf);

		}

		tsfDetailsRepo.saveAll(tsfProducts);
		return "Products added successfully";
	}

	@Override
	public String generateTsfId() {
		final String CHARACTERS = "0123456789";
		final SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(10);
		sb.append("TSF");
		for (int i = 0; i < 12; i++) {
			sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

		}
		return sb.toString();
	}

	// function to get IN Transfers
	@Override
	public List<TsfHeadDtoToGetTransfers> getInTransfers(String store) {

		List<TsfHead> inTransfers = tsfHeadRepo.findAllByStoreFrom(store);
		List<TsfHeadDtoToGetTransfers> TsfHeadDto = new ArrayList<>();
		for (int i = 0; i < inTransfers.size(); i++) {
			Stores store1 = storeRepo.findByStoreName(inTransfers.get(i).getStoreFrom());
			TsfHeadDto.add(new TsfHeadDtoToGetTransfers(inTransfers.get(i).getTsfId(), store1.getStoreId(),
					inTransfers.get(i).getStoreTo(), inTransfers.get(i).getStatus(),
					inTransfers.get(i).getCreationDate(), "TSFIN", inTransfers.get(i).getTotalReqQty()));
		}
		return TsfHeadDto;
	}

	// function to get OUT Transfers
	@Override
	public List<TsfHeadDtoToGetTransfers> getOutTransfers(String store) {

		List<TsfHead> outTransfers = tsfHeadRepo.findAllByStoreTo(store);
		List<TsfHeadDtoToGetTransfers> TsfHeadDto = new ArrayList<>();
		for (int i = 0; i < outTransfers.size(); i++) {
			Stores store1 = storeRepo.findByStoreName(outTransfers.get(i).getStoreFrom());
			TsfHeadDto.add(new TsfHeadDtoToGetTransfers(outTransfers.get(i).getTsfId(), store1.getStoreId(),
					outTransfers.get(i).getStoreFrom(), outTransfers.get(i).getStatus(),
					outTransfers.get(i).getCreationDate(), "TSFOUT", outTransfers.get(i).getTotalReqQty()));
		}
		return TsfHeadDto;
	}

	// Function to get TSF products by TSF Id -- Order Fulfillment
	@Override
	public TsfOrderAcceptanceStoreAndProductsDto getTsfProductsById(String TsfId) {

		TsfHead tsf = tsfHeadRepo.findByTsfId(TsfId);

		String store = tsf.getStoreTo();
		Stores requestedstore = storeRepo.findByStoreName(store);

		List<TsfDetails> tsfProds = tsfDetailsRepo.findByTsfHead(tsf);
		List<TsfDetailsDto> tsfDetailsDto = new ArrayList<>();

		for (int i = 0; i < tsfProds.size(); i++) {
			ProductDetails product = productDetailsRepo.findBySkuAndStore(tsfProds.get(i).getSku(), requestedstore);

			tsfDetailsDto.add(new TsfDetailsDto(product.getProduct().getItemNumber(),
					product.getProduct().getitemName(), product.getProduct().getCategory().getCategory(),
					product.getColor(), product.getPrice(), product.getSize(), tsfProds.get(i).getRequestedQty(),
					tsfProds.get(i).getApprovedQty(), tsfProds.get(i).getShippedQty(), tsfProds.get(i).getReceivedQty(),
					tsfProds.get(i).getDamageQty(), tsfProds.get(i).getDamageProof(), product.getImageData(),
					tsfProds.get(i).getUpc(), tsfProds.get(i).getSku(), "TSFOUT"));
		}

		TsfOrderAcceptanceStoreAndProductsDto tsfOrderAcceptanceDto = new TsfOrderAcceptanceStoreAndProductsDto(TsfId,
				tsf.getStatus(), tsf.getNotAfter(), tsf.getNotBefore(), tsf.getStoreFrom(), tsf.getStoreTo(),
				tsf.getReasonCode(), tsfDetailsDto);

		return tsfOrderAcceptanceDto;

	}

	// Function to get TSF products for shipment by TSF Id -- Order Fulfillment
	@Override
	public TsfShipmentAndStoreCombinedDto getTsfProductsByIdForShipment(String TsfId) {
		TsfHead tsf = tsfHeadRepo.findByTsfId(TsfId);

		String store = tsf.getStoreTo();
		Stores requestedstore = storeRepo.findByStoreName(store);

		List<TsfDetails> tsfProds = tsfDetailsRepo.findByTsfHead(tsf);
		List<TsfDetailsShipmentDto> tsfDetailsDto = new ArrayList<>();

		for (int i = 0; i < tsfProds.size(); i++) {
			ProductDetails product = productDetailsRepo.findBySkuAndStore(tsfProds.get(i).getSku(), requestedstore);

			tsfDetailsDto.add(
					new TsfDetailsShipmentDto(product.getProduct().getItemNumber(), product.getProduct().getitemName(),
							product.getProduct().getCategory().getCategory(), product.getColor(), product.getPrice(),
							product.getSize(), tsfProds.get(i).getRequestedQty(), tsfProds.get(i).getApprovedQty(),
							product.getImageData(), tsfProds.get(i).getUpc(), tsfProds.get(i).getSku(), "TSFOUT"));
		}

		TsfShipmentAndStoreCombinedDto tsfShipmentDto = new TsfShipmentAndStoreCombinedDto(TsfId, tsf.getStatus(),
				tsf.getNotAfter(), tsf.getNotBefore(), tsf.getStoreFrom(), tsf.getStoreTo(), tsf.getReasonCode(),
				tsfDetailsDto);
		return tsfShipmentDto;

	}

	// Function to update TSFHead and Details on Acceptance And Rejection -- Order
	// Fulfillment
	@Override
	public String updateTsfHeadandTsfDetails(TsfOrderAcceptanceDto tsfOrderAcceptanceDto) {

		TsfHead tsf = tsfHeadRepo.findByTsfId(tsfOrderAcceptanceDto.getTsfId());
		tsf.setStatus(tsfOrderAcceptanceDto.getStatus());
		tsf.setApprovedDate(LocalDate.now());
		tsfHeadRepo.save(tsf);
		if (tsfOrderAcceptanceDto.getStatus().equals("Accepted")) {

			tsfOrderAcceptanceDto.getTsfDetailsUpdationDto().stream().map(item -> {
				TsfDetails tsfProduct = tsfDetailsRepo.findByTsfHeadAndSku(tsf, item.getSku());
				tsfProduct.setApprovedQty(tsfProduct.getRequestedQty());
				tsfDetailsRepo.save(tsfProduct);
				return tsfProduct;
			}).collect(Collectors.toList());
		}

		else if (tsfOrderAcceptanceDto.getStatus().equals("Rejected")) {
			tsf.setClosedDate(LocalDate.now());
		}

		return "Details Updated Successfully";

	}

	// Function to Ship TSF
	@Transactional
	@Override
	public String ShipTsf(TsfOrderAcceptanceDto tsfOrderAcceptanceDto, String store) {

		TsfHead tsf = tsfHeadRepo.findByTsfId(tsfOrderAcceptanceDto.getTsfId());

		if (tsf.getStatus().equals("Partially Accepted")) {

			Stores Store = storeRepo.findByStoreName(store);

			tsfOrderAcceptanceDto.getTsfDetailsUpdationDto().stream().map(item -> {

				TsfDetails tsfProduct = tsfDetailsRepo.findByTsfHeadAndSku(tsf, item.getSku());
				tsfProduct.setShippedQty(item.getQty());
				tsfProduct.setApprovedQty(item.getQty());
				tsfDetailsRepo.save(tsfProduct);

				// Product product = productRepo.findByItemNumber(item.getItemNumber());

				ProductDetails productDetails = productDetailsRepo.findBySkuAndStore(item.getSku(), Store);

				if (productDetails != null) {
					productDetails.setSellableStock(productDetails.getSellableStock() - item.getQty());
					productDetails.setTotalStock(productDetails.getTotalStock() - item.getQty());
					productDetailsRepo.save(productDetails);
				}

				return tsfProduct;
			}).collect(Collectors.toList());
		}

		else if (tsf.getStatus().equals("Accepted")) {

			Stores Store = storeRepo.findByStoreName(store);

			tsfOrderAcceptanceDto.getTsfDetailsUpdationDto().stream().map(item -> {

				TsfDetails tsfProduct = tsfDetailsRepo.findByTsfHeadAndSku(tsf, item.getSku());
				tsfProduct.setShippedQty(item.getQty());
				tsfDetailsRepo.save(tsfProduct);

				// Product product = productRepo.findByItemNumber(item.getItemNumber());

				ProductDetails productDetails = productDetailsRepo.findBySkuAndStore(item.getSku(), Store);

				if (productDetails != null) {
					productDetails.setSellableStock(productDetails.getSellableStock() - item.getQty());
					productDetails.setTotalStock(productDetails.getTotalStock() - item.getQty());
					productDetailsRepo.save(productDetails);
				}

				return tsfProduct;
			}).collect(Collectors.toList());
		}

		tsf.setStatus("Shipped");
		tsfHeadRepo.save(tsf);

		return "TSF Shipped Successfully";

	}

	// Function to get TSF to receive -- Transfer Receiving
	@Override
	public TsfReceivingItemsAndStoreCombinedDto getTsfToReceive(String tsfId) {

		TsfHead tsf = tsfHeadRepo.findByTsfId(tsfId);

		List<TsfDetails> tsfProds = tsfDetailsRepo.findByTsfHead(tsf);
		List<TsfDetailsGetReceivingDto> tsfDetailsDto = new ArrayList<>();

		String store = tsf.getStoreFrom();
		Stores requestedstore = storeRepo.findByStoreName(store);

		for (int i = 0; i < tsfProds.size(); i++) {
			ProductDetails product = productDetailsRepo.findBySkuAndStore(tsfProds.get(i).getSku(), requestedstore);

			tsfDetailsDto.add(new TsfDetailsGetReceivingDto(product.getProduct().getItemNumber(),
					product.getProduct().getitemName(), product.getProduct().getCategory().getCategory(),
					product.getColor(), product.getPrice(), product.getSize(), tsfProds.get(i).getRequestedQty(),
					tsfProds.get(i).getApprovedQty(), tsfProds.get(i).getShippedQty(), product.getImageData(),
					tsfProds.get(i).getUpc(), tsfProds.get(i).getSku(), "TSFOUT"));
		}

		TsfReceivingItemsAndStoreCombinedDto TsfReceivingItemsDto = new TsfReceivingItemsAndStoreCombinedDto(tsfId,
				tsf.getStatus(), tsf.getNotAfter(), tsf.getNotBefore(), tsf.getStoreFrom(), tsf.getStoreTo(),
				tsf.getReasonCode(), tsfDetailsDto);
		return TsfReceivingItemsDto;

	}

	// Function to save TSF In Master and Update Receiving Qty
	@Override
	public String SaveTSF(TsfSaveReceivingDto tsfSaveReceivingDto) {

//		System.out.println("tsfSaveReceivingDto" + tsfSaveReceivingDto);
		TsfHead tsf = tsfHeadRepo.findByTsfId(tsfSaveReceivingDto.getTsfId());
//		System.out.println("tsf -----------------" + tsf);
		tsf.setStatus("Delivered");
		tsf.setDeliveryDate(LocalDate.now());
		tsf.setAttachedProof(tsfSaveReceivingDto.getImage());
		tsfHeadRepo.save(tsf);

		tsfSaveReceivingDto.getTsfDetailsSaveDto().stream().map(item -> {
			TsfDetails tsfProduct = tsfDetailsRepo.findByTsfHeadAndSku(tsf, item.getSku());
			tsfProduct.setReceivedQty(tsfProduct.getReceivedQty() + item.getReceivedQty());
			tsfProduct.setDamageQty(tsfProduct.getDamageQty() + item.getDamageQty());
			tsfProduct.setDamageProof(item.getDamageProof());
			tsfDetailsRepo.save(tsfProduct);
			return tsfProduct;
		}).collect(Collectors.toList());

		Stores storeTo = storeRepo.findByStoreName(tsf.getStoreTo());

		for (int i = 0; i < tsfSaveReceivingDto.getTsfDetailsSaveDto().size(); i++) {
//			Category category = categoryRepo
//					.findByCategory(tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getCategory());
//			Product product = productRepo
//					.findByItemNumber(tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getItemNumber());

			ProductDetails productDetails1 = productDetailsRepo
					.findBySkuAndStore(tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getSku(), storeTo);

			int Prev_sellableStock;
			int new_sellableStock;
			int totalSellable = 0;
			int new_nonSellableStock;
			int totalNonSellable = 0;

			if (productDetails1 != null) {
				Prev_sellableStock = productDetails1.getSellableStock();
				new_sellableStock = tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getReceivedQty();
				totalSellable = Prev_sellableStock + new_sellableStock;

				int nonSellable_stock = productDetails1.getNonSellableStock();
				new_nonSellableStock = tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getDamageQty();
				totalNonSellable = nonSellable_stock + new_nonSellableStock;

				int total_stock = totalSellable + totalNonSellable;
				productDetails1.setTotalStock(total_stock);
				productDetails1.setSellableStock(totalSellable);
				productDetails1.setNonSellableStock(totalNonSellable);
				productDetailsRepo.save(productDetails1);
				// System.out.println("inside iff");
			}

//			else {
//				ProductDetails productDetails2 = new ProductDetails(
//						tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getColor(),
//						tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getPrice(),
//						tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getSize(),
//						tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getReceivedQty(), 0,
//						tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getImageData(), storeTo, product,
//						tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getUpc(),
//						tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getSku());
//
//				int total_stock = tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getReceivedQty()
//						+ tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getDamageQty();
//				productDetails2.setSellableStock(tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getReceivedQty());
//				productDetails2.setNonSellableStock(tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getDamageQty());
//				productDetails2.setTotalStock(total_stock);
//
//				productDetailsRepo.save(productDetails2);
//				// System.out.println("inside else");
//			}

		}

		return "TSF Saved Successfully";

	}

	@Override
	public List<TSFLandingDto> sortInTsfByLatest(String store) {

		// List<TsfHead> inTransfers = tsfHeadRepo.findAllByStoreFrom(store);
		List<TsfHead> tsf = tsfHeadRepo.findAllByStoreFromOrderByCreationDateDesc(store);

		List<TSFLandingDto> tsfDto = new ArrayList<>();
		for (int i = 0; i < tsf.size(); i++) {
			Stores responseStore = storeRepo.findByStoreName(store);
			tsfDto.add(new TSFLandingDto(tsf.get(i).getTsfId(), tsf.get(i).getCreationDate(), tsf.get(i).getStatus(),
					tsf.get(i).getTotalReqQty(), Integer.toString(responseStore.getStoreId()), "TSFIN"));
		}
		return tsfDto;
	}

	@Override
	public List<TSFLandingDto> sortInTsfByOldest(String store) {

		List<TsfHead> tsf = tsfHeadRepo.findAllByStoreFromOrderByCreationDateAsc(store);

		List<TSFLandingDto> tsfDto = new ArrayList<>();
		for (int i = 0; i < tsf.size(); i++) {
			Stores responseStore = storeRepo.findByStoreName(store);
			tsfDto.add(new TSFLandingDto(tsf.get(i).getTsfId(), tsf.get(i).getCreationDate(), tsf.get(i).getStatus(),
					tsf.get(i).getTotalReqQty(), Integer.toString(responseStore.getStoreId()), "TSFIN"));
		}
		return tsfDto;
	}

	@Override
	public List<TSFLandingDto> getMatchedInTransfersByid(String id, String store) {
		List<TsfHead> tsf = tsfHeadRepo.findByTsfIdContainingAndStoreFrom(id, store);

		List<TSFLandingDto> tsfDto = new ArrayList<>();
		for (int i = 0; i < tsf.size(); i++) {
			Stores responseStore = storeRepo.findByStoreName(tsf.get(i).getStoreFrom());
			tsfDto.add(new TSFLandingDto(tsf.get(i).getTsfId(), tsf.get(i).getCreationDate(), tsf.get(i).getStatus(),
					tsf.get(i).getTotalReqQty(), Integer.toString(responseStore.getStoreId()), "TSFIN"));
		}
		return tsfDto;
	}

	@Override
	public List<TSFLandingDto> filtersInTsfByReasonOrStatus(String param, String store) {

		List<TsfHead> tsf = tsfHeadRepo.findByReasonCodeOrStatusAndStoreFrom(param, param, store);

		List<TSFLandingDto> tsfDto = new ArrayList<>();
		for (int i = 0; i < tsf.size(); i++) {
			Stores responseStore = storeRepo.findByStoreName(tsf.get(i).getStoreTo());
			tsfDto.add(new TSFLandingDto(tsf.get(i).getTsfId(), tsf.get(i).getCreationDate(), tsf.get(i).getStatus(),
					tsf.get(i).getTotalReqQty(), Integer.toString(responseStore.getStoreId()), "TSFIN"));
		}
		return tsfDto;
	}

	@Override
	public List<TSFLandingDto> sortOutTsfByLatest(String store) {

		// List<TsfHead> inTransfers = tsfHeadRepo.findAllByStoreFrom(store);
		List<TsfHead> tsf = tsfHeadRepo.findAllByStoreToOrderByCreationDateDesc(store);

		List<TSFLandingDto> tsfDto = new ArrayList<>();
		for (int i = 0; i < tsf.size(); i++) {
			Stores responseStore = storeRepo.findByStoreName(store);
			tsfDto.add(new TSFLandingDto(tsf.get(i).getTsfId(), tsf.get(i).getCreationDate(), tsf.get(i).getStatus(),
					tsf.get(i).getTotalReqQty(), Integer.toString(responseStore.getStoreId()), "TSFOUT"));
		}
		return tsfDto;
	}

	@Override
	public List<TSFLandingDto> sortOutTsfByOldest(String store) {

		List<TsfHead> tsf = tsfHeadRepo.findAllByStoreToOrderByCreationDateAsc(store);

		List<TSFLandingDto> tsfDto = new ArrayList<>();
		for (int i = 0; i < tsf.size(); i++) {
			Stores responseStore = storeRepo.findByStoreName(store);
			tsfDto.add(new TSFLandingDto(tsf.get(i).getTsfId(), tsf.get(i).getCreationDate(), tsf.get(i).getStatus(),
					tsf.get(i).getTotalReqQty(), Integer.toString(responseStore.getStoreId()), "TSFOUT"));
		}
		return tsfDto;
	}

	@Override
	public List<TSFLandingDto> getMatchedOutTransfersByid(String id, String store) {
		List<TsfHead> tsf = tsfHeadRepo.findByTsfIdContainingAndStoreTo(id, store);

		List<TSFLandingDto> tsfDto = new ArrayList<>();
		for (int i = 0; i < tsf.size(); i++) {
			Stores responseStore = storeRepo.findByStoreName(tsf.get(i).getStoreFrom());
			tsfDto.add(new TSFLandingDto(tsf.get(i).getTsfId(), tsf.get(i).getCreationDate(), tsf.get(i).getStatus(),
					tsf.get(i).getTotalReqQty(), Integer.toString(responseStore.getStoreId()), "TSFOUT"));
		}
		return tsfDto;
	}

	@Override
	public List<TSFLandingDto> filtersOutTsfByReasonOrStatus(String param, String store) {

		List<TsfHead> tsf = tsfHeadRepo.findByReasonCodeOrStatusAndStoreTo(param, param, store);

		List<TSFLandingDto> tsfDto = new ArrayList<>();
		for (int i = 0; i < tsf.size(); i++) {
			Stores responseStore = storeRepo.findByStoreName(tsf.get(i).getStoreTo());
			tsfDto.add(new TSFLandingDto(tsf.get(i).getTsfId(), tsf.get(i).getCreationDate(), tsf.get(i).getStatus(),
					tsf.get(i).getTotalReqQty(), Integer.toString(responseStore.getStoreId()), "TSFOUT"));
		}
		return tsfDto;
	}
}

//if (product == null) {
//
//	Product product1 = new Product(tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getItemNumber(),
//			tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getItemName(), category);
//	productRepo.save(product1);
//
//	Product product2 = productRepo
//			.findByItemNumber(tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getItemNumber());
//	ProductDetails productDetails2 = new ProductDetails(
//			tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getColor(),
//			tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getPrice(),
//			tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getSize(),
//			tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getReceivedQty(), 0,
//			tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getImageData(), storeTo, product2,
//			tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getUpc(),
//			tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getSku());
//
//	int total_stock = tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getReceivedQty()
//			+ tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getDamageQty();
//	productDetails2.setSellableStock(tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getReceivedQty());
//	productDetails2.setNonSellableStock(tsfSaveReceivingDto.getTsfDetailsSaveDto().get(i).getDamageQty());
//	productDetails2.setTotalStock(total_stock);
//	productDetailsRepo.save(productDetails2);
//
//}
