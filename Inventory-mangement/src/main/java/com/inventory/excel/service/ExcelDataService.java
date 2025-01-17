package com.inventory.excel.service;

import java.util.List;

import com.inventory.excel.jpa.AdjustmentOrRtvExcelUploadProductsdto;
import com.inventory.excel.jpa.AdjustmentOrRtvExcelUploadTemplate;
import com.inventory.excel.jpa.ResponseWrapper;

public interface ExcelDataService {

	int getExcelData(List<AdjustmentOrRtvExcelUploadTemplate> invAdjProducts);

	ResponseWrapper<AdjustmentOrRtvExcelUploadProductsdto> getExcelDataAsList(String store, String fileName);

	ResponseWrapper<AdjustmentOrRtvExcelUploadProductsdto> getPOExcelDataAsList(String store, String fileName,
			String poNumber);

	ResponseWrapper<AdjustmentOrRtvExcelUploadProductsdto> getRtvExcelDataAsList(String store, String fileName,
			String supplierName);

}
