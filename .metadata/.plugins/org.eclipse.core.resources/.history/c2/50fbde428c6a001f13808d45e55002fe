
package com.inventory.myservice;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.inventory.mydto.InventoryAdjustmentCombinedDto;
import com.inventory.mydto.ProductCombineddto;
import com.inventory.mydto.ProductCombineddtotoAdjustInventory;
import com.inventory.mydto.ProductDetailsdto2;
import com.inventory.mydto.ProductsByItemNumberdto;
import com.inventory.mydto.StoreAndInTransitInventorydto;
import com.inventory.mydto.categorydto;
import com.inventory.myentity.Product;
import com.inventory.myentity.ProductDetails;

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
}
