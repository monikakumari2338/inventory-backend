package com.inventory.product.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.adjustments.jpa.dto.InventoryAdjustmentCombinedDto;
import com.inventory.adjustments.jpa.entity.InventoryAdjustment;
import com.inventory.dashboard.jpa.dto.StoreAndInTransitInventorydto;
import com.inventory.product.jpa.dto.ProductCombineddto;
import com.inventory.product.jpa.dto.ProductCombineddtotoAdjustInventory;
import com.inventory.product.jpa.dto.ProductDetailsdto;
import com.inventory.product.jpa.dto.ProductDetailsdto2;
import com.inventory.product.jpa.dto.Productdto;
import com.inventory.product.jpa.dto.ProductsByItemNumberdto;
import com.inventory.product.jpa.dto.categorydto;
import com.inventory.product.jpa.entity.Product;
import com.inventory.product.jpa.entity.ProductDetails;
import com.inventory.product.service.ProductService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/product")
@SecurityRequirement(name = "bearerAuth")
public class ProductController {

	@Autowired
	private ProductService productService;

	// Api to save data in Master product table
	@PostMapping("/addproducts")
	public ResponseEntity<List<ProductCombineddto>> add_Products(
			@RequestBody List<ProductCombineddto> productCombineddto) {
		List<ProductCombineddto> productCombineddto1 = productService.saveProducts(productCombineddto);
		return new ResponseEntity<>(productCombineddto1, HttpStatus.OK);
	}

	@GetMapping("/getProductByitemNumber/{itemNumber}/{storeName}")
	public ResponseEntity<ProductsByItemNumberdto> getProductByitemNumber(@PathVariable String itemNumber,
			@PathVariable String storeName) {
		ProductsByItemNumberdto productDto = productService.getByItemnumber(itemNumber, storeName);
		return new ResponseEntity<>(productDto, HttpStatus.OK);
	}

	@GetMapping("/getProductByitemName/{itemName}/{storeName}")
	public ResponseEntity<ProductsByItemNumberdto> getProductByitemName(@PathVariable String itemName,
			@PathVariable String storeName) {
		ProductsByItemNumberdto productDto = productService.getByItemName(itemName, storeName);
		return new ResponseEntity<>(productDto, HttpStatus.OK);
	}

	@GetMapping("/dashboard/getinventory")
	public ResponseEntity<List<categorydto>> getInventory() {
		List<categorydto> categorydto = productService.getCategoryStock();
		return new ResponseEntity<>(categorydto, HttpStatus.OK);
	}

	@GetMapping("/dashboard/storeandtransit/getinventory")
	public ResponseEntity<StoreAndInTransitInventorydto> getStoreIntransitInventory() {
		StoreAndInTransitInventorydto storeAndInTransitInventorydto = productService.getInventory();
		return new ResponseEntity<>(storeAndInTransitInventorydto, HttpStatus.OK);
	}

	@GetMapping("/getMatched/products/itemnumber/{itemnumber}")
	public ResponseEntity<List<ProductDetails>> getMatchedItemNumber(@PathVariable String itemnumber) {
		List<ProductDetails> Products = productService.getMatchedProductsByItemNumber(itemnumber);
		return new ResponseEntity<>(Products, HttpStatus.OK);
	}

	@GetMapping("/getMatched/products/Itemname/{Itemname}")
	public ResponseEntity<List<ProductDetails>> getMatchedItemName(@PathVariable String Itemname) {
		List<ProductDetails> Products = productService.getMatchedProductsByItemName(Itemname);
		return new ResponseEntity<>(Products, HttpStatus.OK);
	}

	@GetMapping("/getMatched/sku/{sku}/{store}/{type}")
	public ResponseEntity<InventoryAdjustmentCombinedDto> getMatchedSkuList(@PathVariable String sku,
			@PathVariable String store, @PathVariable String type) {
		InventoryAdjustmentCombinedDto ProductList = productService.getMatchedproductsBySku(sku, store, type);
		return new ResponseEntity<>(ProductList, HttpStatus.OK);
	}

	@GetMapping("/getMatched/sku/byCategory/{sku}/{store}/{category}")
	public ResponseEntity<InventoryAdjustmentCombinedDto> getMatchedSkuListByCategory(@PathVariable String sku,
			@PathVariable String store, @PathVariable String category) {
		InventoryAdjustmentCombinedDto ProductList = productService.getCategorySpecificMatchedProductsBySku(sku, store,
				category);
		return new ResponseEntity<>(ProductList, HttpStatus.OK);
	}

	@GetMapping("/getall/categories")
	public ResponseEntity<List<String>> getAllCategory() {
		List<String> categories = productService.getAllCategories();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@GetMapping("/getall/productbycategory/{categoryid}/{store}")
	public ResponseEntity<List<ProductDetails>> getProductsByCategory(@PathVariable int categoryid,
			@PathVariable String store) {
		List<ProductDetails> ProductDetails_list = productService.getproductListByCategory(categoryid, store);
		return new ResponseEntity<>(ProductDetails_list, HttpStatus.OK);
	}

	@PostMapping("/update/inventory/adjustment")
	public ResponseEntity<ProductCombineddtotoAdjustInventory> inventoryAdjustment(
			@RequestBody ProductCombineddtotoAdjustInventory productCombineddto) {
		ProductCombineddtotoAdjustInventory productCombineddto1 = productService
				.adjustInventoryquantity(productCombineddto);
		return new ResponseEntity<>(productCombineddto1, HttpStatus.OK);
	}

//	@GetMapping("/upc/{upc}/{store}")
//	public ResponseEntity<ProductDetails> getProductByUPC(@PathVariable String upc, @PathVariable String store) {
//		ProductDetails Product = productService.getproducDetailstByUpc(upc, store);
//		return new ResponseEntity<>(Product, HttpStatus.OK);
//	}

	@GetMapping("/upcs/{upc}/{store}")
	public ResponseEntity<ProductDetails> getProduct(@PathVariable String upc, @PathVariable String store) {
		ProductDetails product = productService.getproducDetailstByUpc(upc, store);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("/findbysku/{sku}/{store}")
	public ResponseEntity<InventoryAdjustmentCombinedDto> getProductBySku(@PathVariable String sku,
			@PathVariable String store) {
		InventoryAdjustmentCombinedDto Product = productService.getproducDetailstBySKU(sku, store);
		return new ResponseEntity<>(Product, HttpStatus.OK);
	}

	@GetMapping("/getProductDetailsByVariants/{size}/{color}/{itemNumber}/{store}")
	public ResponseEntity<ProductDetailsdto2> getProductDetailsByVariants(@PathVariable String size,
			@PathVariable String color, @PathVariable String itemNumber, @PathVariable String store) {
		ProductDetailsdto2 Product = productService.getproducDetailstByVariants(size, color, itemNumber, store);
		return new ResponseEntity<>(Product, HttpStatus.OK);
	}

	@GetMapping("/getVariants/{itemNumber}")
	public ResponseEntity<Map<String, Set<String>>> getVariantsBySku(@PathVariable String itemNumber) {
		Map<String, Set<String>> Product = productService.getVariants(itemNumber);
		return new ResponseEntity<>(Product, HttpStatus.OK);
	}

}
