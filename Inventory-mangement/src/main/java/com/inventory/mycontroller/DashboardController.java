package com.inventory.mycontroller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inventory.mydto.AdjustmentOrRtvExcelUploadProductsdto;
import com.inventory.mydto.MyTasksDto;
import com.inventory.mydto.ResponseWrapper;
import com.inventory.myservice.DashboardService;
import com.inventory.myservice.ExcelDataService;
import com.inventory.myservice.FileUploadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sim")
@SecurityRequirement(name = "bearerAuth")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@Autowired
	private FileUploadService fileService;

	@Autowired
	private ExcelDataService excelservice;

	// Api to get all InTransfers
	@GetMapping("/dashboard/getInTransfers/{store}")
	public ResponseEntity<HashMap<String, Integer>> getInTransfers(@PathVariable String store) {
		HashMap<String, Integer> inTransfers = dashboardService.getInTransfers(store);
		return new ResponseEntity<>(inTransfers, HttpStatus.OK);
	}

	// Api to get all OutTransfers
	@GetMapping("/dashboard/getOutTransfers/{store}")
	public ResponseEntity<HashMap<String, Integer>> getOutTransfers(@PathVariable String store) {
		HashMap<String, Integer> outTransfers = dashboardService.getOutTransfers(store);
		return new ResponseEntity<>(outTransfers, HttpStatus.OK);
	}

	// Api to get getCategoryWiseVariance
	@GetMapping("/dashboard/getCategoryWiseVariance/{store}")
	public ResponseEntity<HashMap<String, Float>> getCategoryWiseVariance(@PathVariable String store) {
		HashMap<String, Float> categoryWiseVariance = dashboardService.getCategoryWiseVariance(store);
		return new ResponseEntity<>(categoryWiseVariance, HttpStatus.OK);
	}

	// Api to get getInventoryDiscrepancyRatio
	@GetMapping("/dashboard/getInventoryDiscrepancyRatio/{store}")
	public ResponseEntity<HashMap<String, Integer>> getInventoryDiscrepancyRatio(@PathVariable String store) {
		HashMap<String, Integer> discrepancyRatio = dashboardService.getInventoryDiscrepancyRatio(store);
		return new ResponseEntity<>(discrepancyRatio, HttpStatus.OK);
	}

	// Api to get all MyTasks
	@GetMapping("/dashboard/getMyTasks/{store}")
	public ResponseEntity<List<MyTasksDto>> getMyTasks(@PathVariable String store) {
		List<MyTasksDto> myTasks = dashboardService.getMyTasks(store);
		return new ResponseEntity<>(myTasks, HttpStatus.OK);
	}

	@PostMapping("/excelUpload")
	@Operation(summary = "Upload a file", description = "Uploads a file", requestBody = @RequestBody(content = @Content(mediaType = "multipart/form-data", schema = @Schema(implementation = MultipartFile.class))))
	public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam String fileName) {

		System.out.println("api hit");
		if (file.isEmpty()) {
			throw new RuntimeException("Could not store file, Please attach the file!");
		}
		System.out.println("fileee: " + file);
		String response = fileService.uploadFile(file, fileName);
		System.out.println("response : " + response);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping("/upload")
	// @Operation(summary = "Upload a file", description = "Uploads a file",
	// requestBody = @RequestBody(content = @Content(mediaType =
	// "multipart/form-data", schema = @Schema(implementation =
	// MultipartFile.class))))

	public String uploadFile(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			throw new IllegalArgumentException("File is required");
		}
		// Handle file upload
		return "File uploaded successfully";
	}

	@GetMapping("/getExcelUploadData/{store}/{fileName}")
	public ResponseEntity<?> getExcel(@PathVariable String store, @PathVariable String fileName) {

		if (fileName.isEmpty()) {
			throw new RuntimeException("Please attach the module!");
		}
		if (fileName.equals("InventoryAdjustment") || fileName.equals("TransferReceive")) {

			ResponseWrapper<AdjustmentOrRtvExcelUploadProductsdto> response = excelservice.getExcelDataAsList(store,
					fileName);
			if (response.getErrorMap() != null) {
				return ResponseEntity.badRequest().body(response.getErrorMap());
			} else if (response.getExcelProductsdto() != null) {
				return ResponseEntity.ok().body(response.getExcelProductsdto());
			} else {
				return ResponseEntity.status(500).body("Unknown response type");
			}
		}

		else {
			throw new RuntimeException("Please attach the correct module!");
		}

	}

	@GetMapping("/getRtvExcelUploadData/{store}/{fileName}/{supplierName}")
	public ResponseEntity<?> getRTVExcel(@PathVariable String store, @PathVariable String fileName,
			@PathVariable String supplierName) {

		if (fileName.isEmpty()) {
			throw new RuntimeException("Please attach the module!");
		}
		if (fileName.equals("ReturnToVendor")) {

			ResponseWrapper<AdjustmentOrRtvExcelUploadProductsdto> response = excelservice.getRtvExcelDataAsList(store,
					fileName, supplierName);
			if (response.getErrorMap() != null) {
				return ResponseEntity.badRequest().body(response.getErrorMap());
			} else if (response.getExcelProductsdto() != null) {
				return ResponseEntity.ok().body(response.getExcelProductsdto());
			} else {
				return ResponseEntity.status(500).body("Unknown response type");
			}
		}

		else {
			throw new RuntimeException("Please attach the correct module!");
		}

	}

	@GetMapping("/getExcelUploadData/{store}/{fileName}/{poNumber}")
	public ResponseEntity<?> getPOExcel(@PathVariable String store, @PathVariable String fileName,
			@PathVariable String poNumber) {

		if (fileName.isEmpty()) {
			throw new RuntimeException("Please attach the module!");
		}

		if (fileName.equals("PurchaseOrder")) {
			// System.out.println("in purchaseo");
			ResponseWrapper<AdjustmentOrRtvExcelUploadProductsdto> response = excelservice.getPOExcelDataAsList(store,
					fileName, poNumber);

			if (response.getErrorMap() != null) {
				return ResponseEntity.badRequest().body(response.getErrorMap());
			} else if (!response.getExcelProductsdto().isEmpty()) {
				return ResponseEntity.ok().body(response.getExcelProductsdto());
			} else {
				return ResponseEntity.status(500).body("Unknown PO Number");
			}
		}

		else {
			throw new RuntimeException("Please attach the correct module!");
		}

	}

}
