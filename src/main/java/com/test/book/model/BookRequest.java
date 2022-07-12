package com.test.book.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
	private String title;
	private String link;
	private MultipartFile image; //이미지 파일 이름
	private String author;
	private String price;
	private String publisher;
	private String isbn;
	private String description;
	
}
