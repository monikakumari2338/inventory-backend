package com.inventory.myrepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.Category;


public interface CategoryRepo extends JpaRepository<Category, Integer> {

	Category findByCategoryId(int id);
	Category findByCategory(String cate);
	List<Category> findAll();

}