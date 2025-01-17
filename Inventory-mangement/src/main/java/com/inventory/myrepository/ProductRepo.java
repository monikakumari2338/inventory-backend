package com.inventory.myrepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.po.jpa.entity.PurchaseOrder;
import com.inventory.product.jpa.dto.ProductsByItemNumberdto;
import com.inventory.product.jpa.entity.Category;
import com.inventory.product.jpa.entity.Product;

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