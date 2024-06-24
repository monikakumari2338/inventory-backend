
package com.inventory.myserviceimpl;

import org.springframework.stereotype.Service;

import com.inventory.mydto.IAExcelUploadProductsdto;
import com.inventory.myentity.IAExcelUploadTemplate;
import com.inventory.myentity.ProductDetails;
import com.inventory.myentity.Stores;
import com.inventory.myexception.ExcelValidationExceptionHandling;
import com.inventory.myrepository.IAExcelUploadTemplateRepo;
import com.inventory.myrepository.ProductDetailsRepo;
import com.inventory.myrepository.StoreRepo;
import com.inventory.myservice.ExcelDataService;

import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolation;
import java.io.File;
import java.io.IOException; // </yoastmark>IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

@Service
public class ExcelDataServiceImpl implements ExcelDataService {

	@Value("${app.upload.file:${user.home}}")
	public String EXCEL_FILE_PATH;

	@Autowired
	private IAExcelUploadTemplateRepo excelTemplateRepo;

	Workbook workbook;

	// private final Validator validator;

	@Autowired
	private ProductDetailsRepo productDetailsRepo;

	@Autowired
	private StoreRepo storeRepo;

//	@Autowired
//	public ExcelDataServiceImpl(Validator validator) {
//		this.validator = validator;
//	}

	public List<IAExcelUploadProductsdto> getExcelDataAsList(String store) {

		List<String> list = new ArrayList<String>();

		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		// Create the Workbook
		try {
			workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));
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

		// Using for-each loop to iterate over the rows and columns
		for (Row row : sheet) {
			for (Cell cell : row) {
				String cellValue = dataFormatter.formatCellValue(cell);
				// System.out.println("cellValue : " + cellValue);
				list.add(cellValue);

				int lastColumn = row.getLastCellNum();
				for (int cn = row.getFirstCellNum(); cn < lastColumn; cn++) {
					if (row.getCell(cn) == null) {
						list.add("");
					}
				}
			}

		}
		// filling excel data and creating list as List<Invoice>
		List<IAExcelUploadProductsdto> data = createList(list, noOfColumns, store);

		// Closing the workbook
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	private List<IAExcelUploadProductsdto> createList(List<String> excelData, int noOfColumns, String store) {

		ArrayList<IAExcelUploadTemplate> invList = new ArrayList<IAExcelUploadTemplate>();
		Stores targetStore = storeRepo.findByStoreName(store);

		int i = noOfColumns;
		String skuPattern = "^[a-z]{3}\\d{3}$";
		System.out.println("excelData : " + excelData);
		do {
			IAExcelUploadTemplate inv = new IAExcelUploadTemplate();

			inv.setsNo(Integer.parseInt(excelData.get(i)));
//			inv.setSku(excelData.get(i + 1));
//			inv.setAdjQty(Integer.parseInt(excelData.get(i + 2)));

			String sku = excelData.get(i + 1);

			ProductDetails product = productDetailsRepo.findBySkuAndStore(sku, targetStore);

			if (sku.isEmpty()) {
				throw new ExcelValidationExceptionHandling(HttpStatus.BAD_REQUEST, "Empty Sku Field");

			}

			else if (!sku.matches(skuPattern)) {

				throw new ExcelValidationExceptionHandling(HttpStatus.BAD_REQUEST, "Invalid item sku");
			}

			else if (product == null) {
				System.out.println("sku product");
				throw new ExcelValidationExceptionHandling(HttpStatus.BAD_REQUEST, "Invalid item sku product");
			}

			else {

				inv.setSku(excelData.get(i + 1));
			}

			String adjQty = excelData.get(i + 2);
			if (adjQty == null) {

				throw new ExcelValidationExceptionHandling(HttpStatus.BAD_REQUEST, "Empty Field");
			} else if (!isInteger(adjQty)) {

				throw new ExcelValidationExceptionHandling(HttpStatus.BAD_REQUEST, "Invalid data in numeric field");
			}

			else {

				inv.setAdjQty(Integer.parseInt(excelData.get(i + 2)));
			}

			// Validate the data
//			Set<ConstraintViolation<IAExcelUploadTemplate>> violations = validator.validate(inv);
//			if (!violations.isEmpty()) {
//				for (ConstraintViolation<IAExcelUploadTemplate> violation : violations) {
//					System.out.println("Validation error: " + violation.getMessage());
//					// Handle errors here as per your requirement
//				}
//			} else {
//				invList.add(inv);
//				i = i + (noOfColumns);
//			}
			invList.add(inv);
			i = i + (noOfColumns);

		} while (i < excelData.size());

		List<IAExcelUploadProductsdto> IAExcelUploadProductsdto = new ArrayList<>();
		// System.out.println("invList : " + invList);
		for (int k = 0; k < invList.size(); k++) {

			ProductDetails product = productDetailsRepo.findBySkuAndStore(invList.get(k).getSku(), targetStore);
//			System.out.println("product : " + product);
			IAExcelUploadProductsdto.add(new IAExcelUploadProductsdto(product.getProduct().getItemNumber(),
					product.getProduct().getitemName(), product.getProduct().getCategory().getCategory(),
					product.getSku(), product.getUpc(), product.getColor(), product.getPrice(), product.getSize(),
					product.getImageData()));
		}

		// System.out.println("IAExcelUploadProductsdto :" + IAExcelUploadProductsdto);
		return IAExcelUploadProductsdto;
	}

	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public int getExcelData(List<IAExcelUploadTemplate> invAdjProducts) {
		invAdjProducts = excelTemplateRepo.saveAll(invAdjProducts);
		return invAdjProducts.size();
	}

}