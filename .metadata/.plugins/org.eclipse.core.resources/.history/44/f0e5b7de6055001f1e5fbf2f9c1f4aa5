package com.inventory.myservice;

import java.util.List;

import com.inventory.mydto.AdjustmentOrRtvExcelUploadProductsdto;
import com.inventory.mydto.ResponseWrapper;
import com.inventory.myentity.AdjustmentOrRtvExcelUploadTemplate;

public interface ExcelDataService {

	int getExcelData(List<AdjustmentOrRtvExcelUploadTemplate> invAdjProducts);

	ResponseWrapper<AdjustmentOrRtvExcelUploadProductsdto> getExcelDataAsList(String store, String fileName);

	ResponseWrapper<AdjustmentOrRtvExcelUploadProductsdto> getPOExcelDataAsList(String store, String fileName,
			String poNumber);

}
