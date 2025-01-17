package com.inventory.myrepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.rtv.jpa.entity.RTVInfo;

import jakarta.transaction.Transactional;

public interface ReturnTovendorInfoRepo extends JpaRepository<RTVInfo, String> {

	RTVInfo findByrtvID(String rtvId);

	List<RTVInfo> findAll();

	List<RTVInfo> findAllByOrderByCreationDateDesc();

	List<RTVInfo> findAllByOrderByCreationDateAsc();

	List<RTVInfo> findByRtvIDContaining(String id);

	List<RTVInfo> findByDefaultReasonCodeOrStatus(String param, String param2);

	RTVInfo findByRtvID(String id);

	@Transactional
	void deleteByRtvID(String id);

	List<RTVInfo> findByCreationDateBetweenAndStoreId(LocalDate pastDateInLocalDate, LocalDate currentDateInLocalDate,
			int storeId);

}
