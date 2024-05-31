
package com.inventory.purchaseorder.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.purchaseorder.dto.DsdCombinedDto;
import com.inventory.purchaseorder.dto.DsdItemsGetdto;
import com.inventory.purchaseorder.entity.Category;
import com.inventory.purchaseorder.entity.DSD;
import com.inventory.purchaseorder.entity.DsdItems;
import com.inventory.purchaseorder.entity.Product;
import com.inventory.purchaseorder.entity.ProductDetails;
import com.inventory.purchaseorder.entity.Stores;
import com.inventory.purchaseorder.repository.CategoryRepo;
import com.inventory.purchaseorder.repository.DsdItemsRepo;
import com.inventory.purchaseorder.repository.DsdSuppliersRepo;
import com.inventory.purchaseorder.repository.ProductDetailsRepo;
import com.inventory.purchaseorder.repository.ProductRepo;
import com.inventory.purchaseorder.repository.StoreRepo;
import com.inventory.purchaseorder.service.DSDService;
import com.inventory.purchaseorder.repository.DsdRepo;

@Service
public class DSDServiceImpl implements DSDService {

	@Autowired
	private DsdSuppliersRepo DsdSuppliersRepo;

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ProductDetailsRepo productDetailsRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private StoreRepo storeRepo;

	@Autowired
	private DsdRepo dsdRepo;

	@Autowired
	private DsdItemsRepo dsdItemsRepo;

	@Override
	public String saveDsd(DsdCombinedDto dsdCombinedDto) {

		Stores store = storeRepo.findByStoreName(dsdCombinedDto.getDsd().getStoreLocation());
		for (int i = 0; i < dsdCombinedDto.getDsdItems().size(); i++) {
			Category category = categoryRepo.findByCategory(dsdCombinedDto.getDsdItems().get(i).getCategory());
			Product product = productRepo.findByItemNumber(dsdCombinedDto.getDsdItems().get(i).getItemNumber());

			if (product == null) {

				Product product1 = new Product(dsdCombinedDto.getDsdItems().get(i).getItemNumber(),
						dsdCombinedDto.getDsdItems().get(i).getItemName(), category);
				productRepo.save(product1);

				Product product2 = productRepo.findByItemNumber(dsdCombinedDto.getDsdItems().get(i).getItemNumber());
				ProductDetails productDetails2 = new ProductDetails(dsdCombinedDto.getDsdItems().get(i).getColor(),
						dsdCombinedDto.getDsdItems().get(i).getPrice(), dsdCombinedDto.getDsdItems().get(i).getSize(),
						dsdCombinedDto.getDsdItems().get(i).getReceivedQty(), 0,
						dsdCombinedDto.getDsdItems().get(i).getImageData(), store, product2,
						dsdCombinedDto.getDsdItems().get(i).getUpc(), dsdCombinedDto.getDsdItems().get(i).getSku());

				int total_stock = dsdCombinedDto.getDsdItems().get(i).getReceivedQty()
						+ dsdCombinedDto.getDsdItems().get(i).getDamageQty();
				productDetails2.setTotalStock(total_stock);

				int damageQty = dsdCombinedDto.getDsdItems().get(i).getDamageQty();
				productDetails2.setNonSellableStock(damageQty);
				productDetails2.setSellableStock(dsdCombinedDto.getDsdItems().get(i).getReceivedQty());
				productDetailsRepo.save(productDetails2);

			}

			else {
				ProductDetails productDetails1 = productDetailsRepo
						.findBySkuAndStore(dsdCombinedDto.getDsdItems().get(i).getSku(), store);
				int Prev_sellableStock;
				int new_sellableStock;
				int totalSellable = 0;
				int new_nonSellableStock;
				int totalNonSellable = 0;

				if (productDetails1 != null) {
					Prev_sellableStock = productDetails1.getSellableStock();
					new_sellableStock = dsdCombinedDto.getDsdItems().get(i).getReceivedQty();
					totalSellable = Prev_sellableStock + new_sellableStock;

					int nonSellable_stock = productDetails1.getNonSellableStock();
					new_nonSellableStock = dsdCombinedDto.getDsdItems().get(i).getDamageQty();
					totalNonSellable = nonSellable_stock + new_nonSellableStock;

					int total_stock = totalSellable + totalNonSellable;
					productDetails1.setTotalStock(total_stock);
					productDetails1.setSellableStock(totalSellable);
					productDetails1.setNonSellableStock(totalNonSellable);
					productDetailsRepo.save(productDetails1);
					// System.out.println("inside iff");
				}

				else {
					ProductDetails productDetails2 = new ProductDetails(dsdCombinedDto.getDsdItems().get(i).getColor(),
							dsdCombinedDto.getDsdItems().get(i).getPrice(),
							dsdCombinedDto.getDsdItems().get(i).getSize(),
							dsdCombinedDto.getDsdItems().get(i).getReceivedQty(), 0,
							dsdCombinedDto.getDsdItems().get(i).getImageData(), store, product,
							dsdCombinedDto.getDsdItems().get(i).getUpc(), dsdCombinedDto.getDsdItems().get(i).getSku());

					int total_stock = dsdCombinedDto.getDsdItems().get(i).getReceivedQty()
							+ dsdCombinedDto.getDsdItems().get(i).getDamageQty();
					productDetails2.setTotalStock(total_stock);

					int damageQty = dsdCombinedDto.getDsdItems().get(i).getDamageQty();
					productDetails2.setNonSellableStock(damageQty);
					productDetails2.setSellableStock(dsdCombinedDto.getDsdItems().get(i).getReceivedQty());
					// System.out.println("inside else");
				}

			}

		}

		DSD dsd = new DSD(dsdCombinedDto.getDsd().getStatus(), dsdCombinedDto.getDsd().getSupplierId(),
				dsdCombinedDto.getDsd().getCost(), dsdCombinedDto.getDsd().getTotalSKU(),
				dsdCombinedDto.getDsd().getStoreLocation(), dsdCombinedDto.getDsd().getCreationDate(),
				dsdCombinedDto.getDsd().getAttachedImage(), dsdCombinedDto.getDsd().getInvoiceNumber());

		dsdRepo.save(dsd);
		DSD dsd1 = dsdRepo.findFirstByOrderByDsdNumberDesc();
		for (int i = 0; i < dsdCombinedDto.getDsdItems().size(); i++) {
			DsdItems dsdItem = new DsdItems(dsdCombinedDto.getDsdItems().get(i).getItemNumber(),
					dsdCombinedDto.getDsdItems().get(i).getItemName(),
					dsdCombinedDto.getDsdItems().get(i).getExpectedQty(),
					dsdCombinedDto.getDsdItems().get(i).getReceivedQty(),
					dsdCombinedDto.getDsdItems().get(i).getCategory(), dsdCombinedDto.getDsdItems().get(i).getColor(),
					dsdCombinedDto.getDsdItems().get(i).getPrice(), dsdCombinedDto.getDsdItems().get(i).getSize(),
					dsdCombinedDto.getDsdItems().get(i).getImageData(), dsdCombinedDto.getDsdItems().get(i).getUpc(),
					dsdCombinedDto.getDsdItems().get(i).getSku(),
					dsdCombinedDto.getDsdItems().get(i).getTaxPercentage(),
					dsdCombinedDto.getDsdItems().get(i).getTaxCode(),
					dsdCombinedDto.getDsdItems().get(i).getDamageQty(),
					dsdCombinedDto.getDsdItems().get(i).getDamageImage(), dsd1);

			dsdItemsRepo.save(dsdItem);
		}

		return "Saved Successfully";
	}

