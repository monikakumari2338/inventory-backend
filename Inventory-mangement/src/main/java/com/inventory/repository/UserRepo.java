package com.inventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.auth.jpa.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
	Boolean existsByEmail(String email);
}
