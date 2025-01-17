
package com.inventory.excel.service;

import org.springframework.stereotype.Service;

import com.inventory.dsd.jpa.entity.Suppliers;
import com.inventory.dsd.jpa.entity.SuppliersProducts;
import com.inventory.excel.jpa.AdjustmentOrRtvExcelUploadProductsdto;
import com.inventory.excel.jpa.AdjustmentOrRtvExcelUploadTemplate;
import com.inventory.excel.jpa.ResponseWrapper;
import com.inventory.myrepository.DsdSuppliersRepo;
import com.inventory.myrepository.IAExcelUploadTemplateRepo;
import com.inventory.myrepository.ProductDetailsRepo;
import com.inventory.myrepository.PurchaseOrderItemsRepo;
import com.inventory.myrepository.PurchaseOrderRepo;
import com.inventory.myrepository.StoreRepo;
import com.inventory.myrepository.SuppliersProductsRepo;
import com.inventory.po.jpa.entity.PurchaseOrder;
import com.inventory.po.jpa.entity.PurchaseOrderItems;
import com.inventory.product.jpa.entity.ProductDetails;
import com.inventory.store.jpa.entity.Stores;

import java.io.File;
import java.io.IOException; // </yoastmark>IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Service
public class ExcelDataServiceImpl implements ExcelDataService {

	@Value("${app.upload.file:${user.home}}")
	public String EXCEL_FILE_PATH;

	@Autowired
	private IAExcelUploadTemplateRepo excelTemplateRepo;

	Workbook workbook;

	@Autowired
	private ProductDetailsRepo productDetailsRepo;

	@Autowired
	private StoreRepo storeRepo;

	@Autowired
	private PurchaseOrderItemsRepo itemsRepo;

	@Autowired
	private PurchaseOrderRepo purchaseOrderRepo;

	@Autowired
	private SuppliersProductsRepo suppliersProductsRepo;

	@Autowired
	private DsdSuppliersRepo DsdSuppliersRepo;

	@Override
	public ResponseWrapper<AdjustmentOrRtvExcelUploadProductsdto> getExcelDataAsList(String store, String fileName) {

		Map<String, String> error = new HashMap<>();
		Stores targetStore = storeRepo.findByStoreName(store);
		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		// Create the Workbook
		try {
			workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH + fileName + ".xlsx"));
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		// Retrieving the number of sheets in the Workbook
		System.out.println("-------Workbook has '" + workbook.getNumberOfSheets() + "' Sheets-----");

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		// Getting number of columns in the Sheet
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		System.out.println("-------Sheet has '" + noOfColumns + "' columns------");

		Iterator<Row> iterator = sheet.iterator();
		// Skip header row if needed
		ArrayList<AdjustmentOrRtvExcelUploadTemplate> invList = new ArrayList<AdjustmentOrRtvExcelUploadTemplate>();
		String skuPattern = "^[a-z]{3}\\d{3}$";
		if (iterator.hasNext()) {
			iterator.next(); // skip header row
		}
		while (iterator.hasNext()) {
			Row currentRow = iterator.next();
			String rowNumber = Integer.toString(currentRow.getRowNum());
			AdjustmentOrRtvExcelUploadTemplate inv = new AdjustmentOrRtvExcelUploadTemplate();

			inv.setsNo(Integer.parseInt(dataFormatter.formatCellValue(currentRow.getCell(0))));
//			inv.setSku(dataFormatter.formatCellValue(currentRow.getCell(1)));

			String sku = dataFormatter.formatCellValue(currentRow.getCell(1));

			ProductDetails product = productDetailsRepo.findBySkuAndStore(sku, targetStore);

			if (sku.isEmpty()) {
				error.put("R" + rowNumber, "Field cannot be empty");

			}

			else if (!sku.matches(skuPattern)) {
				error.put("R" + rowNumber, "Invalid item sku");
			}

			else if (product == null) {
				error.put("R" + rowNumber, "Invalid item sku");
			}

			else {
				inv.setSku(dataFormatter.formatCellValue(currentRow.getCell(1)));
			}

			String adjQty = dataFormatter.formatCellValue(currentRow.getCell(2));
			if (adjQty.isEmpty()) {
				error.put("R" + rowNumber, "Field cannot be empty");

			} else if (!adjQty.isEmpty()) {
				String msg = checkIfNumber(adjQty);
				if (!msg.isEmpty()) {
					error.put("R" + rowNumber, msg);
				} else {

					inv.setInputQty(Integer.parseInt(dataFormatter.formatCellValue(currentRow.getCell(2))));

				}

			}

//			System.out.println("getRowNum : " + currentRow.getRowNum());

			invList.add(inv);

		}

//		System.out.println("invList : " + invList);
//		System.out.println("error : " + error);

