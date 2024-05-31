
package com.inventory.myservice;

import java.util.List;

import com.inventory.mydto.DsdCombinedDto;
import com.inventory.mydto.DsdItemsGetdto;
import com.inventory.myentity.DSD;

public interface DSDService {

	String saveDsd(DsdCombinedDto dsdCombinedDto);

	List<DSD> getAllDSd();

	List<DsdItemsGetdto> getAllDSdItems(int dsdNumber);

	//List<DsdItemsGetdto> getDamageDSdItems(int dsdNumber);

}
