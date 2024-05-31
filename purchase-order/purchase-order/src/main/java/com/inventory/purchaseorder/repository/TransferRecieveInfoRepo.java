//package com.inventory.purchaseorder.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.inventory.purchaseorder.entity.ASN;
//import com.inventory.purchaseorder.entity.TransferReceiveInfo;
//
//public interface TransferRecieveInfoRepo extends JpaRepository<TransferReceiveInfo, String> {
//
//	TransferReceiveInfo findBytransferId(int id);
//
//	List<TransferReceiveInfo> findByAsn(ASN asn);
//
//	List<TransferReceiveInfo> findAll();
//
//	List<TransferReceiveInfo> findAllByStatus(String status);
//
//}
