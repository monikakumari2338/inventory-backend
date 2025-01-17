
package com.inventory.sc.service;

import java.security.SecureRandom;


import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.inventory.exception.ExceptionHandling;
import com.inventory.myrepository.ProductDetailsRepo;
import com.inventory.myrepository.StockCountReasonCodesRepo;
import com.inventory.myrepository.StockCreationProductsRepo;
import com.inventory.myrepository.StockCreationRepo;
import com.inventory.myrepository.StoreRepo;
import com.inventory.product.jpa.entity.ProductDetails;
import com.inventory.sc.jpa.dto.SCLandingDto;
import com.inventory.sc.jpa.dto.ScGetProductsdto;
import com.inventory.sc.jpa.dto.StockCountAdhocCreationCombinedDto;
import com.inventory.sc.jpa.dto.StockCountCombinedDto;
import com.inventory.sc.jpa.dto.StockCountCreationDto;
import com.inventory.sc.jpa.dto.StockCountUpdateCombinedDto;
import com.inventory.sc.jpa.entity.StockCountCreation;
import com.inventory.sc.jpa.entity.StockCountCreationProducts;
import com.inventory.sc.jpa.entity.StockCountReasonCodes;
import com.inventory.store.jpa.entity.Stores;

import jakarta.transaction.Transactional;

@Service
public class StockCountCreationServiceImpl implements StockCountCreationService {

	@Autowired
	private StockCreationRepo creationRepo;

	@Autowired
	private StockCreationProductsRepo creationProductsRepo;

	@Autowired
	private ProductDetailsRepo productDetailsRepo;

	@Autowired
	private StoreRepo storeRepo;

	@Autowired
	private StockCountReasonCodesRepo scReasonCodesRepo;

	// Function to create system generated stock Count
	@Override
	public String createSystemStockCount(String storeName, LocalDate startDate, LocalDate endDate) {

		Stores store = storeRepo.findByStoreName(storeName);
		if (store != null) {
			String countId = generateScIdString();
			StockCountCreation sc = new StockCountCreation();
			sc.setCountId(countId);
			sc.setStartDate(startDate);
			sc.setEndDate(endDate);
			sc.setCreationDate(LocalDate.now());
			sc.setStore(storeName);
			sc.setStatus("Pending");
			sc.setRecountStatus("Pending");
			sc.setType("SC");
			sc.setSubType("SC");
			creationRepo.save(sc);

			return countId;
		} else {
			throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Please add the appropriate store ");
		}

	}

	// Function to add products in system generated stock count
	@Transactional
	@Override
	public String saveSystemCountProducts(StockCountCreationDto creationDto) {

		StockCountCreation stockCount = creationRepo.findByCountId(creationDto.getId());

		if (stockCount.getStatus().equals("Pending") && stockCount.getRecountStatus().equals("Pending")) {
			stockCount.setReason(creationDto.getReason());
			stockCount.setCategory(creationDto.getCategory());

			creationRepo.save(stockCount);

			int totalBookQty = 0;

			Stores store1 = storeRepo.findByStoreName(stockCount.getStore());
			for (int i = 0; i < creationDto.getCreationProductsDto().size(); i++) {
				StockCountCreationProducts ScProducts = new StockCountCreationProducts();
				ProductDetails Product = productDetailsRepo
						.findBySkuAndStore(creationDto.getCreationProductsDto().get(i).getSku(), store1);

				if (Product != null) {
					ScProducts.setSku(creationDto.getCreationProductsDto().get(i).getSku());
					ScProducts.setUpc(creationDto.getCreationProductsDto().get(i).getUpc());
					ScProducts.setBookQty(Product.getSellableStock());
					ScProducts.setStockcount(stockCount);

					totalBookQty = totalBookQty + Product.getSellableStock();
					creationProductsRepo.save(ScProducts);
				} else {
					throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Incorrect sku found ");
				}
			}

			stockCount.setTotalBookQty(totalBookQty);
			creationRepo.save(stockCount);

		}
		return "Products saved successfully";
	}

