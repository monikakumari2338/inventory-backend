//
//package com.inventory.purchaseorder.service;
//
//import java.util.List;
//import java.util.Set;
//
//import com.inventory.purchaseorder.dto.ProductCombineddto;
//import com.inventory.purchaseorder.dto.TransferReceiveInfodto;
//import com.inventory.purchaseorder.dto.TransferReceiveProductsdto;
//import com.inventory.purchaseorder.entity.TransferReceiveInfo;
//
//public interface TransferReceiveService {
//
//	String save_transferInfo(TransferReceiveInfodto transferReceiveInfo);
//
//	TransferReceiveProductsdto saveTransferReceive(TransferReceiveProductsdto transferReceiveProductsdto);
//
//	List<ProductCombineddto> saveTransferRecieveProducts(List<ProductCombineddto> productCombineddto, int transferId);
//
//	List<TransferReceiveInfodto> getTransferId(String asnNumber);
//
//	List<TransferReceiveProductsdto> getTransferReceiveProducts(int transferId);
//
//	List<TransferReceiveInfo> getAllTransferReceive();
//
//	Set<String> getAllAsnIdFromTransferReceive();
//}
