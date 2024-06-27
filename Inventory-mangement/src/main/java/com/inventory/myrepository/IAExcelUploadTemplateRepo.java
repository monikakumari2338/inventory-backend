package com.inventory.myrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.AdjustmentOrRtvExcelUploadTemplate;

public interface IAExcelUploadTemplateRepo extends JpaRepository<AdjustmentOrRtvExcelUploadTemplate, Integer> {

}