	// Function to get all stock counts
	@Override
	public List<SCLandingDto> getAllStockCount() {

		List<StockCountCreation> stockCounts = creationRepo.findAll();

		List<SCLandingDto> stockCountsDto = new ArrayList<>();
		for (int i = 0; i < stockCounts.size(); i++) {

			if ((stockCounts.get(i).getStatus().equals("Pending")
					&& stockCounts.get(i).getRecountStatus().equals("Pending"))
					|| (stockCounts.get(i).getStatus().equals("Completed")
							&& stockCounts.get(i).getRecountStatus().equals("Pending"))
					|| (stockCounts.get(i).getStatus().equals("In Progress")
							&& stockCounts.get(i).getRecountStatus().equals("Pending"))) {

				stockCountsDto.add(new SCLandingDto(stockCounts.get(i).getCountId(), stockCounts.get(i).getStartDate(),
						stockCounts.get(i).getEndDate(), stockCounts.get(i).getCreationDate(),
						stockCounts.get(i).getStatus(), stockCounts.get(i).getRecountStatus(),
						stockCounts.get(i).getTotalVarianceQty(), stockCounts.get(i).getTotalBookQty(),
						stockCounts.get(i).getReason(), stockCounts.get(i).getType(), stockCounts.get(i).getSubType()));

			} else if ((stockCounts.get(i).getStatus().equals("Completed")
					&& stockCounts.get(i).getRecountStatus().equals("Completed"))
					|| (stockCounts.get(i).getStatus().equals("Completed")
							&& stockCounts.get(i).getRecountStatus().equals("In Progress"))) {

				stockCountsDto.add(new SCLandingDto(stockCounts.get(i).getCountId(), stockCounts.get(i).getStartDate(),
						stockCounts.get(i).getEndDate(), stockCounts.get(i).getCreationDate(),
						stockCounts.get(i).getStatus(), stockCounts.get(i).getRecountStatus(),
						stockCounts.get(i).getTotalRecountVarianceQty(), stockCounts.get(i).getTotalBookQty(),
						stockCounts.get(i).getReason(), stockCounts.get(i).getType(), stockCounts.get(i).getSubType()));
			}
		}
		return stockCountsDto;

	}

	// Function to get products by count id
	@Override
	public StockCountCombinedDto getStockCountProductsByCountId(String countId) {

		StockCountCreation stockCount = creationRepo.findByCountId(countId);
		List<StockCountCreationProducts> scProducts = creationProductsRepo.findByStockcount(stockCount);
		List<ScGetProductsdto> itemsDto = new ArrayList<>();

		Stores store = storeRepo.findByStoreName(stockCount.getStore());

		if ((stockCount.getStatus().equals("Pending") && stockCount.getRecountStatus().equals("Pending"))) {

			for (int i = 0; i < scProducts.size(); i++) {
				ProductDetails product = productDetailsRepo.findBySkuAndStore(scProducts.get(i).getSku(), store);
				itemsDto.add(
						new ScGetProductsdto(product.getProduct().getItemNumber(), product.getProduct().getitemName(),
								product.getProduct().getCategory().getCategory(), product.getColor(), product.getSize(),
								product.getSku(), product.getUpc(), scProducts.get(i).getBookQty(),
								scProducts.get(i).getVarianceQty(), null, product.getImageData()));
			}
		} else if (stockCount.getStatus().equals("In Progress") && stockCount.getRecountStatus().equals("Pending")
				|| (stockCount.getStatus().equals("Completed") && stockCount.getRecountStatus().equals("Pending"))) {

			for (int i = 0; i < scProducts.size(); i++) {
				ProductDetails product = productDetailsRepo.findBySkuAndStore(scProducts.get(i).getSku(), store);
				itemsDto.add(
						new ScGetProductsdto(product.getProduct().getItemNumber(), product.getProduct().getitemName(),
								product.getProduct().getCategory().getCategory(), product.getColor(), product.getSize(),
								product.getSku(), product.getUpc(), scProducts.get(i).getCountedQty(),
								scProducts.get(i).getVarianceQty(), null, product.getImageData()));
			}
		} else if (stockCount.getStatus().equals("In Progress")
				&& stockCount.getRecountStatus().equals("In Progress")) {

			for (int i = 0; i < scProducts.size(); i++) {
				ProductDetails product = productDetailsRepo.findBySkuAndStore(scProducts.get(i).getSku(), store);
				itemsDto.add(
						new ScGetProductsdto(product.getProduct().getItemNumber(), product.getProduct().getitemName(),
								product.getProduct().getCategory().getCategory(), product.getColor(), product.getSize(),
								product.getSku(), product.getUpc(), scProducts.get(i).getReCountQty(),
								scProducts.get(i).getVarianceQty(), null, product.getImageData()));
			}
		} else if ((stockCount.getStatus().equals("Completed") && stockCount.getRecountStatus().equals("Completed"))) {

			for (int i = 0; i < scProducts.size(); i++) {
				ProductDetails product = productDetailsRepo.findBySkuAndStore(scProducts.get(i).getSku(), store);
				itemsDto.add(
						new ScGetProductsdto(product.getProduct().getItemNumber(), product.getProduct().getitemName(),
								product.getProduct().getCategory().getCategory(), product.getColor(), product.getSize(),
								product.getSku(), product.getUpc(), scProducts.get(i).getReCountQty(),
								scProducts.get(i).getRecountVarianceQty(), null, product.getImageData()));
			}
		}

		StockCountCombinedDto scDto = new StockCountCombinedDto(countId, stockCount.getStartDate(),
				stockCount.getEndDate(), stockCount.getCreationDate(), stockCount.getCategory(),
				stockCount.getTotalBookQty(), stockCount.getReason(), stockCount.getStatus(),
				stockCount.getRecountStatus(), stockCount.getTotalVarianceQty(), stockCount.getType(),
				stockCount.getSubType(), itemsDto);

		return scDto;

	}

