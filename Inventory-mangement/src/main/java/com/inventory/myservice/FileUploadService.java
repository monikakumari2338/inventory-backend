package com.inventory.myservice;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	public void uploadFile(MultipartFile file);

}