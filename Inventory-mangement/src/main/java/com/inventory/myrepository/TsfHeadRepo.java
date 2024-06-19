package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.myentity.TsfHead;
import java.time.LocalDate;

public interface TsfHeadRepo extends JpaRepository<TsfHead, String> {

	List<TsfHead> findAllByStoreFrom(String storeFrom);

	TsfHead findByTsfId(String tsfId);

	List<TsfHead> findAllByStoreTo(String storeTo);

	List<TsfHead> findByCreationDateBetweenAndStoreTo(LocalDate startDate, LocalDate endDate, String storeTo);

//	@Query("SELECT e FROM TsfHead e WHERE STR_TO_DATE(SUBSTRING(e.creationDate, 1, 10), '%Y-%m-%d') BETWEEN STR_TO_DATE(:startDate, '%%Y-%m-%d') AND STR_TO_DATE(:endDate, '%Y-%m-%d')")
//	List<TsfHead> findByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
