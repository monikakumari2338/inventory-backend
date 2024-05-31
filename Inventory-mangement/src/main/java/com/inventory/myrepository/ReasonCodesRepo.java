package com.inventory.myrepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.ReasonCodes;

public interface ReasonCodesRepo extends JpaRepository<ReasonCodes, Integer> {

}
