
package com.inventory.purchaseorder.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.purchaseorder.service.SaveStockCountService;

import com.inventory.purchaseorder.dto.SaveStockCountCombinedDto;
import com.inventory.purchaseorder.dto.StockCountOnloadDto;
import com.inventory.purchaseorder.entity.AdhocStockCount;
import com.inventory.purchaseorder.entity.SaveStockCountInfo;
import com.inventory.purchaseorder.entity.SaveStockCountProducts;
import com.inventory.purchaseorder.entity.StockCountCreation;
import com.inventory.purchaseorder.repository.SaveStockProductsRepo;
import com.inventory.purchaseorder.repository.StockCreationRepo;
import com.inventory.purchaseorder.repository.AdhocStockCountRepo;
import com.inventory.purchaseorder.repository.SaveStockInfoRepo;

@Service
public class SaveStockCountServiceImpl implements SaveStockCountService {

	@Autowired
	private SaveStockInfoRepo saveStockInfoRepo;

	@Autowired
	private SaveStockProductsRepo saveStockProductsRepo;

	@Autowired
	private StockCreationRepo creationRepo;

	@Autowired
	private AdhocStockCountRepo adhocStockCountRepo;

	@Override
	public SaveStockCountCombinedDto saveProducts(SaveStockCountCombinedDto saveStockCountCombinedDto) {

		StockCountCreation ScCreation = creationRepo
				.findByCountId(saveStockCountCombinedDto.getSaveStockCountInfo().getCountId());
		System.out.print("status " + ScCreation.getStatus());

		if (!ScCreation.getStatus().equals("complete") || ScCreation.getReCount().equals("pending")) {
			SaveStockCountInfo StockCountInfo = new SaveStockCountInfo(
					saveStockCountCombinedDto.getSaveStockCountInfo().getCountId(),
					saveStockCountCombinedDto.getSaveStockCountInfo().getCountDescription(),
					saveStockCountCombinedDto.getSaveStockCountInfo().getStartedAt(),
					saveStockCountCombinedDto.getSaveStockCountInfo().getCompletedAt(),
					saveStockCountCombinedDto.getSaveStockCountInfo().getStatus(),
					saveStockCountCombinedDto.getSaveStockCountInfo().getTotalBookQty(),
					saveStockCountCombinedDto.getSaveStockCountInfo().getCountedQty(),
					saveStockCountCombinedDto.getSaveStockCountInfo().getVarianceQty(),
					saveStockCountCombinedDto.getSaveStockCountInfo().getRecountVarianceQty(),
					saveStockCountCombinedDto.getSaveStockCountInfo().getReCount(),
					saveStockCountCombinedDto.getSaveStockCountInfo().getReCountQty());

			saveStockInfoRepo.save(StockCountInfo);

			SaveStockCountInfo countObject = saveStockInfoRepo
					.findByCountId(saveStockCountCombinedDto.getSaveStockCountInfo().getCountId());
			for (int i = 0; i < saveStockCountCombinedDto.getSaveStockCountProducts().size(); i++) {
				SaveStockCountProducts StockCountProduct = new SaveStockCountProducts(
						saveStockCountCombinedDto.getSaveStockCountProducts().get(i).getItemNumber(),
						saveStockCountCombinedDto.getSaveStockCountProducts().get(i).getItemName(),
						saveStockCountCombinedDto.getSaveStockCountProducts().get(i).getCategory(),
						saveStockCountCombinedDto.getSaveStockCountProducts().get(i).getColor(),
						saveStockCountCombinedDto.getSaveStockCountProducts().get(i).getPrice(),
						saveStockCountCombinedDto.getSaveStockCountProducts().get(i).getSize(),
						saveStockCountCombinedDto.getSaveStockCountProducts().get(i).getImageData(),
						saveStockCountCombinedDto.getSaveStockCountProducts().get(i).getStore(),
						saveStockCountCombinedDto.getSaveStockCountProducts().get(i).getBookQty(),
						saveStockCountCombinedDto.getSaveStockCountProducts().get(i).getCountedQty(),
						saveStockCountCombinedDto.getSaveStockCountProducts().get(i).getVarianceQty(),
						saveStockCountCombinedDto.getSaveStockCountProducts().get(i).getRecountVarianceQty(),
						saveStockCountCombinedDto.getSaveStockCountProducts().get(i).getReCountQty(),
						saveStockCountCombinedDto.getSaveStockCountProducts().get(i).getSku(), countObject);

				saveStockProductsRepo.save(StockCountProduct);
			}

			ScCreation.setStatus(saveStockCountCombinedDto.getSaveStockCountInfo().getStatus());
			ScCreation.setReCount(saveStockCountCombinedDto.getSaveStockCountInfo().getReCount());
			creationRepo.save(ScCreation);
			System.out.print("inside " + ScCreation.getStatus());
		}
		return saveStockCountCombinedDto;
	}

