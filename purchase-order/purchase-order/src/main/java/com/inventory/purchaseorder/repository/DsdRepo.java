package com.inventory.purchaseorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.DSD;

public interface DsdRepo extends JpaRepository<DSD, Integer> {

	DSD findFirstByOrderByDsdNumberDesc();

	DSD findByDsdNumber(int dsdNumber);
}
