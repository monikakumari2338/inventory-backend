package com.inventory.purchaseorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.purchaseorder.dto.ProductsByItemNumberdto;
import com.inventory.purchaseorder.entity.Product;
import com.inventory.purchaseorder.entity.PurchaseOrder;
import com.inventory.purchaseorder.entity.Category;

public interface ProductRepo extends JpaRepository<Product, String> {

	// Product findByitemNumber(String itemNumber);

	Product findByItemNumber(String itemNumber);
	Product findByItemName(String itemName);
	List<Product> findByItemNumberContaining(String itemNumber);
	List<Product> findByItemNameContaining(String name);
	void save(PurchaseOrder purchaseOrder);

	@Query(nativeQuery = true, value = "SELECT products_db.* FROM products_db INNER JOIN Category ON products_db.category_id = Category.category_id WHERE Category.category_id=:category_id ")
	List<Product> findAllProductByCategory_id(@Param("category_id") int category_id);

}