
package com.inventory.excel.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.inventory.adjustments.jpa.entity.InventoryAdjustmentProducts;

@Service
public class FileUploaderServiceImpl implements FileUploadService {

	public List<InventoryAdjustmentProducts> invoiceExcelReaderService() {
		return null;
	}

	@Value("${app.upload.dir:${user.home}}")
	public String uploadDir;

	public String uploadFile(MultipartFile file, String module) {

		// System.out.println("File in fileUploaderservice : " + file.getName());
		if (module.equals("TransferReceive") || module.equals("ReturnToVendor") || module.equals("PurchaseOrder")
				|| module.equals("InventoryAdjustment")) {
			try {
				Path copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(module + ".xlsx"));
				Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
				return "File uploaded successfully";
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(
						"Could not store file " + file.getOriginalFilename() + ". Please try again!");
			}
		}

		else {
			throw new RuntimeException(
					"Could not store file " + file.getOriginalFilename() + ". Please correct the module!");

		}

	}

}
