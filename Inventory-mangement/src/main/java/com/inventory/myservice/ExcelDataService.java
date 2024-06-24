package com.inventory.myservice;

import java.util.List;

import com.inventory.myentity.IAExcelUploadTemplate;

public interface ExcelDataService {

	List<IAExcelUploadTemplate> getExcelDataAsList(String store);

	int getExcelData(List<IAExcelUploadTemplate> invAdjProducts);

}