	@Override
	public SaveStockCountCombinedDto saveRecountProducts(SaveStockCountCombinedDto saveStockCountCombinedDto) {

		StockCountCreation ScCreation = creationRepo
				.findByCountId(saveStockCountCombinedDto.getSaveStockCountInfo().getCountId());

		System.out.println("ScCreation " + ScCreation);
		SaveStockCountInfo saveStockCountInfo = saveStockInfoRepo
				.findByCountId(saveStockCountCombinedDto.getSaveStockCountInfo().getCountId());

		List<SaveStockCountProducts> saveStockCountProductsList = saveStockProductsRepo
				.findByStockcount(saveStockCountInfo);
		if (!ScCreation.getStatus().equals("complete") || ScCreation.getReCount().equals("processing")) {

			System.out.println("length products " + saveStockCountCombinedDto.getSaveStockCountProducts().size());
			for (int j = 0; j < saveStockCountCombinedDto.getSaveStockCountProducts().size(); j++) {
				System.out.println("inside for");
				for (int i = 0; i < saveStockCountProductsList.size(); i++) {
					if (saveStockCountProductsList.get(i).getSku()
							.equals(saveStockCountCombinedDto.getSaveStockCountProducts().get(j).getSku())) {
						saveStockCountProductsList.get(i).setReCountQty(
								saveStockCountCombinedDto.getSaveStockCountProducts().get(j).getReCountQty());
						saveStockCountProductsList.get(i).setRecountVarianceQty(
								saveStockCountCombinedDto.getSaveStockCountProducts().get(j).getRecountVarianceQty());
						saveStockProductsRepo.save(saveStockCountProductsList.get(i));
					}
				}
			}
		}
		System.out.println("saveStockCountCombinedDto " + saveStockCountCombinedDto);
		saveStockCountInfo.setReCount(saveStockCountCombinedDto.getSaveStockCountInfo().getReCount());
		saveStockCountInfo.setStatus(saveStockCountCombinedDto.getSaveStockCountInfo().getStatus());
		saveStockCountInfo
				.setRecountVarianceQty(saveStockCountCombinedDto.getSaveStockCountInfo().getRecountVarianceQty());
		saveStockCountInfo.setReCountQty(saveStockCountCombinedDto.getSaveStockCountInfo().getReCountQty());
		saveStockInfoRepo.save(saveStockCountInfo);

		ScCreation.setStatus(saveStockCountCombinedDto.getSaveStockCountInfo().getStatus());
		ScCreation.setReCount(saveStockCountCombinedDto.getSaveStockCountInfo().getReCount());
		creationRepo.save(ScCreation);
		return saveStockCountCombinedDto;
	}

	@Override
	public StockCountOnloadDto getStockCountInfo() {
		List<StockCountCreation> ScCreation = creationRepo.findByStatus("pending");
		List<SaveStockCountInfo> stockCountInfoList = saveStockInfoRepo.findAll();
		StockCountOnloadDto stockCountOnloadDto = new StockCountOnloadDto();
		stockCountOnloadDto.setPendingList(ScCreation);
		stockCountOnloadDto.setStockCountInfoList(stockCountInfoList);
		return stockCountOnloadDto;
	}

	@Override
	public List<SaveStockCountProducts> getStockCountProductsByCountId(int id) {
		// System.out.print("id "+id);
		SaveStockCountInfo countObject = saveStockInfoRepo.findByCountId(id);
		// System.out.print("countObject "+countObject);
		List<SaveStockCountProducts> stockCountProducts = saveStockProductsRepo.findByStockcount(countObject);
		return stockCountProducts;

	}

