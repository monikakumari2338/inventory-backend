package com.inventory.myrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.TsfReasonCodes;

public interface TsfReasonCodesRepo extends JpaRepository<TsfReasonCodes, Integer> {

}
