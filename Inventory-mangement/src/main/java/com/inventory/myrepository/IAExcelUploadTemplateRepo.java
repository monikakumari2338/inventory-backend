package com.inventory.myrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.IAExcelUploadTemplate;

public interface IAExcelUploadTemplateRepo extends JpaRepository<IAExcelUploadTemplate, Integer> {

}