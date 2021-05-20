package com.example.nashta_test.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.nashta_test.properties.FileStorageProperty;

@Service
public class FileStorageImpl {
	private Path fileStorageLocation = null;

	@Autowired
	public void FileStorageService(FileStorageProperty fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException e) {
			
		}
    }
	
    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());	

        if(!file.isEmpty()) {
            try {
                // Check if the file's name contains invalid characters
                if(fileName.contains("..")) {
                    
                }
//              Path targetLocation = this.fileStorageLocation.resolve(fileName);
                Files.copy(file.getInputStream(), Paths.get("C:\\Users\\Muhammad\\Users\\Loyola\\Uploads", file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

                return fileName;
            } catch (IOException ex) {
                
            }
        } else {
            return null;
        }
		return fileName;
    }

    public Resource loadFileAsResource(String fileName) {
    	Resource resource;
    	try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            resource = new UrlResource(filePath.toUri());
            System.out.println("filepath : "+filePath.toUri());
            System.out.println("resource "+resource.getFilename());
            if(resource.exists()) {
                return resource;
            } else {
                
            }
        } catch (MalformedURLException ex) {
            return null;
        }
		return resource;
    }
}