	// Function to update qty in stock count products
	@Override
	public String updateStockCount(StockCountUpdateCombinedDto ScUpdateCombinedDto) {

		StockCountCreation stockCount = creationRepo.findByCountId(ScUpdateCombinedDto.getId());
		System.out.println("TEST");

		if ((stockCount.getStatus().equals("Pending") && stockCount.getRecountStatus().equals("Pending")
				|| (stockCount.getStatus().equals("In Progress") && stockCount.getRecountStatus().equals("Pending")))) {

			int totalCountedQty = ScUpdateCombinedDto.getItems().stream().map(item -> {
				StockCountCreationProducts product = creationProductsRepo.findByStockcountAndSku(stockCount,
						item.getSku());

				int varianceQty = item.getQty() - product.getBookQty();
				product.setCountedQty(item.getQty());
				product.setVarianceQty(varianceQty);
				creationProductsRepo.save(product);
				return item.getQty();
			}).reduce(0, Integer::sum);

			int totalVariance = ScUpdateCombinedDto.getItems().stream().map(item -> {
				StockCountCreationProducts product = creationProductsRepo.findByStockcountAndSku(stockCount,
						item.getSku());
				return Math.abs(product.getVarianceQty());
			}).reduce(0, Integer::sum);

			stockCount.setStatus("Completed");
			stockCount.setTotalCountedQty(totalCountedQty);
			stockCount.setTotalVarianceQty(Math.abs(totalVariance));
			creationRepo.save(stockCount);
			System.out.println("IFF");

		} else if ((stockCount.getStatus().equals("Completed") && stockCount.getRecountStatus().equals("Pending")
				|| (stockCount.getStatus().equals("In Progress")
						&& stockCount.getRecountStatus().equals("In Progress")))) {

			int totalRecountQty = ScUpdateCombinedDto.getItems().stream().map(item -> {
				StockCountCreationProducts Product = creationProductsRepo.findByStockcountAndSku(stockCount,
						item.getSku());

				int varianceQty = item.getQty() - Product.getBookQty();
				Product.setReCountQty(item.getQty());
				Product.setRecountVarianceQty(varianceQty);
				creationProductsRepo.save(Product);
				return item.getQty();
			}).reduce(0, Integer::sum);

			int totalRecountVariance = ScUpdateCombinedDto.getItems().stream().map(item -> {
				StockCountCreationProducts product = creationProductsRepo.findByStockcountAndSku(stockCount,
						item.getSku());
				return Math.abs(product.getRecountVarianceQty());
			}).reduce(0, Integer::sum);

			stockCount.setStatus("Completed");
			stockCount.setRecountStatus("Completed");
			stockCount.setTotalRecountQty(totalRecountQty);
			stockCount.setTotalRecountVarianceQty(Math.abs(totalRecountVariance));
			creationRepo.save(stockCount);
			System.out.println("else IFF");

		}

		return "Quantity updated Successfully";

	}

