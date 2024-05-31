package com.inventory.myrepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.SaveStockCountInfo;

public interface SaveStockInfoRepo extends JpaRepository<SaveStockCountInfo, Integer> {

	SaveStockCountInfo findByCountId(int id);

	List<SaveStockCountInfo> findByStatus(String status);
}