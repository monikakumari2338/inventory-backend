package com.inventory.myrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.UserIdData;

public interface UserIdDetailsRepo extends JpaRepository<UserIdData, Integer> {

}
