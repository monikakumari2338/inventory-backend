package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.myentity.SaveStockCountInfo;

public interface SaveStockInfoRepo extends JpaRepository<SaveStockCountInfo, Integer> {

	SaveStockCountInfo findByCountId(int id);

	List<SaveStockCountInfo> findByStatus(String status);

	@Query("SELECT e FROM SaveStockCountInfo e WHERE SUBSTRING(e.completedAt,1,10) = :date")
	List<SaveStockCountInfo> findByDate(@Param("date") String date);

	@Query("SELECT e FROM SaveStockCountInfo e WHERE STR_TO_DATE(SUBSTRING(e.completedAt, 1, 10), '%d-%m-%Y') BETWEEN STR_TO_DATE(:startDate, '%d-%m-%Y') AND STR_TO_DATE(:endDate, '%d-%m-%Y')")
	List<SaveStockCountInfo> findByDateRange(@Param("startDate") String startDate,
			@Param("endDate") String endDate);
}