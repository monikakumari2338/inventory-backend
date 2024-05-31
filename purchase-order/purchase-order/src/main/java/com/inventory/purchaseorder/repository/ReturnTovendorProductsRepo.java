package com.inventory.purchaseorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.purchaseorder.entity.RTVInfo;
import com.inventory.purchaseorder.entity.RTVProducts;

public interface ReturnTovendorProductsRepo extends JpaRepository<RTVProducts, Integer> {

	List<RTVProducts> findByrtvInfo(RTVInfo RTVInfo);

	// void saveAll(List<ReturnToVendorProcessProducts> rtvProcessProducts);
}
