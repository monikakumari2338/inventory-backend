package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.TsfHead;

public interface TsfHeadRepo extends JpaRepository<TsfHead, String> {

	List<TsfHead> findAllByStoreFrom(String storeFrom);

	TsfHead findByTsfId(String tsfId);

	List<TsfHead> findAllByStoreTo(String storeTo);
}