		if (error.isEmpty()) {
			// System.out.println("empty : ");
			List<AdjustmentOrRtvExcelUploadProductsdto> IAExcelUploadProductsdto = new ArrayList<>();
			// System.out.println("invList : " + invList);
			for (int k = 0; k < invList.size(); k++) {

				ProductDetails product = productDetailsRepo.findBySkuAndStore(invList.get(k).getSku(), targetStore);
//				System.out.println("product : " + product);
				IAExcelUploadProductsdto.add(new AdjustmentOrRtvExcelUploadProductsdto(
						product.getProduct().getItemNumber(), product.getProduct().getitemName(),
						product.getProduct().getCategory().getCategory(), product.getSku(), product.getUpc(),
						product.getColor(), product.getPrice(), product.getSize(), product.getImageData(),
						product.getSellableStock(), product.getNonSellableStock(), invList.get(k).getInputQty()));
			}

			// System.out.println("IAExcelUploadProductsdto :" + IAExcelUploadProductsdto);
			// Closing the workbook
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseWrapper<>(IAExcelUploadProductsdto);
		}

		else {
			// Closing the workbook
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseWrapper<>(error);
		}

	}

	// Function to get RTV excel sheet data
	@Override
	public ResponseWrapper<AdjustmentOrRtvExcelUploadProductsdto> getRtvExcelDataAsList(String store, String fileName,
			String supplierName) {

		Map<String, String> error = new HashMap<>();
		Stores targetStore = storeRepo.findByStoreName(store);
		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		// Create the Workbook
		try {
			workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH + fileName + ".xlsx"));
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		// Retrieving the number of sheets in the Workbook
		System.out.println("-------Workbook has '" + workbook.getNumberOfSheets() + "' Sheets-----");

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		// Getting number of columns in the Sheet
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		System.out.println("-------Sheet has '" + noOfColumns + "' columns------");

		Iterator<Row> iterator = sheet.iterator();
		// Skip header row if needed
		ArrayList<AdjustmentOrRtvExcelUploadTemplate> invList = new ArrayList<AdjustmentOrRtvExcelUploadTemplate>();
		String skuPattern = "^[a-z]{3}\\d{3}$";
		if (iterator.hasNext()) {
			iterator.next(); // skip header row
		}
		while (iterator.hasNext()) {
			Row currentRow = iterator.next();
			String rowNumber = Integer.toString(currentRow.getRowNum());
			AdjustmentOrRtvExcelUploadTemplate inv = new AdjustmentOrRtvExcelUploadTemplate();

			inv.setsNo(Integer.parseInt(dataFormatter.formatCellValue(currentRow.getCell(0))));
//			inv.setSku(dataFormatter.formatCellValue(currentRow.getCell(1)));

			String sku = dataFormatter.formatCellValue(currentRow.getCell(1));
			Suppliers supplier = DsdSuppliersRepo.findBysupplierName(supplierName);
			SuppliersProducts supplierItem = suppliersProductsRepo.findBySkuAndSuppliers(sku, supplier);

			ProductDetails product = null;

			if (supplierItem != null) {
				product = productDetailsRepo.findBySkuAndStore(supplierItem.getSku(), targetStore);
			}

			if (sku.isEmpty()) {
				error.put("R" + rowNumber, "Field cannot be empty");

			}

			else if (!sku.matches(skuPattern)) {
				error.put("R" + rowNumber, "Invalid item sku");
			}

			else if (supplierItem == null) {
				System.out.println("inside if");
				error.put("R" + rowNumber, "Invalid item sku");
			}

			else {
				inv.setSku(dataFormatter.formatCellValue(currentRow.getCell(1)));
			}

			String adjQty = dataFormatter.formatCellValue(currentRow.getCell(2));
			if (adjQty.isEmpty()) {
				error.put("R" + rowNumber, "Field cannot be empty");

			} else if (!adjQty.isEmpty()) {
				String msg = checkIfNumber(adjQty);
				if (!msg.isEmpty()) {
					error.put("R" + rowNumber, msg);
				} else {
					if (fileName.equals("ReturnToVendor") && product != null) {
						if (product.getNonSellableStock() < Integer
								.parseInt(dataFormatter.formatCellValue(currentRow.getCell(2)))) {
							error.put("R" + rowNumber, "Return qty can't exceed available qty");
						} else {
							inv.setInputQty(Integer.parseInt(dataFormatter.formatCellValue(currentRow.getCell(2))));
						}
					} else {
						inv.setInputQty(Integer.parseInt(dataFormatter.formatCellValue(currentRow.getCell(2))));
					}

				}

			}

//			System.out.println("getRowNum : " + currentRow.getRowNum());

			invList.add(inv);

		}

