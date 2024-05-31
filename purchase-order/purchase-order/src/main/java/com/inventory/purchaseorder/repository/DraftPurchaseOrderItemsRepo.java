package com.inventory.purchaseorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.DraftPurchaseOrderItems;

public interface DraftPurchaseOrderItemsRepo extends JpaRepository<DraftPurchaseOrderItems, Integer> {

	List<DraftPurchaseOrderItems> findByAsnNumberOrPoNumber(int asn, int po);
}
