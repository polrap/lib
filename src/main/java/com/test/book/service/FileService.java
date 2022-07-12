package com.test.book.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileService {
	private String uploadDir ="C:\\image\\";
	
	public String fileUpload(MultipartFile mul, String fileName) {
		 String imagePath=uploadDir;
		 
		String fileExtension=fileName.substring(fileName.lastIndexOf("."));
		if(fileExtension.equals(".PNG") || fileExtension.equals(".JPEG")|| fileExtension.equals(".jpg")) {
			try {
				mul.transferTo(new File(imagePath+fileName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("file서비스의 else");
			imagePath="";
		}
		return imagePath;
	}
	
//	public String imagePath(String imageName){
//		String path="";
//		try {
//			FileInputStream fileStream = new FileInputStream(uploadDir + imageName);
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} 
//		return path;
//		
//	}
}
