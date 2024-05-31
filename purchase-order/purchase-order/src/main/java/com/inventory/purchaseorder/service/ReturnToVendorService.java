
package com.inventory.purchaseorder.service;

import java.util.List;

import com.inventory.purchaseorder.dto.ReturnToVendorCombinedDto;
import com.inventory.purchaseorder.entity.RTVInfo;
import com.inventory.purchaseorder.entity.RTVProducts;
import com.inventory.purchaseorder.entity.RtvReasonCodes;
import com.inventory.purchaseorder.entity.Suppliers;

public interface ReturnToVendorService {

	String saveProducts(ReturnToVendorCombinedDto RTVCombinedDto, String id);

	List<RTVInfo> getAllVendorReturn();

	List<RTVProducts> getRTVProductsbyId(String rtvId);

	List<RtvReasonCodes> getRtvReasonCodes();

	List<Suppliers> getAllSuppliers();

	String dispatchRTV(String rtvId);

	List<Suppliers> getMatchedSuppliersBySupplierName(String name);

	String generateRandomString();
}
