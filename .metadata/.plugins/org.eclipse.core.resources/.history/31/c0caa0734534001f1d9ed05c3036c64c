package com.inventory.mycontroller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.myservice.DashboardService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/dashboard")
@SecurityRequirement(name = "bearerAuth")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	// Api to get all InTransfers
	@GetMapping("/getInTransfers/{store}")
	public ResponseEntity<HashMap<String, Integer>> getInTransfers(@PathVariable String store) {
		HashMap<String, Integer> inTransfers = dashboardService.getInTransfers(store);
		return new ResponseEntity<>(inTransfers, HttpStatus.OK);
	}

	// Api to get all OutTransfers
	@GetMapping("/getOutTransfers/{store}")
	public ResponseEntity<HashMap<String, Integer>> getOutTransfers(@PathVariable String store) {
		HashMap<String, Integer> outTransfers = dashboardService.getOutTransfers(store);
		return new ResponseEntity<>(outTransfers, HttpStatus.OK);
	}

	// Api to get getCategoryWiseVariance
	@GetMapping("/getCategoryWiseVariance/{store}")
	public ResponseEntity<HashMap<String, Float>> getCategoryWiseVariance(@PathVariable String store) {
		HashMap<String, Float> categoryWiseVariance = dashboardService.getCategoryWiseVariance(store);
		return new ResponseEntity<>(categoryWiseVariance, HttpStatus.OK);
	}

	// Api to get getInventoryDiscrepancyRatio
	@GetMapping("/getInventoryDiscrepancyRatio/{store}")
	public ResponseEntity<HashMap<String, Integer>> getInventoryDiscrepancyRatio(@PathVariable String store) {
		HashMap<String, Integer> discrepancyRatio = dashboardService.getInventoryDiscrepancyRatio(store);
		return new ResponseEntity<>(discrepancyRatio, HttpStatus.OK);
	}

	// Api to get all MyTasks
	@GetMapping("/getMyTasks/{store}")
	public ResponseEntity<HashMap<String, Integer>> getMyTasks(@PathVariable String store) {
		HashMap<String, Integer> myTasks = dashboardService.getMyTasks(store);
		return new ResponseEntity<>(myTasks, HttpStatus.OK);
	}

}
