package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.TsfDetails;
import com.inventory.myentity.TsfHead;

public interface TsfDetailsRepo extends JpaRepository<TsfDetails, Integer> {

	List<TsfDetails> findByTsfHead(TsfHead tsf);

	TsfDetails findByTsfHeadAndSku(TsfHead tsf, String sku);
}
