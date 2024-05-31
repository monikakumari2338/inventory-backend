package com.inventory.purchaseorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.RTVInfo;

public interface ReturnTovendorInfoRepo extends JpaRepository<RTVInfo, String> {

	RTVInfo findByrtvID(String rtvId);

	List<RTVInfo> findAll();

}