	@Override
	public String saveAdhocStockCount(List<AdhocStockCount> adhocStockCount) {

		int Adhoc_id = 5000;
		AdhocStockCount AdhocCount = adhocStockCountRepo.findFirstByOrderByAdhocIdDesc();
		if (AdhocCount == null) {

			for (int i = 0; i < adhocStockCount.size(); i++) {
				AdhocStockCount adhocStock = new AdhocStockCount(Adhoc_id, adhocStockCount.get(i).getBookQty(),
						adhocStockCount.get(i).getFirstcountedQty(), adhocStockCount.get(i).getFirstvarianceQty(),
						adhocStockCount.get(i).getReCountQty(), adhocStockCount.get(i).getRecountVarianceQty(),
						adhocStockCount.get(i).getReCountStatus(), adhocStockCount.get(i).getItemNumber(),
						adhocStockCount.get(i).getItemName(), adhocStockCount.get(i).getCategory(),
						adhocStockCount.get(i).getColor(), adhocStockCount.get(i).getPrice(),
						adhocStockCount.get(i).getSize(), adhocStockCount.get(i).getImageData(),
						adhocStockCount.get(i).getStore(), adhocStockCount.get(i).getReason(),
						adhocStockCount.get(i).getSku());
				adhocStockCountRepo.save(adhocStock);
			}
		} else {
			Adhoc_id = AdhocCount.getAdhocId() + 1;
			System.out.println("AdhocCount :" + AdhocCount.getAdhocId());
			for (int i = 0; i < adhocStockCount.size(); i++) {
				AdhocStockCount adhocStock = new AdhocStockCount(Adhoc_id, adhocStockCount.get(i).getBookQty(),
						adhocStockCount.get(i).getFirstcountedQty(), adhocStockCount.get(i).getFirstvarianceQty(),
						adhocStockCount.get(i).getReCountQty(), adhocStockCount.get(i).getRecountVarianceQty(),
						adhocStockCount.get(i).getReCountStatus(), adhocStockCount.get(i).getItemNumber(),
						adhocStockCount.get(i).getItemName(), adhocStockCount.get(i).getCategory(),
						adhocStockCount.get(i).getColor(), adhocStockCount.get(i).getPrice(),
						adhocStockCount.get(i).getSize(), adhocStockCount.get(i).getImageData(),
						adhocStockCount.get(i).getStore(), adhocStockCount.get(i).getReason(),
						adhocStockCount.get(i).getSku());
				adhocStockCountRepo.save(adhocStock);
			}
		}

		// adhocStockCountRepo.saveAll(adhocStockCount);

		return "Saved";
	}

	@Override
	public String saveRecountAdhocStockCount(List<AdhocStockCount> adhocStockCount) {
		// System.out.print("adhocStockCount : " + adhocStockCount);
		for (int i = 0; i < adhocStockCount.size(); i++) {
			AdhocStockCount adhocProduct = adhocStockCountRepo.findBySkuAndAdhocId(adhocStockCount.get(i).getSku(),
					adhocStockCount.get(i).getAdhocId());
			System.out.print("adhocProduct : " + adhocProduct);
			if (adhocProduct != null) {
				adhocProduct.setReCountQty(adhocStockCount.get(i).getReCountQty());
				adhocProduct.setReCountStatus("complete");
				adhocProduct.setRecountVarianceQty(adhocStockCount.get(i).getRecountVarianceQty());
				adhocStockCountRepo.save(adhocProduct);
			}
		}

		return "Saved";
	}

	@Override
	public List<AdhocStockCount> getAllAdhocStockCount() {

		List<AdhocStockCount> adhocCountsList = adhocStockCountRepo.findAll();
		return adhocCountsList;
	}

	@Override
	public List<AdhocStockCount> getStockCountProductsByAdhocId(int id) {
		List<AdhocStockCount> countObject = adhocStockCountRepo.findByAdhocId(id);
		// System.out.print("countObject "+countObject);

		return countObject;

	}

}
