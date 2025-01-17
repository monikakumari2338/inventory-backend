package com.inventory.myrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.tsf.jpa.entity.TsfReasonCodes;

public interface TsfReasonCodesRepo extends JpaRepository<TsfReasonCodes, Integer> {

}
