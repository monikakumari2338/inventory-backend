
package com.inventory.myserviceimpl;

import java.time.LocalDate;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.myentity.Category;
import com.inventory.myentity.StockCountCreation;
import com.inventory.myentity.StockCountCreationProducts;
import com.inventory.myrepository.CategoryRepo;
import com.inventory.myrepository.StockCreationProductsRepo;
import com.inventory.myrepository.StockCreationRepo;
import com.inventory.myservice.StockCountCreationService;

@Service
public class StockCountCreationServiceImpl implements StockCountCreationService {

	@Autowired
	private StockCreationRepo creationRepo;

	@Autowired
	private StockCreationProductsRepo creationProductsRepo;

	@Autowired
	private CategoryRepo categoryRepo;

}
