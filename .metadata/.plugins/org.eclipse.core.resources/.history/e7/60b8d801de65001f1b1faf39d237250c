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
import com.inventory.myentity.StockCountCreationProducts;
import com.inventory.myservice.StockCountCreationService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/stockcount")
@SecurityRequirement(name = "bearerAuth")
public class StockCountCreationController {

	@Autowired
	private StockCountCreationService stockCountCreationService;

}
