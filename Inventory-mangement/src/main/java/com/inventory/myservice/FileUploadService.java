package com.inventory.myservice;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	public String uploadFile(MultipartFile file,String fileName);

}
