package com.inventory.purchaseorder.controller;

import java.util.List;
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

import com.inventory.purchaseorder.dto.ProductCombineddto;
import com.inventory.purchaseorder.dto.ProductCombineddtotoAdjustInventory;
import com.inventory.purchaseorder.dto.ProductDetailsdto;
import com.inventory.purchaseorder.dto.Productdto;
import com.inventory.purchaseorder.dto.ProductsByItemNumberdto;
import com.inventory.purchaseorder.dto.StoreAndInTransitInventorydto;
import com.inventory.purchaseorder.dto.categorydto;
import com.inventory.purchaseorder.entity.InventoryAdjustment;
import com.inventory.purchaseorder.entity.Product;
import com.inventory.purchaseorder.entity.ProductDetails;
import com.inventory.purchaseorder.service.ProductService;

@RestController
@RequestMapping("/product")
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
	public ResponseEntity<ProductDetails> getProduct(@PathVariable String upc, @PathVariable String store){
		ProductDetails product = productService.getproducDetailstByUpc(upc, store);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}

	@GetMapping("/findbysku/{sku}/{store}")
	public ResponseEntity<ProductDetails> getProductBySku(@PathVariable String sku, @PathVariable String store) {
		ProductDetails Product = productService.getproducDetailstBySKU(sku, store);
		return new ResponseEntity<>(Product, HttpStatus.OK);
	}

}
