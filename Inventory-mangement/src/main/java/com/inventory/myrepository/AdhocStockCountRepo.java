package com.inventory.myrepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.myentity.AdhocStockCount;
import com.inventory.myentity.TsfHead;

public interface AdhocStockCountRepo extends JpaRepository<AdhocStockCount, String> {

	List<AdhocStockCount> findAll();

	List<AdhocStockCount> findByAdhocId(int id);

//	AdhocStockCount findBySkuAndAdhocId(String sku, int id);

	AdhocStockCount findFirstByOrderByAdhocIdDesc();

	List<AdhocStockCount> findByCreationDateBetween(LocalDate startDate, LocalDate endDate);

//	@Query("SELECT e FROM AdhocStockCount e WHERE STR_TO_DATE(SUBSTRING(e.creationDate, 1, 10), '%d-%m-%Y') BETWEEN STR_TO_DATE(:startDate, '%d-%m-%Y') AND STR_TO_DATE(:endDate, '%d-%m-%Y')")
//	List<AdhocStockCount> findByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
