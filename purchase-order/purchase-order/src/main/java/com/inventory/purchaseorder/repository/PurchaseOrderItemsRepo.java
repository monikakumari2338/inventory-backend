package com.inventory.purchaseorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.PurchaseOrder;
import com.inventory.purchaseorder.entity.PurchaseOrderItems;

public interface PurchaseOrderItemsRepo extends JpaRepository<PurchaseOrderItems, Integer> {

	PurchaseOrderItems findByitemNumber(String itemNumber);

	List<PurchaseOrderItems> findAllByPurchaseOrder(PurchaseOrder PurchaseOrder);

	PurchaseOrderItems findBySkuAndPurchaseOrder(String sku, PurchaseOrder purchaseOrder);
}