package com.inventory.myrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.sc.jpa.entity.StockCountReasonCodes;

public interface StockCountReasonCodesRepo extends JpaRepository<StockCountReasonCodes, Integer> {

}
