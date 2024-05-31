package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.ReasonCodes;
import com.inventory.myentity.RtvReasonCodes;

public interface RtvReasonCodesRepo extends JpaRepository<RtvReasonCodes, Integer> {

}
