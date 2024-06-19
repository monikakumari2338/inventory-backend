package com.inventory.myrepository;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.StockCountCreation;

public interface StockCreationRepo extends JpaRepository<StockCountCreation, Integer> {

	StockCountCreation findByCountId(int id);
	StockCountCreation findByDate(LocalDate date);
	List<StockCountCreation> findByStatus(String status);
	StockCountCreation findByDateAndStore(LocalDate date, String storeName);
}