package com.inventory.myrepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.PurchaseOrder;
import com.inventory.myentity.PurchaseOrderItems;

public interface PurchaseOrderItemsRepo extends JpaRepository<PurchaseOrderItems, Integer> {

	PurchaseOrderItems findByitemNumber(String itemNumber);

	List<PurchaseOrderItems> findAllByPurchaseOrder(PurchaseOrder PurchaseOrder);

	PurchaseOrderItems findBySkuAndPurchaseOrder(String sku, PurchaseOrder purchaseOrder);

	List<PurchaseOrderItems> findBySkuContainingAndPurchaseOrder(String sku, PurchaseOrder po);
}