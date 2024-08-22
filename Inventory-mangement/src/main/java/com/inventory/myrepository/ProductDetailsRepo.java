package com.inventory.myrepository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.myentity.Product;
import com.inventory.myentity.ProductDetails;
import com.inventory.myentity.Stores;

public interface ProductDetailsRepo extends JpaRepository<ProductDetails, Integer> {

	ProductDetails findByColorAndSizeAndStoreAndProduct(String color, String size, Stores stores, Product Product);

	List<ProductDetails> findAllByProduct(Product Product);

	List<ProductDetails> findByProductAndColorAndSize(Product Product, String color, String size);

	List<ProductDetails> findByProductAndStore(Product Product, Stores store);

	ProductDetails findByUpc(String upc);

	ProductDetails findBySku(String sku);

	ProductDetails findByUpcAndStore(String upc, Stores store);

	ProductDetails findBySkuAndStore(String sku, Stores store);

	List<ProductDetails> findAllByStore(Stores store);

	List<ProductDetails> findBySkuContaining(String sku);

	List<ProductDetails> findAllBySku(String sku);

	@Query(nativeQuery = true, value = "SELECT product_details.* FROM product_details INNER JOIN products_db ON products_db.item_number = product_details.item_number WHERE products_db.item_number=:item_number ")
	List<ProductDetails> findAllProductDetailsByitemNumber(@Param("item_number") String item_number);

	List<ProductDetails> findBySkuContainingAndStore(String sku, Stores store);

	List<ProductDetails> findAllBySkuAndStoreNot(String sku, Stores store1);

	@Query("SELECT DISTINCT pd.size, pd.color FROM ProductDetails pd WHERE pd.product.itemNumber = :itemNumber")
	List<Object[]> findDistinctSizesAndColorsByItemNumber(@Param("itemNumber") String itemNumber);
}