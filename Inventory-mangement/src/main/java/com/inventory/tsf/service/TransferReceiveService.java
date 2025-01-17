package com.inventory.tsf.service;

import java.util.List;

import com.inventory.dsd.jpa.dto.DSDLandingDto;
import com.inventory.dsd.jpa.dto.DsdDto;
import com.inventory.tsf.jpa.dto.TSFCombinedDto;
import com.inventory.tsf.jpa.dto.TSFLandingDto;
import com.inventory.tsf.jpa.dto.TsfDetailsDto;
import com.inventory.tsf.jpa.dto.TsfDetailsGetReceivingDto;
import com.inventory.tsf.jpa.dto.TsfDetailsShipmentDto;
import com.inventory.tsf.jpa.dto.TsfDto;
import com.inventory.tsf.jpa.dto.TsfHeadDtoToGetTransfers;
import com.inventory.tsf.jpa.dto.TsfOrderAcceptanceDto;
import com.inventory.tsf.jpa.dto.TsfOrderAcceptanceStoreAndProductsDto;
import com.inventory.tsf.jpa.dto.TsfReceivingItemsAndStoreCombinedDto;
import com.inventory.tsf.jpa.dto.TsfSaveReceivingDto;
import com.inventory.tsf.jpa.dto.TsfShipmentAndStoreCombinedDto;
import com.inventory.tsf.jpa.entity.TsfDetails;
import com.inventory.tsf.jpa.entity.TsfHead;
import com.inventory.tsf.jpa.entity.TsfReasonCodes;

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
