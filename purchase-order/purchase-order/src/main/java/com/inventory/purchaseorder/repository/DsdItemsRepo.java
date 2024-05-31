package com.inventory.purchaseorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.DSD;
import com.inventory.purchaseorder.entity.DsdItems;

public interface DsdItemsRepo extends JpaRepository<DsdItems, Integer> {

	List<DsdItems> findByDsd(DSD dsd);
}
