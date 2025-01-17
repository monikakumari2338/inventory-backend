package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.po.jpa.entity.DraftPurchaseOrderItems;

public interface DraftPurchaseOrderItemsRepo extends JpaRepository<DraftPurchaseOrderItems, Integer> {

	// List<DraftPurchaseOrderItems> findByAsnNumberOrPoNumber(String asn, String
	// po);

	List<DraftPurchaseOrderItems> findByAsnNumber(String number);
}
