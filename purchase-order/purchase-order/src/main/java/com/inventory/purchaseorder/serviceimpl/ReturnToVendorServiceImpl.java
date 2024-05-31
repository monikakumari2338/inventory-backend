package com.inventory.purchaseorder.serviceimpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inventory.purchaseorder.dto.ReturnToVendorCombinedDto;

import com.inventory.purchaseorder.entity.RtvReasonCodes;
import com.inventory.purchaseorder.entity.Suppliers;
import com.inventory.purchaseorder.entity.RTVInfo;
import com.inventory.purchaseorder.entity.RTVProducts;
import com.inventory.purchaseorder.repository.ReturnTovendorInfoRepo;
import com.inventory.purchaseorder.service.ReturnToVendorService;
import com.inventory.purchaseorder.repository.ReturnTovendorProductsRepo;
import com.inventory.purchaseorder.repository.RtvReasonCodesRepo;
import com.inventory.purchaseorder.repository.SuppliersRepo;
import java.security.SecureRandom;

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

	// Function to save RTV list
	@Override
	public String saveProducts(ReturnToVendorCombinedDto RTVCombinedDto, String Id) {

		RTVInfo RTVInfo = new RTVInfo(Id, RTVCombinedDto.getRtvInfodto().getSupplierId(),
				RTVCombinedDto.getRtvInfodto().getStoreId(), RTVCombinedDto.getRtvInfodto().getTotalSku(),
				RTVCombinedDto.getRtvInfodto().getCreatedDate(), RTVCombinedDto.getRtvInfodto().getCreatedBy(),
				RTVCombinedDto.getRtvInfodto().getStatus(), RTVCombinedDto.getRtvInfodto().getDefaultReasonCode(),
				RTVCombinedDto.getRtvInfodto().getDispatchedUser(), RTVCombinedDto.getRtvInfodto().getDispatchedDate());

		RTVInfo = rtvInfoRepo.save(RTVInfo);

		List<RTVProducts> rtvProducts = new ArrayList<>();
		for (int i = 0; i < RTVCombinedDto.getRtvProductsdto().size(); i++) {
			rtvProducts.add(new RTVProducts(RTVCombinedDto.getRtvProductsdto().get(i).getAttachedImage(),
					RTVCombinedDto.getRtvProductsdto().get(i).getItemNumber(),
					RTVCombinedDto.getRtvProductsdto().get(i).getItemName(),
					RTVCombinedDto.getRtvProductsdto().get(i).getCategory(),
					RTVCombinedDto.getRtvProductsdto().get(i).getColor(),
					RTVCombinedDto.getRtvProductsdto().get(i).getCost(),
					RTVCombinedDto.getRtvProductsdto().get(i).getPrice(),
					RTVCombinedDto.getRtvProductsdto().get(i).getSize(),
					RTVCombinedDto.getRtvProductsdto().get(i).getStore(),
					RTVCombinedDto.getRtvProductsdto().get(i).getReturnQty(),
					RTVCombinedDto.getRtvProductsdto().get(i).getReturnReason(),
					RTVCombinedDto.getRtvProductsdto().get(i).getImageData(),
					RTVCombinedDto.getRtvProductsdto().get(i).getUpc(),
					RTVCombinedDto.getRtvProductsdto().get(i).getSku(),
					RTVCombinedDto.getRtvProductsdto().get(i).getTaxPercentage(),
					RTVCombinedDto.getRtvProductsdto().get(i).getTaxCode(), RTVInfo));
		}

		rtvProductsRepo.saveAll(rtvProducts);
		return "Products saved successfully";
	}

	// Function to get all RTV
	@Override
	public List<RTVInfo> getAllVendorReturn() {
		List<RTVInfo> RTVProcessInfo = rtvInfoRepo.findAll();
		return RTVProcessInfo;
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

}
