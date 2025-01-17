package com.inventory.myrepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.adjustments.jpa.entity.ReasonCodes;

public interface ReasonCodesRepo extends JpaRepository<ReasonCodes, Integer> {

}