//		System.out.println("invList : " + invList);
//		System.out.println("error : " + error);

		if (error.isEmpty()) {
			// System.out.println("empty : ");
			List<AdjustmentOrRtvExcelUploadProductsdto> IAExcelUploadProductsdto = new ArrayList<>();
			// System.out.println("invList : " + invList);
			for (int k = 0; k < invList.size(); k++) {

				ProductDetails product = productDetailsRepo.findBySkuAndStore(invList.get(k).getSku(), targetStore);
//				System.out.println("product : " + product);
				IAExcelUploadProductsdto.add(new AdjustmentOrRtvExcelUploadProductsdto(
						product.getProduct().getItemNumber(), product.getProduct().getitemName(),
						product.getProduct().getCategory().getCategory(), product.getSku(), product.getUpc(),
						product.getColor(), product.getPrice(), product.getSize(), product.getImageData(),
						product.getSellableStock(), product.getNonSellableStock(), invList.get(k).getInputQty()));
			}

			// System.out.println("IAExcelUploadProductsdto :" + IAExcelUploadProductsdto);
			// Closing the workbook
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseWrapper<>(IAExcelUploadProductsdto);
		}

		else {
			// Closing the workbook
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseWrapper<>(error);
		}

	}

	@Override
	public ResponseWrapper<AdjustmentOrRtvExcelUploadProductsdto> getPOExcelDataAsList(String store, String fileName,
			String poNumber) {

		Map<String, String> error = new HashMap<>();
		Stores targetStore = storeRepo.findByStoreName(store);
		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		// Create the Workbook
		try {
			workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH + fileName + ".xlsx"));
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Please upload the file first!");
		}

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		Iterator<Row> iterator = sheet.iterator();
		// Skip header row if needed
		ArrayList<AdjustmentOrRtvExcelUploadTemplate> invList = new ArrayList<AdjustmentOrRtvExcelUploadTemplate>();
		String skuPattern = "^[a-z]{3}\\d{3}$";
		if (iterator.hasNext()) {
			iterator.next(); // skip header row
		}
		PurchaseOrder puchaseorder = purchaseOrderRepo.findByPoNumber(poNumber);
		while (iterator.hasNext()) {
			Row currentRow = iterator.next();
			String rowNumber = Integer.toString(currentRow.getRowNum());
			AdjustmentOrRtvExcelUploadTemplate inv = new AdjustmentOrRtvExcelUploadTemplate();

			inv.setsNo(Integer.parseInt(dataFormatter.formatCellValue(currentRow.getCell(0))));
//			inv.setSku(dataFormatter.formatCellValue(currentRow.getCell(1)));

			String sku = dataFormatter.formatCellValue(currentRow.getCell(1));

			if (puchaseorder != null) {

				PurchaseOrderItems item = itemsRepo.findBySkuAndPurchaseOrder(sku, puchaseorder);

				if (sku.isEmpty()) {
					error.put("R" + rowNumber, "Field cannot be empty");

				}

				else if (!sku.matches(skuPattern)) {
					error.put("R" + rowNumber, "Invalid item sku");
				}

				else if (item == null) {
					error.put("R" + rowNumber, "Invalid item sku");
				}

				else {
					inv.setSku(dataFormatter.formatCellValue(currentRow.getCell(1)));
				}

				String Qty = dataFormatter.formatCellValue(currentRow.getCell(2));
				if (Qty.isEmpty()) {
					error.put("R" + rowNumber, "Field cannot be empty");

				} else if (!Qty.isEmpty()) {
					String msg = checkIfNumber(Qty);
					if (!msg.isEmpty()) {
						error.put("R" + rowNumber, msg);
					} else {

						int qty = Integer.parseInt(dataFormatter.formatCellValue(currentRow.getCell(2)));

//						if (item != null) {
//							int updatedExpectedQty = item.getExpectedQty()
//									- (item.getReceivedQty() + item.getDamageQty());
//							if (qty <= updatedExpectedQty) {
						inv.setInputQty(qty);
//							} else {
//								error.put("R" + rowNumber, "Input qty shouldn't exceed po qty");
//							}

					}

				}

				invList.add(inv);

			}
		}