	// Function to get all reason codes
	@Override
	public List<String> getScReasonCodes() {
		List<StockCountReasonCodes> reasonCodes = scReasonCodesRepo.findAll();
		List<String> reasonCodesList = new ArrayList<>();
		for (int i = 0; i < reasonCodes.size(); i++) {
			reasonCodesList.add(reasonCodes.get(i).getReasonCode());
		}
		return reasonCodesList;
	}

	// Function to create Adhoc Count
	@Override
	public StockCountCombinedDto createAdhocstockCount(String storeName, LocalDate startDate, LocalDate endDate) {

		Stores store = storeRepo.findByStoreName(storeName);
		if (store != null) {
			String adhocId = generateScAdhocIdString();
			StockCountCreation sc = new StockCountCreation();
			sc.setCountId(adhocId);
			sc.setCreationDate(LocalDate.now());
			sc.setStartDate(startDate);
			sc.setEndDate(endDate);
			sc.setStore(storeName);
			sc.setReason(null);
			sc.setStatus("New");
			sc.setRecountStatus("Pending");
			sc.setTotalRecountVarianceQty(0);
			sc.setType("SC");
			sc.setSubType("AD");
			sc = creationRepo.save(sc);

			List<ScGetProductsdto> items = new ArrayList<>();
			StockCountCombinedDto scDto = new StockCountCombinedDto(adhocId, sc.getStartDate(), sc.getEndDate(),
					sc.getCreationDate(), sc.getCategory(), sc.getTotalBookQty(), sc.getReason(), sc.getStatus(),
					sc.getRecountStatus(), sc.getTotalVarianceQty(), items);

			return scDto;
		} else {
			throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Please add the appropriate store ");
		}

	}

	// Function to add Adhoc count products in stock count table
	@Transactional
	@Override
	public String saveAdhocProducts(StockCountAdhocCreationCombinedDto adhocDto) {

		StockCountCreation stockCount = creationRepo.findByCountId(adhocDto.getId());

		if ((stockCount.getStatus().equals("New") && stockCount.getRecountStatus().equals("Pending"))
				|| (stockCount.getStatus().equals("In Progress") && stockCount.getRecountStatus().equals("Pending"))) {

			stockCount.setCategory(adhocDto.getCategory());

			creationRepo.save(stockCount);

			int totalBookQty = 0;
			int totalCountedQty = 0;
			int totalVariance = 0;
			creationProductsRepo.deleteAllByStockcount(stockCount);
			Stores store1 = storeRepo.findByStoreName(stockCount.getStore());

			for (int i = 0; i < adhocDto.getItems().size(); i++) {
				StockCountCreationProducts ScProducts = new StockCountCreationProducts();
				ProductDetails Product = productDetailsRepo.findBySkuAndStore(adhocDto.getItems().get(i).getSku(),
						store1);

				if (Product != null) {
					ScProducts.setSku(adhocDto.getItems().get(i).getSku());
					ScProducts.setUpc(adhocDto.getItems().get(i).getUpc());
					ScProducts.setBookQty(Product.getSellableStock());
					ScProducts.setCountedQty(adhocDto.getItems().get(i).getQty());
					ScProducts.setVarianceQty(adhocDto.getItems().get(i).getQty() - Product.getSellableStock());
					ScProducts.setStockcount(stockCount);

					totalBookQty = totalBookQty + Product.getSellableStock();
					totalCountedQty = totalCountedQty + adhocDto.getItems().get(i).getQty();
					creationProductsRepo.save(ScProducts);

					totalVariance = totalVariance + Math.abs(ScProducts.getVarianceQty());
				} else {
					throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Incorrect sku found ");
				}
			}

			stockCount.setTotalBookQty(totalBookQty);
			stockCount.setTotalCountedQty(totalCountedQty);
			stockCount.setStatus("Completed");
			stockCount.setReason(adhocDto.getReason());
			stockCount.setTotalVarianceQty(Math.abs(totalVariance));
			creationRepo.save(stockCount);
			return "Adhoc Products saved successfully";
		} else {

			int totalRecountQty = 0;
			int totalRecountVarianceQty = 0;
			for (int i = 0; i < adhocDto.getItems().size(); i++) {

				StockCountCreationProducts Product = creationProductsRepo.findByStockcountAndSku(stockCount,
						adhocDto.getItems().get(i).getSku());

				if (Product != null) {

					Product.setReCountQty(adhocDto.getItems().get(i).getQty());
					Product.setRecountVarianceQty(adhocDto.getItems().get(i).getQty() - Product.getBookQty());

					totalRecountQty = totalRecountQty + adhocDto.getItems().get(i).getQty();

					creationProductsRepo.save(Product);
					totalRecountVarianceQty = totalRecountVarianceQty + Math.abs(Product.getRecountVarianceQty());
				} else {
					throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Incorrect sku found ");
				}
			}

			stockCount.setTotalRecountQty(totalRecountQty);
			stockCount.setRecountStatus("Completed");
			stockCount.setStatus("Completed");
			stockCount.setReason(adhocDto.getReason());
			stockCount.setTotalRecountVarianceQty(Math.abs(totalRecountVarianceQty));
			creationRepo.save(stockCount);

			return "Adhoc Products saved successfully";
		}
	}

