package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.dsd.jpa.entity.DSD;
import com.inventory.dsd.jpa.entity.DsdItems;

import jakarta.transaction.Transactional;

public interface DsdItemsRepo extends JpaRepository<DsdItems, Integer> {

	List<DsdItems> findByDsd(DSD dsd);

	@Transactional
	void deleteAllByDsd(DSD dsd);

	List<DsdItems> findByDsdAndSkuContaining(DSD dsd, String sku);
}