//		System.out.println("list: " + invList);
//		System.out.println("error: " + error);

		if (error.isEmpty()) {
			// System.out.println("empty : ");
			List<AdjustmentOrRtvExcelUploadProductsdto> IAExcelUploadProductsdto = new ArrayList<>();
			// System.out.println("invList : " + invList);
			for (int k = 0; k < invList.size(); k++) {

//				PurchaseOrder puchaseorder = purchaseOrderRepo.findByPoNumber(poNumber);
				PurchaseOrderItems product = itemsRepo.findBySkuAndPurchaseOrder(invList.get(k).getSku(), puchaseorder);
//				System.out.println("product : " + product);
				IAExcelUploadProductsdto.add(new AdjustmentOrRtvExcelUploadProductsdto(product.getItemNumber(),
						product.getItemName(), product.getCategory(), product.getSku(), product.getUpc(),
						product.getColor(), product.getPrice(), product.getSize(), product.getImageData(),
						invList.get(k).getInputQty()));
			}

			// System.out.println("IAExcelUploadProductsdto :" + IAExcelUploadProductsdto);
			// Closing the workbook
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseWrapper<>(IAExcelUploadProductsdto);
		}

		else {
			// Closing the workbook
			try {

				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// throw new ExceptionHandling(HttpStatus.NOT_FOUND, "Incorrect PO ");
			return new ResponseWrapper<>(error);
		}

	}

	public String checkIfNumber(String input) {
		try {
			int number = Integer.parseInt(input);
			if (number == 0) {
				return "Quantity cannot be zero.";
			} else if (number < 0) {
				return "Quantity cannot be negative.";
			} else {
				return "";
			}
		} catch (NumberFormatException e) {
			return "Invalid data in numeric field.";
		}

	}

	@Override
	public int getExcelData(List<AdjustmentOrRtvExcelUploadTemplate> invAdjProducts) {
		invAdjProducts = excelTemplateRepo.saveAll(invAdjProducts);
		return invAdjProducts.size();
	}

}
