package com.inventory.myrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.DSD;

public interface DsdRepo extends JpaRepository<DSD, Integer> {

	DSD findFirstByOrderByDsdNumberDesc();

	DSD findByDsdNumber(int dsdNumber);
}