	@Override
	public List<SCLandingDto> sortStockCountsByLatest() {

		List<StockCountCreation> stockCounts = creationRepo.findAllByOrderByStartDateDesc();

		List<SCLandingDto> stockCountsDto = new ArrayList<>();
		for (int i = 0; i < stockCounts.size(); i++) {

			stockCountsDto.add(new SCLandingDto(stockCounts.get(i).getCountId(), stockCounts.get(i).getStartDate(),
					stockCounts.get(i).getEndDate(), stockCounts.get(i).getCreationDate(),
					stockCounts.get(i).getStatus(), stockCounts.get(i).getRecountStatus(),
					stockCounts.get(i).getTotalVarianceQty(), stockCounts.get(i).getTotalBookQty(),
					stockCounts.get(i).getReason(), stockCounts.get(i).getType(), stockCounts.get(i).getSubType()));
		}
		return stockCountsDto;
	}

	@Override
	public List<SCLandingDto> sortStockCountsByOldest() {

		List<StockCountCreation> stockCounts = creationRepo.findAllByOrderByStartDateAsc();

		List<SCLandingDto> stockCountsDto = new ArrayList<>();
		for (int i = 0; i < stockCounts.size(); i++) {

			stockCountsDto.add(new SCLandingDto(stockCounts.get(i).getCountId(), stockCounts.get(i).getStartDate(),
					stockCounts.get(i).getEndDate(), stockCounts.get(i).getCreationDate(),
					stockCounts.get(i).getStatus(), stockCounts.get(i).getRecountStatus(),
					stockCounts.get(i).getTotalVarianceQty(), stockCounts.get(i).getTotalBookQty(),
					stockCounts.get(i).getReason(), stockCounts.get(i).getType(), stockCounts.get(i).getSubType()));
		}
		return stockCountsDto;
	}

	@Override
	public List<SCLandingDto> filterStockCountsByReasonOrStatus(String param) {

		List<StockCountCreation> stockCounts = creationRepo.findByReasonOrStatus(param, param);

		List<SCLandingDto> stockCountsDto = new ArrayList<>();
		for (int i = 0; i < stockCounts.size(); i++) {

			stockCountsDto.add(new SCLandingDto(stockCounts.get(i).getCountId(), stockCounts.get(i).getStartDate(),
					stockCounts.get(i).getEndDate(), stockCounts.get(i).getCreationDate(),
					stockCounts.get(i).getStatus(), stockCounts.get(i).getRecountStatus(),
					stockCounts.get(i).getTotalVarianceQty(), stockCounts.get(i).getTotalBookQty(),
					stockCounts.get(i).getReason(), stockCounts.get(i).getType(), stockCounts.get(i).getSubType()));
		}
		return stockCountsDto;
	}

	@Override
	public List<SCLandingDto> getMatchedStockCounts(String countId) {

		List<StockCountCreation> stockCounts = creationRepo.findByCountIdContaining(countId);

		List<SCLandingDto> stockCountsDto = new ArrayList<>();
		for (int i = 0; i < stockCounts.size(); i++) {

			stockCountsDto.add(new SCLandingDto(stockCounts.get(i).getCountId(), stockCounts.get(i).getStartDate(),
					stockCounts.get(i).getEndDate(), stockCounts.get(i).getCreationDate(),
					stockCounts.get(i).getStatus(), stockCounts.get(i).getRecountStatus(),
					stockCounts.get(i).getTotalVarianceQty(), stockCounts.get(i).getTotalBookQty(),
					stockCounts.get(i).getReason(), stockCounts.get(i).getType(), stockCounts.get(i).getSubType()));
		}
		return stockCountsDto;
	}

