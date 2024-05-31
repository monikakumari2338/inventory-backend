package com.inventory.myrepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.RTVInfo;

public interface ReturnTovendorInfoRepo extends JpaRepository<RTVInfo, String> {

	RTVInfo findByrtvID(String rtvId);

	List<RTVInfo> findAll();

}