	@Override
	public List<DSD> getAllDSd() {
		List<DSD> dsd = dsdRepo.findAll();
		return dsd;

	}

	@Override
	public List<DsdItemsGetdto> getAllDSdItems(int dsdNumber) {
		DSD dsd = dsdRepo.findByDsdNumber(dsdNumber);
		List<DsdItems> dsdItems = dsdItemsRepo.findByDsd(dsd);

		List<DsdItemsGetdto> items = new ArrayList<>();

		for (int i = 0; i < dsdItems.size(); i++) {
			items.add(new DsdItemsGetdto(dsdItems.get(i).getItemNumber(), dsdItems.get(i).getItemName(),
					dsdItems.get(i).getExpectedQty(), dsdItems.get(i).getReceivedQty(), dsdItems.get(i).getSku(),
					dsdItems.get(i).getDamageQty(), dsdItems.get(i).getDamageImage()));
		}
		return items;
	}

	@Override
	public List<DsdItemsGetdto> getDamageDSdItems(int dsdNumber) {
		DSD dsd = dsdRepo.findByDsdNumber(dsdNumber);
		List<DsdItems> dsdItems = dsdItemsRepo.findByDsd(dsd);

		List<DsdItemsGetdto> items = new ArrayList<>();

		for (int i = 0; i < dsdItems.size(); i++) {
			if (dsdItems.get(i).getDamageQty() > 0) {
				items.add(new DsdItemsGetdto(dsdItems.get(i).getItemNumber(), dsdItems.get(i).getItemName(),
						dsdItems.get(i).getExpectedQty(), dsdItems.get(i).getReceivedQty(), dsdItems.get(i).getSku(),
						dsdItems.get(i).getDamageQty(), dsdItems.get(i).getDamageImage()));
			}
		}
		return items;
	}

}