	@Override
	public String draftStockCount(StockCountAdhocCreationCombinedDto ScUpdateCombinedDto, String countType) {

		System.out.println("ScUpdateCombinedDto : " + ScUpdateCombinedDto);
		if (countType.equals("system")) {
			StockCountCreation stockCount = creationRepo.findByCountId(ScUpdateCombinedDto.getId());

			if ((stockCount.getStatus().equals("Pending") && stockCount.getRecountStatus().equals("Pending"))
					|| (stockCount.getStatus().equals("In Progress")
							&& stockCount.getRecountStatus().equals("Pending"))) {

				creationProductsRepo.deleteAllByStockcount(stockCount);
				Stores store1 = storeRepo.findByStoreName(stockCount.getStore());

				for (int i = 0; i < ScUpdateCombinedDto.getItems().size(); i++) {
					StockCountCreationProducts ScProducts = new StockCountCreationProducts();
					ProductDetails Product = productDetailsRepo
							.findBySkuAndStore(ScUpdateCombinedDto.getItems().get(i).getSku(), store1);

					if (Product != null) {
						ScProducts.setSku(ScUpdateCombinedDto.getItems().get(i).getSku());
						ScProducts.setUpc(ScUpdateCombinedDto.getItems().get(i).getUpc());
						ScProducts.setCountedQty(ScUpdateCombinedDto.getItems().get(i).getQty());
						ScProducts.setBookQty(Product.getSellableStock());
						ScProducts.setStockcount(stockCount);

						creationProductsRepo.save(ScProducts);
					} else {
						throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Incorrect sku found ");
					}
				}

				stockCount.setStatus("In Progress");
				creationRepo.save(stockCount);

			} else if ((stockCount.getStatus().equals("Completed") && stockCount.getRecountStatus().equals("Pending"))
					|| (stockCount.getStatus().equals("In Progress")
							&& stockCount.getRecountStatus().equals("In Progress"))) {

				ScUpdateCombinedDto.getItems().stream().map(item -> {
					StockCountCreationProducts Product = creationProductsRepo.findByStockcountAndSku(stockCount,
							item.getSku());

					Product.setReCountQty(item.getQty());
					creationProductsRepo.save(Product);
					return item.getQty();
				}).collect(Collectors.toList());

				stockCount.setStatus("In Progress");
				stockCount.setRecountStatus("In Progress");
				creationRepo.save(stockCount);

			}

			return "Quantity updated Successfully";

		} else if (countType.equals("adhoc")) {

			StockCountCreation stockCount = creationRepo.findByCountId(ScUpdateCombinedDto.getId());
			Stores store1 = storeRepo.findByStoreName(stockCount.getStore());

			if (stockCount.getStatus().equals("New") && stockCount.getRecountStatus().equals("Pending")) {
				stockCount.setReason(ScUpdateCombinedDto.getReason());
				stockCount.setCategory(ScUpdateCombinedDto.getCategory());

				creationRepo.save(stockCount);

				System.out.println("case 1");
				int totalBookQty = 0;
				int totalCountedQty = 0;

				for (int i = 0; i < ScUpdateCombinedDto.getItems().size(); i++) {
					StockCountCreationProducts ScProducts = new StockCountCreationProducts();
					ProductDetails Product = productDetailsRepo
							.findBySkuAndStore(ScUpdateCombinedDto.getItems().get(i).getSku(), store1);

					if (Product != null) {
						ScProducts.setSku(ScUpdateCombinedDto.getItems().get(i).getSku());
						ScProducts.setUpc(ScUpdateCombinedDto.getItems().get(i).getUpc());
						ScProducts.setBookQty(Product.getSellableStock());
						ScProducts.setCountedQty(ScUpdateCombinedDto.getItems().get(i).getQty());
						// ScProducts.setVarianceQty(Product.getSellableStock() -
						// adhocDto.getItems().get(i).getQty());
						ScProducts.setStockcount(stockCount);

						totalBookQty = totalBookQty + Product.getSellableStock();
						totalCountedQty = totalCountedQty + ScUpdateCombinedDto.getItems().get(i).getQty();
						creationProductsRepo.save(ScProducts);
					} else {
						throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Incorrect sku found ");
					}
				}

				stockCount.setTotalBookQty(totalBookQty);
				stockCount.setTotalCountedQty(totalCountedQty);
				stockCount.setStatus("In Progress");
				// stockCount.setTotalVarianceQty(totalBookQty - totalCountedQty);
				creationRepo.save(stockCount);
				return "Adhoc Draft saved successfully";

			} else if (stockCount.getStatus().equals("In Progress")
					&& stockCount.getRecountStatus().equals("Pending")) {

				System.out.println("case 2");
				int totalBookQty = 0;
				int totalCountedQty = 0;
				creationProductsRepo.deleteAllByStockcount(stockCount);
				for (int i = 0; i < ScUpdateCombinedDto.getItems().size(); i++) {
					StockCountCreationProducts ScProducts = new StockCountCreationProducts();
					ProductDetails Product = productDetailsRepo
							.findBySkuAndStore(ScUpdateCombinedDto.getItems().get(i).getSku(), store1);

					if (Product != null) {
						ScProducts.setSku(ScUpdateCombinedDto.getItems().get(i).getSku());
						ScProducts.setUpc(ScUpdateCombinedDto.getItems().get(i).getUpc());
						ScProducts.setBookQty(Product.getSellableStock());
						ScProducts.setCountedQty(ScUpdateCombinedDto.getItems().get(i).getQty());
						// ScProducts.setVarianceQty(Product.getSellableStock() -
						// adhocDto.getItems().get(i).getQty());
						ScProducts.setStockcount(stockCount);

						totalBookQty = totalBookQty + Product.getSellableStock();
						totalCountedQty = totalCountedQty + ScUpdateCombinedDto.getItems().get(i).getQty();
						creationProductsRepo.save(ScProducts);
					} else {
						throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Incorrect sku found ");
					}
				}
				stockCount.setTotalBookQty(totalBookQty);
				stockCount.setTotalCountedQty(totalCountedQty);
				creationRepo.save(stockCount);

			}

			else if ((stockCount.getStatus().equals("Completed") && stockCount.getRecountStatus().equals("Pending")
					|| (stockCount.getStatus().equals("In Progress")
							&& stockCount.getRecountStatus().equals("In Progress")))) {

				System.out.println("case 3");
				int totalRecountQty = 0;

				for (int i = 0; i < ScUpdateCombinedDto.getItems().size(); i++) {

					System.out.println("sku :" + ScUpdateCombinedDto.getItems().get(i).getSku());
					StockCountCreationProducts Product = creationProductsRepo.findByStockcountAndSku(stockCount,
							ScUpdateCombinedDto.getItems().get(i).getSku());

					if (Product != null) {

						Product.setReCountQty(ScUpdateCombinedDto.getItems().get(i).getQty());
						Product.setRecountVarianceQty(
								Product.getBookQty() - ScUpdateCombinedDto.getItems().get(i).getQty());

						totalRecountQty = totalRecountQty + ScUpdateCombinedDto.getItems().get(i).getQty();
						creationProductsRepo.save(Product);
					} else {
						throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Incorrect sku found ");
					}
				}

				stockCount.setTotalRecountQty(totalRecountQty);
				stockCount.setRecountStatus("In Progress");
				stockCount.setStatus("In Progress");
				stockCount.setTotalRecountVarianceQty(stockCount.getTotalBookQty() - totalRecountQty);
				creationRepo.save(stockCount);

			}
			return "Quantity updated Successfully";
		}
		return null;

	}

	// Function to generate Id's
	public String generateScIdString() {
		final String CHARACTERS = "0123456789";
		final SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(10);
		sb.append("SC");
		for (int i = 0; i < 12; i++) {
			sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

		}
		return sb.toString();
	}

	public String generateScAdhocIdString() {
		final String CHARACTERS = "0123456789";
		final SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(5);
		sb.append("ADHOC");
		for (int i = 0; i < 7; i++) {
			sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

		}
		return sb.toString();
	}
}
