
package com.inventory.purchaseorder.service;

import java.util.List;

import com.inventory.purchaseorder.dto.DsdCombinedDto;
import com.inventory.purchaseorder.dto.DsdItemsGetdto;
import com.inventory.purchaseorder.entity.DSD;

public interface DSDService {

	String saveDsd(DsdCombinedDto dsdCombinedDto);

	List<DSD> getAllDSd();

	List<DsdItemsGetdto> getAllDSdItems(int dsdNumber);

	List<DsdItemsGetdto> getDamageDSdItems(int dsdNumber);

}
