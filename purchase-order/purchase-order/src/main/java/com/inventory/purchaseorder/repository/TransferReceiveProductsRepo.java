//package com.inventory.purchaseorder.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.inventory.purchaseorder.entity.TransferReceiveInfo;
//import com.inventory.purchaseorder.entity.TransferReceiveProducts;
//
//public interface TransferReceiveProductsRepo extends JpaRepository<TransferReceiveProducts, Integer> {
//
//	TransferReceiveProducts findByItemNumberAndColorAndSizeAndStoreAndTransferInfo(String itemNumber, String color,
//			String size, String Store, TransferReceiveInfo transferReceiveInfo);
//	
//	List<TransferReceiveProducts> findBytransferInfo(TransferReceiveInfo transferInfo);
//}
