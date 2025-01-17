package com.inventory.myrepository;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.dsd.jpa.entity.DSD;
import com.inventory.sc.jpa.entity.StockCountCreation;
import com.inventory.tsf.jpa.entity.TsfHead;

public interface StockCreationRepo extends JpaRepository<StockCountCreation, String> {

	StockCountCreation findByCountId(String id);
//
//	StockCountCreation findByDate(LocalDate date);
//
//	List<StockCountCreation> findByStatus(String status);
//
//	StockCountCreation findByDateAndStore(LocalDate date, String storeName);
//
//	List<StockCountCreation> findByDateBetweenAndStore(LocalDate startDate, LocalDate endDate, String store);

	List<StockCountCreation> findAllByOrderByStartDateDesc();

	List<StockCountCreation> findAllByOrderByStartDateAsc();

	List<StockCountCreation> findByReasonOrStatus(String param, String param2);

	List<StockCountCreation> findByCountIdContaining(String countId);

	List<StockCountCreation> findByCreationDateBetweenAndStore(LocalDate pastDateInLocalDate,
			LocalDate currentDateInLocalDate, String storeName);

	// List<StockCountCreation> findByCreationDateBetween(LocalDate
	// pastDateInLocalDate, LocalDate currentDateInLocalDate);

	List<StockCountCreation> findByStatusAndCreationDateBetween(String status, LocalDate pastDateInLocalDate,
			LocalDate currentDateInLocalDate);
}