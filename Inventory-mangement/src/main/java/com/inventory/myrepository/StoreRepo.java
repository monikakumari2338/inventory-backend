package com.inventory.myrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.Stores;

public interface StoreRepo extends JpaRepository<Stores, Integer> {

	Stores findByStoreName(String store);

	Stores findByStoreId(int id);

}
