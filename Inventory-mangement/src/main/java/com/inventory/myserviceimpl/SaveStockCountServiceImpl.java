
package com.inventory.myserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.mydto.AdhocCombinedDto;
import com.inventory.mydto.SaveStockCountCombinedDto;
import com.inventory.mydto.StockCountOnloadDto;
import com.inventory.myentity.AdhocStockCount;
import com.inventory.myentity.AdhocStockCountDetails;
import com.inventory.myentity.SaveStockCountInfo;
import com.inventory.myentity.SaveStockCountProducts;
import com.inventory.myentity.StockCountCreation;
import com.inventory.myrepository.AdhocStockCountDetailsRepo;
import com.inventory.myrepository.AdhocStockCountRepo;
import com.inventory.myrepository.SaveStockInfoRepo;
import com.inventory.myrepository.SaveStockProductsRepo;
import com.inventory.myrepository.StockCreationRepo;
import com.inventory.myservice.SaveStockCountService;

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

	@Autowired
	private AdhocStockCountDetailsRepo adhocDetailsRepo;

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
					saveStockCountCombinedDto.getSaveStockCountInfo().getReCountQty(),
					saveStockCountCombinedDto.getSaveStockCountInfo().getCategory(),
					saveStockCountCombinedDto.getSaveStockCountInfo().getStore());

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
		// System.out.print("id " + id);
		SaveStockCountInfo countObject = saveStockInfoRepo.findByCountId(id);
		System.out.print("countObject " + countObject);
		List<SaveStockCountProducts> stockCountProducts = saveStockProductsRepo.findByStockcount(countObject);
		return stockCountProducts;

	}

	@Override
	public String saveAdhocStockCount(AdhocCombinedDto adhocCombinedDto) {

		int Adhoc_id = 5000;
		AdhocStockCount AdhocCount = adhocStockCountRepo.findFirstByOrderByAdhocIdDesc();

		if (AdhocCount == null) {

			AdhocStockCount adhocStock = new AdhocStockCount(Adhoc_id,
					adhocCombinedDto.getAdhocCountdto().getTotalBookQty(),
					adhocCombinedDto.getAdhocCountdto().getCountedQty(),
					adhocCombinedDto.getAdhocCountdto().getVarianceQty(),
					adhocCombinedDto.getAdhocCountdto().getReCountQty(),
					adhocCombinedDto.getAdhocCountdto().getRecountVarianceQty(),
					adhocCombinedDto.getAdhocCountdto().getReCountStatus(),
					adhocCombinedDto.getAdhocCountdto().getStore(), adhocCombinedDto.getAdhocCountdto().getReason(),
					adhocCombinedDto.getAdhocCountdto().getCategory(),
					adhocCombinedDto.getAdhocCountdto().getCreationDate());

			adhocStock = adhocStockCountRepo.save(adhocStock);

			for (int i = 0; i < adhocCombinedDto.getAdhocCountDetails().size(); i++) {
				AdhocStockCountDetails AdhocStockCountDetails = new AdhocStockCountDetails(
						adhocCombinedDto.getAdhocCountDetails().get(i).getBookQty(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getFirstcountedQty(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getFirstvarianceQty(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getReCountQty(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getRecountVarianceQty(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getReCountStatus(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getItemNumber(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getItemName(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getColor(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getPrice(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getSize(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getImageData(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getSku(), adhocStock);
				adhocDetailsRepo.save(AdhocStockCountDetails);
			}
		} else

		{
			Adhoc_id = AdhocCount.getAdhocId() + 1;
			System.out.println("AdhocCount :" + AdhocCount.getAdhocId());
			AdhocStockCount adhocStock = new AdhocStockCount(Adhoc_id,
					adhocCombinedDto.getAdhocCountdto().getTotalBookQty(),
					adhocCombinedDto.getAdhocCountdto().getCountedQty(),
					adhocCombinedDto.getAdhocCountdto().getVarianceQty(),
					adhocCombinedDto.getAdhocCountdto().getReCountQty(),
					adhocCombinedDto.getAdhocCountdto().getRecountVarianceQty(),
					adhocCombinedDto.getAdhocCountdto().getReCountStatus(),
					adhocCombinedDto.getAdhocCountdto().getStore(), adhocCombinedDto.getAdhocCountdto().getReason(),
					adhocCombinedDto.getAdhocCountdto().getCategory(),
					adhocCombinedDto.getAdhocCountdto().getCreationDate());

			adhocStock = adhocStockCountRepo.save(adhocStock);

			for (int i = 0; i < adhocCombinedDto.getAdhocCountDetails().size(); i++) {
				AdhocStockCountDetails AdhocStockCountDetails = new AdhocStockCountDetails(
						adhocCombinedDto.getAdhocCountDetails().get(i).getBookQty(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getFirstcountedQty(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getFirstvarianceQty(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getReCountQty(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getRecountVarianceQty(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getReCountStatus(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getItemNumber(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getItemName(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getColor(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getPrice(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getSize(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getImageData(),
						adhocCombinedDto.getAdhocCountDetails().get(i).getSku(), adhocStock);
				adhocDetailsRepo.save(AdhocStockCountDetails);
			}
		}

		// adhocStockCountRepo.saveAll(adhocStockCount);

		return "Saved";
	}

	@Override
	public String saveRecountAdhocStockCount(List<AdhocStockCount> adhocStockCount) {
		// System.out.print("adhocStockCount : " + adhocStockCount);
//		for (int i = 0; i < adhocStockCount.size(); i++) {
//			AdhocStockCount adhocProduct = adhocStockCountRepo.findBySkuAndAdhocId(adhocStockCount.get(i).getSku(),
//					adhocStockCount.get(i).getAdhocId());
//			System.out.print("adhocProduct : " + adhocProduct);
//			if (adhocProduct != null) {
//				adhocProduct.setReCountQty(adhocStockCount.get(i).getReCountQty());
//				adhocProduct.setReCountStatus("complete");
//				adhocProduct.setRecountVarianceQty(adhocStockCount.get(i).getRecountVarianceQty());
//				adhocStockCountRepo.save(adhocProduct);
//			}
//		}

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
