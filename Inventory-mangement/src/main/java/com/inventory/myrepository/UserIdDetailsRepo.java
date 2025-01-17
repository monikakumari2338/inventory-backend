package com.inventory.myrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.email.jpa.entity.UserIdData;

public interface UserIdDetailsRepo extends JpaRepository<UserIdData, Integer> {

}
