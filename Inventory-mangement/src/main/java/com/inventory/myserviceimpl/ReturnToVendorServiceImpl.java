package com.inventory.myserviceimpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.inventory.mydto.DsdDto;
import com.inventory.mydto.ReturnToVendorCombinedDto;
import com.inventory.mydto.ReturnToVendorInfodto;
import com.inventory.mydto.RtvInfoToGetAllRtv;
import com.inventory.mydto.TsfHeadDtoToGetTransfers;
import com.inventory.myentity.DSD;
import com.inventory.myentity.RTVInfo;
import com.inventory.myentity.RTVProducts;
import com.inventory.myentity.RtvReasonCodes;
import com.inventory.myentity.Stores;
import com.inventory.myentity.Suppliers;
import com.inventory.myexception.ExceptionHandling;
import com.inventory.myrepository.ReturnTovendorInfoRepo;
import com.inventory.myrepository.ReturnTovendorProductsRepo;
import com.inventory.myrepository.RtvReasonCodesRepo;
import com.inventory.myrepository.StoreRepo;
import com.inventory.myrepository.SuppliersRepo;
import com.inventory.myservice.ReturnToVendorService;

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

	// Function to create RTV
//	@Override
//	public ReturnToVendorInfodto createRTV(String storeName, String user) {
//
//		Stores store = storeRepo.findByStoreName(storeName);
//		if (store != null) {
//			String dsdId = generateDsdIdString();
//			LocalDate date = LocalDate.now();
//			DSD dsd = new DSD();
//			dsd.setDsdNumber(dsdId);
//			dsd.setTotalSKU(0);
//			dsd.setStoreLocation(storeName);
//			dsd.setCreationDate(date);
//			dsd.setUser(user);
//			dsd.setStatus("In Progress");
//			dsd = dsdRepo.save(dsd);
//
//			DsdDto dsdDto = new DsdDto(dsd.getDsdNumber(), dsd.getCreationDate(), dsd.getStoreLocation(), dsd.getUser(),
//					dsd.getStatus(), dsd.getTotalSKU(), "DSD");
//			return dsdDto;
//		} else {
//			throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Please add the appropriate store ");
//		}
//
//	}
//
//	// Function to save RTV list
//	@Override
//	public String saveProducts(ReturnToVendorCombinedDto RTVCombinedDto, String Id) {
//
//		RTVInfo RTVInfo = new RTVInfo(Id, RTVCombinedDto.getRtvInfodto().getSupplierId(),
//				RTVCombinedDto.getRtvInfodto().getStoreId(), RTVCombinedDto.getRtvInfodto().getTotalSku(),
//				RTVCombinedDto.getRtvInfodto().getCreatedDate(), RTVCombinedDto.getRtvInfodto().getCreatedBy(),
//				RTVCombinedDto.getRtvInfodto().getStatus(), RTVCombinedDto.getRtvInfodto().getDefaultReasonCode(),
//				RTVCombinedDto.getRtvInfodto().getDispatchedUser(), RTVCombinedDto.getRtvInfodto().getDispatchedDate());
//
//		RTVInfo = rtvInfoRepo.save(RTVInfo);
//
//		List<RTVProducts> rtvProducts = new ArrayList<>();
//		for (int i = 0; i < RTVCombinedDto.getRtvProductsdto().size(); i++) {
//			rtvProducts.add(new RTVProducts(RTVCombinedDto.getRtvProductsdto().get(i).getAttachedImage(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getItemNumber(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getItemName(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getCategory(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getColor(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getCost(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getPrice(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getSize(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getStore(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getReturnQty(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getReturnReason(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getImageData(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getUpc(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getSku(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getTaxPercentage(),
//					RTVCombinedDto.getRtvProductsdto().get(i).getTaxCode(), RTVInfo));
//		}
//
//		rtvProductsRepo.saveAll(rtvProducts);
//		return "Products saved successfully";
//	}

	// Function to get all RTV
	@Override
	public List<RtvInfoToGetAllRtv> getAllVendorReturn() {
		List<RTVInfo> rtvInfo = rtvInfoRepo.findAll();

		List<RtvInfoToGetAllRtv> rtvInfoDto = new ArrayList<>();
		for (int i = 0; i < rtvInfo.size(); i++) {
			rtvInfoDto.add(new RtvInfoToGetAllRtv(rtvInfo.get(i).getRtvID(), rtvInfo.get(i).getStatus(),
					rtvInfo.get(i).getCreatedDate(), "RTV", rtvInfo.get(i).getTotalSku()));
		}
		return rtvInfoDto;
	}

	// Function to get RTV Products by Id
	@Override
	public List<RTVProducts> getRTVProductsbyId(String rtvId) {
		RTVInfo rtv = rtvInfoRepo.findByrtvID(rtvId);
		List<RTVProducts> RTVProcessInfo = rtvProductsRepo.findByrtvInfo(rtv);
		return RTVProcessInfo;
	}

	@Override
	public String dispatchRTV(String rtvId) {
		RTVInfo rtv = rtvInfoRepo.findByrtvID(rtvId);
		rtv.setStatus("Completed");
		rtvInfoRepo.save(rtv);
		return "Item Dispatched";
	}

	@Override
	public List<RtvReasonCodes> getRtvReasonCodes() {
		List<RtvReasonCodes> rtvReasonCodes = rtvReasonCodesRepo.findAll();
		return rtvReasonCodes;
	}

	@Override
	public List<Suppliers> getAllSuppliers() {
		List<Suppliers> suppliers = suppliersRepo.findAll();
		return suppliers;
	}

	@Override
	public List<Suppliers> getMatchedSuppliersBySupplierName(String name) {
		List<Suppliers> suppliers = suppliersRepo.findBySupplierNameContaining(name);
		return suppliers;
	}

	public String generateRandomString() {
		final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		final SecureRandom random = new SecureRandom();

		StringBuilder sb = new StringBuilder(10);
		for (int i = 0; i < 10; i++) {
			sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
		}
		return sb.toString();
	}

	@Override
	public String saveProducts(ReturnToVendorCombinedDto RTVCombinedDto, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DsdDto createRTV(String storeName, String user) {
		// TODO Auto-generated method stub
		return null;
	}

}
