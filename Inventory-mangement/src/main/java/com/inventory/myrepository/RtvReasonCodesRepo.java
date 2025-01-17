package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.adjustments.jpa.entity.ReasonCodes;
import com.inventory.rtv.jpa.entity.RtvReasonCodes;

public interface RtvReasonCodesRepo extends JpaRepository<RtvReasonCodes, Integer> {

}
