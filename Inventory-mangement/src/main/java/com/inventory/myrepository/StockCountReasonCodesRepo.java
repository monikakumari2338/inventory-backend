package com.inventory.myrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.StockCountReasonCodes;

public interface StockCountReasonCodesRepo extends JpaRepository<StockCountReasonCodes, Integer> {

}
