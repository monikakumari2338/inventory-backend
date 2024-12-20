package com.inventory.myservice;

import java.util.List;

import com.inventory.mydto.DSDLandingDto;
import com.inventory.mydto.DsdDto;
import com.inventory.mydto.TSFCombinedDto;
import com.inventory.mydto.TSFLandingDto;
import com.inventory.mydto.TsfDetailsDto;
import com.inventory.mydto.TsfDetailsGetReceivingDto;
import com.inventory.mydto.TsfDetailsShipmentDto;
import com.inventory.mydto.TsfDto;
import com.inventory.mydto.TsfHeadDtoToGetTransfers;
import com.inventory.mydto.TsfOrderAcceptanceDto;
import com.inventory.mydto.TsfOrderAcceptanceStoreAndProductsDto;
import com.inventory.mydto.TsfReceivingItemsAndStoreCombinedDto;
import com.inventory.mydto.TsfSaveReceivingDto;
import com.inventory.mydto.TsfShipmentAndStoreCombinedDto;
import com.inventory.myentity.TsfDetails;
import com.inventory.myentity.TsfHead;
import com.inventory.myentity.TsfReasonCodes;

public interface TransferReceiveService {

	List<String> getTsfReasonCodes();

	String generateTsfId();

	List<TsfHeadDtoToGetTransfers> getInTransfers(String store);

	List<TsfHeadDtoToGetTransfers> getOutTransfers(String store);

	TsfOrderAcceptanceStoreAndProductsDto getTsfProductsById(String TsfId);

	String updateTsfHeadandTsfDetails(TsfOrderAcceptanceDto tsfOrderAcceptanceDto);

	TsfShipmentAndStoreCombinedDto getTsfProductsByIdForShipment(String TsfId);

	TsfReceivingItemsAndStoreCombinedDto getTsfToReceive(String tsfId);

	String SaveTSF(TsfSaveReceivingDto tsfSaveReceivingDto);

	String ShipTsf(TsfOrderAcceptanceDto tsfOrderAcceptanceDto, String store);

	TsfDto createTransfer(String storeFrom, String user, String storeTo);

	String saveTansfer(TSFCombinedDto tsfCombinedDto);

	List<TSFLandingDto> sortInTsfByLatest(String store);

	List<TSFLandingDto> sortInTsfByOldest(String store);

	List<TSFLandingDto> getMatchedInTransfersByid(String id, String store);

	List<TSFLandingDto> filtersInTsfByReasonOrStatus(String param, String store);

	List<TSFLandingDto> sortOutTsfByLatest(String store);

	List<TSFLandingDto> sortOutTsfByOldest(String store);

	List<TSFLandingDto> getMatchedOutTransfersByid(String id, String store);

	List<TSFLandingDto> filtersOutTsfByReasonOrStatus(String param, String store);

}
