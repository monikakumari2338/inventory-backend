
package com.inventory.product.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.inventory.adjustments.jpa.dto.InventoryAdjustmentCombinedDto;
import com.inventory.dashboard.jpa.dto.StoreAndInTransitInventorydto;
import com.inventory.product.jpa.dto.ProductCombineddto;
import com.inventory.product.jpa.dto.ProductCombineddtotoAdjustInventory;
import com.inventory.product.jpa.dto.ProductDetailsdto2;
import com.inventory.product.jpa.dto.ProductsByItemNumberdto;
import com.inventory.product.jpa.dto.categorydto;
import com.inventory.product.jpa.entity.Product;
import com.inventory.product.jpa.entity.ProductDetails;

public interface ProductService {

	List<ProductCombineddto> saveProducts(List<ProductCombineddto> productCombineddto);

	List<categorydto> getCategoryStock();

	public StoreAndInTransitInventorydto getInventory();

	List<String> getAllCategories();

	ProductCombineddtotoAdjustInventory adjustInventoryquantity(ProductCombineddtotoAdjustInventory productCombineddto);

	ProductsByItemNumberdto getByItemnumber(String item_number, String store);

	// List<Product> getMatchedProductsByItemNumber(String item_number, String
	// storename);

	List<ProductDetails> getMatchedProductsByItemNumber(String item_number);

	ProductsByItemNumberdto getByItemName(String item_number, String storeName);

	List<ProductDetails> getMatchedProductsByItemName(String name);

	List<ProductDetails> getproductListByCategory(int categoryId, String store);

	InventoryAdjustmentCombinedDto getproducDetailstBySKU(String sku, String store);

	// ProductDetails getproducDetailstByUPC(String upc, String store);

	ProductDetails getproducDetailstByUpc(String upc, String store);

	InventoryAdjustmentCombinedDto getMatchedproductsBySku(String sku, String storeName, String type);

	ProductDetailsdto2 getproducDetailstByVariants(String size, String color, String itemNumber, String store);

	Map<String, Set<String>> getVariants(String itemNumber);

	InventoryAdjustmentCombinedDto getCategorySpecificMatchedProductsBySku(String sku, String storeName,
			String category);
}
