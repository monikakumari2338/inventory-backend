package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.ASN;
import com.inventory.myentity.PurchaseOrder;

public interface ASNRepo extends JpaRepository<ASN, Integer> {

//	List<ASN> findAllByStatus(String status);
////	ASN findByasnId(int id);
	ASN findByasnNumber(String num);

	List<ASN> findByPurchaseOrder(PurchaseOrder purchaseOrder);
//	List<ASN> findByasnNumberContaining(String num);

}
