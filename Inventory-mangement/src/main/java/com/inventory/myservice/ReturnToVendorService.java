
package com.inventory.myservice;

import java.util.List;

import com.inventory.mydto.ReturnToVendorCombinedDto;
import com.inventory.mydto.RtvInfoToGetAllRtv;
import com.inventory.myentity.RTVInfo;
import com.inventory.myentity.RTVProducts;
import com.inventory.myentity.RtvReasonCodes;
import com.inventory.myentity.Suppliers;

public interface ReturnToVendorService {

	String saveProducts(ReturnToVendorCombinedDto RTVCombinedDto, String id);

	List<RtvInfoToGetAllRtv> getAllVendorReturn();

	List<RTVProducts> getRTVProductsbyId(String rtvId);

	List<RtvReasonCodes> getRtvReasonCodes();

	List<Suppliers> getAllSuppliers();

	String dispatchRTV(String rtvId);

	List<Suppliers> getMatchedSuppliersBySupplierName(String name);

	String generateRandomString();
}
