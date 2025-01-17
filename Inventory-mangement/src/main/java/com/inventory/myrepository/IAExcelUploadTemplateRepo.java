package com.inventory.myrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.excel.jpa.AdjustmentOrRtvExcelUploadTemplate;

public interface IAExcelUploadTemplateRepo extends JpaRepository<AdjustmentOrRtvExcelUploadTemplate, Integer> {

}