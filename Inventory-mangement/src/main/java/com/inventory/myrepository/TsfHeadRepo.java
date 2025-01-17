package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.rtv.jpa.entity.RTVInfo;
import com.inventory.tsf.jpa.entity.TsfHead;

import java.time.LocalDate;

public interface TsfHeadRepo extends JpaRepository<TsfHead, String> {

	List<TsfHead> findAllByStoreFrom(String storeFrom);

	TsfHead findByTsfId(String tsfId);

	List<TsfHead> findAllByStoreTo(String storeTo);

	List<TsfHead> findByCreationDateBetweenAndStoreTo(LocalDate startDate, LocalDate endDate, String storeTo);

	List<TsfHead> findAllByStoreFromOrderByCreationDateDesc(String store);

	List<TsfHead> findAllByStoreFromOrderByCreationDateAsc(String store);

	List<TsfHead> findByTsfIdContainingAndStoreFrom(String id, String store);

	List<TsfHead> findByReasonCodeOrStatusAndStoreFrom(String param, String param2, String store);

	List<TsfHead> findByReasonCodeOrStatusAndStoreTo(String param, String param2, String store);

	List<TsfHead> findByTsfIdContainingAndStoreTo(String id, String store);

	List<TsfHead> findAllByStoreToOrderByCreationDateAsc(String store);

	List<TsfHead> findAllByStoreToOrderByCreationDateDesc(String store);

	List<TsfHead> findByStoreFromAndReasonCodeOrStatus(String param, String param2, String store);

//	@Query("SELECT e FROM TsfHead e WHERE STR_TO_DATE(SUBSTRING(e.creationDate, 1, 10), '%Y-%m-%d') BETWEEN STR_TO_DATE(:startDate, '%%Y-%m-%d') AND STR_TO_DATE(:endDate, '%Y-%m-%d')")
//	List<TsfHead> findByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
