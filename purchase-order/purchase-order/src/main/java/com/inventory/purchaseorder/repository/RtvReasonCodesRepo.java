package com.inventory.purchaseorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.ReasonCodes;
import com.inventory.purchaseorder.entity.RtvReasonCodes;

public interface RtvReasonCodesRepo extends JpaRepository<RtvReasonCodes, Integer> {

}
