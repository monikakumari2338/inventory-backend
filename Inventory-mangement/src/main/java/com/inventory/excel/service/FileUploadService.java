package com.inventory.excel.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	public String uploadFile(MultipartFile file,String fileName);

}
