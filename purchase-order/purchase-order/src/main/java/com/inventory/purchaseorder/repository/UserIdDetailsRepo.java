package com.inventory.purchaseorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.UserIdData;

public interface UserIdDetailsRepo extends JpaRepository<UserIdData, Integer> {

}
