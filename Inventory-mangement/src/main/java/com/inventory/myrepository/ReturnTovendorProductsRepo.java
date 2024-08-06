package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.RTVInfo;
import com.inventory.myentity.RTVProducts;

import jakarta.transaction.Transactional;

public interface ReturnTovendorProductsRepo extends JpaRepository<RTVProducts, Integer> {

	List<RTVProducts> findByrtvInfo(RTVInfo RTVInfo);

	@Transactional
	void deleteAllByRtvInfo(RTVInfo rtv);

	// void saveAll(List<ReturnToVendorProcessProducts> rtvProcessProducts);
}
