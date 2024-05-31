package com.inventory.mycontroller;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.mydto.ProductsByItemNumberdto;
import com.inventory.mydto.StockCountCreationCombinedDto;
import com.inventory.myentity.SaveStockCountProducts;
import com.inventory.myentity.StockCountCreationProducts;
import com.inventory.myservice.StockCountCreationService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/stockcount")
@SecurityRequirement(name="bearerAuth")
public class StockCountCreationController {

	@Autowired
	private StockCountCreationService stockCountCreationService;

	@PostMapping("/createstockcount")
	public ResponseEntity<StockCountCreationCombinedDto> saveStockCount(
			@RequestBody StockCountCreationCombinedDto stockCountCombinedDto) {
		StockCountCreationCombinedDto stockCountCreationCombinedDto = stockCountCreationService
				.saveProducts(stockCountCombinedDto);
		return new ResponseEntity<>(stockCountCreationCombinedDto, HttpStatus.OK);
	}

	@GetMapping("/getProductsbydate/{date}/{store}")
	public ResponseEntity<StockCountCreationCombinedDto> geTodaysProduct(@PathVariable LocalDate date,
			@PathVariable String store) {
		System.out.print("date : " + date);
		StockCountCreationCombinedDto products = stockCountCreationService.getProductsByDate(date,store);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("getpending/stockproducts/{id}")
	public ResponseEntity<List<StockCountCreationProducts>> getStockCountProducts(@PathVariable int id) {
		List<StockCountCreationProducts> stockProductList = stockCountCreationService
				.getStockCountProductsByCountId(id);
		return new ResponseEntity<>(stockProductList, HttpStatus.OK);
	}

}
