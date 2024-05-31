package com.inventory.purchaseorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.Stores;

public interface StoreRepo extends JpaRepository<Stores, Integer> {

	Stores findByStoreName(String store);
	Stores findByStoreId(int id);

}
