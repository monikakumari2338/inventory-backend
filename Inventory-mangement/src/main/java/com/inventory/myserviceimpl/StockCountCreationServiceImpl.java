
package com.inventory.myserviceimpl;

import java.time.LocalDate;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.mydto.StockCountCreationCombinedDto;
import com.inventory.mydto.StockCountCreationProductsdto;
import com.inventory.mydto.StockCountCreationdto;
import com.inventory.myentity.Category;
import com.inventory.myentity.StockCountCreation;
import com.inventory.myentity.StockCountCreationProducts;
import com.inventory.myrepository.CategoryRepo;
import com.inventory.myrepository.StockCreationProductsRepo;
import com.inventory.myrepository.StockCreationRepo;
import com.inventory.myservice.StockCountCreationService;

@Service
public class StockCountCreationServiceImpl implements StockCountCreationService {

	@Autowired
	private StockCreationRepo creationRepo;

	@Autowired
	private StockCreationProductsRepo creationProductsRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public StockCountCreationCombinedDto saveProducts(StockCountCreationCombinedDto StockCountCreationCombinedDto) {

		StockCountCreation stockCountCreation = new StockCountCreation(
				StockCountCreationCombinedDto.getCreationdto().getCountDescription(),
				StockCountCreationCombinedDto.getCreationdto().getDate(),
				StockCountCreationCombinedDto.getCreationdto().getStatus(),
				StockCountCreationCombinedDto.getCreationdto().getTotalBookQty(),
				StockCountCreationCombinedDto.getCreationdto().getReCount(),
				StockCountCreationCombinedDto.getCreationdto().getStore());

		stockCountCreation = creationRepo.save(stockCountCreation);

		for (int i = 0; i < StockCountCreationCombinedDto.getCreationProductsdto().size(); i++) {
			StockCountCreationProducts stockCountCreationProducts = new StockCountCreationProducts(
					StockCountCreationCombinedDto.getCreationProductsdto().get(i).getItemNumber(),
					StockCountCreationCombinedDto.getCreationProductsdto().get(i).getItemName(),
					StockCountCreationCombinedDto.getCreationProductsdto().get(i).getCategory(),
					StockCountCreationCombinedDto.getCreationProductsdto().get(i).getColor(),
					StockCountCreationCombinedDto.getCreationProductsdto().get(i).getPrice(),
					StockCountCreationCombinedDto.getCreationProductsdto().get(i).getSize(),
					StockCountCreationCombinedDto.getCreationProductsdto().get(i).getImageData(),
					StockCountCreationCombinedDto.getCreationProductsdto().get(i).getStore(),
					StockCountCreationCombinedDto.getCreationProductsdto().get(i).getBookQty(),
					StockCountCreationCombinedDto.getCreationProductsdto().get(i).getSku(), stockCountCreation);
			creationProductsRepo.save(stockCountCreationProducts);

		}

		return StockCountCreationCombinedDto;

	}

	@Override
	public StockCountCreationCombinedDto getProductsByDate(LocalDate date, String storeName) {
		StockCountCreation ScCreation = creationRepo.findByDateAndStore(date, storeName);
		System.out.println("local date : " + date);
		StockCountCreationCombinedDto stockCountCreationCombinedDto = new StockCountCreationCombinedDto();
		List<StockCountCreationProductsdto> stockCountCreationProductsdto = new ArrayList<>();
		if (ScCreation.getStatus().equals("pending")) {

			List<StockCountCreationProducts> stockCountCreationProducts = creationProductsRepo
					.findByStockcount(ScCreation);

			StockCountCreationdto stockCountCreationdto = new StockCountCreationdto(ScCreation.getCountId(),
					ScCreation.getCountDescription(), ScCreation.getDate(), ScCreation.getStatus(),
					ScCreation.getTotalBookQty(), ScCreation.getReCount(), ScCreation.getStore());

			stockCountCreationCombinedDto.setCreationdto(stockCountCreationdto);

			for (int i = 0; i < stockCountCreationProducts.size(); i++) {
				Category category = categoryRepo.findByCategory(stockCountCreationProducts.get(i).getCategory());
				String categoryLocation = category.getLocation();
				stockCountCreationProductsdto.add(new StockCountCreationProductsdto(
						stockCountCreationProducts.get(i).getId(), stockCountCreationProducts.get(i).getItemNumber(),
						stockCountCreationProducts.get(i).getItemName(),
						stockCountCreationProducts.get(i).getCategory(), stockCountCreationProducts.get(i).getColor(),
						stockCountCreationProducts.get(i).getPrice(), stockCountCreationProducts.get(i).getSize(),
						stockCountCreationProducts.get(i).getImageData(), stockCountCreationProducts.get(i).getStore(),
						stockCountCreationProducts.get(i).getBookQty(),
						stockCountCreationProducts.get(i).getStockcount().getCountId(),
						stockCountCreationProducts.get(i).getSku(), categoryLocation));
			}

			stockCountCreationCombinedDto.setCreationProductsdto(stockCountCreationProductsdto);
			System.out.println("stockCountCreationProducts : " + stockCountCreationProducts);
		}
		return stockCountCreationCombinedDto;
	}

	@Override
	public List<StockCountCreationProducts> getStockCountProductsByCountId(int id) {
		// System.out.print("id "+id);
		StockCountCreation countObject = creationRepo.findByCountId(id);
		List<StockCountCreationProducts> stockCountProducts = creationProductsRepo.findByStockcount(countObject);
		return stockCountProducts;

	}

}
