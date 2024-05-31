package com.inventory.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.entity.Role;


public interface RoleRepo extends JpaRepository<Role, Integer>{

	Optional<Role> findByName(String name);

}
