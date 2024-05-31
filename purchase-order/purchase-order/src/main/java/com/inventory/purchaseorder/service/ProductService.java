
package com.inventory.purchaseorder.service;

import java.util.List;

import com.inventory.purchaseorder.dto.ProductCombineddto;
import com.inventory.purchaseorder.dto.ProductCombineddtotoAdjustInventory;
import com.inventory.purchaseorder.dto.ProductsByItemNumberdto;
import com.inventory.purchaseorder.dto.StoreAndInTransitInventorydto;
import com.inventory.purchaseorder.dto.categorydto;
import com.inventory.purchaseorder.entity.Product;
import com.inventory.purchaseorder.entity.ProductDetails;

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

	ProductDetails getproducDetailstBySKU(String sku, String store);

	//ProductDetails getproducDetailstByUPC(String upc, String store);

	ProductDetails getproducDetailstByUpc(String upc, String store);
}
