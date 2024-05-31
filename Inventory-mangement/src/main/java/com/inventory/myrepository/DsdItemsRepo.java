package com.inventory.myrepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.DSD;
import com.inventory.myentity.DsdItems;

public interface DsdItemsRepo extends JpaRepository<DsdItems, Integer> {

	List<DsdItems> findByDsd(DSD dsd);
}
