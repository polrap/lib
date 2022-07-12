package com.test.book.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LibVO {
	private long index;
	private String title;
	private String link;	//파일 경로
	private String image; //이미지 파일 이름
	private String author;
	private long price;
	private String publisher;
	private long isbn;
	private String description;

	public LibVO(long index,String title, String link, String image, String author,
	long price, String publisher,long isbn ,String description) {
		this.index=index;
		this.title=title;
		this.link=link;
		this.author=author;
		this.price=Long.valueOf(price);
		this.publisher=publisher;
		this.isbn=isbn;
		this.image=image;
		this.description=description;
	}
	
	public LibVO(String title, String link, String image, String author,
	int price, String publisher,int isbn ,String description) {
		this.title=title;
		this.link=link;
		this.author=author;
		this.price=price;
		this.publisher=publisher;
		this.isbn=isbn;
		this.image=image;
		this.description=description;
	}
	
	
	
	public LibVO(String title, String link, MultipartFile image, String author, String price, String publisher,
			String isbn, String description) {
		this.title=title;
		this.link=link;
		this.author=author;
		this.price=Integer.valueOf(price);
		this.publisher=publisher;
		this.isbn=Integer.valueOf(isbn);
		this.image=String.valueOf(image);
		this.description=description;
	}
	public LibVO(String title, String link, String image, String author, String price, String publisher,
			String isbn, String description) {
		this.title=title;
		this.link=link;
		this.author=author;
		this.price=Integer.valueOf(price);
		this.publisher=publisher;
		this.isbn=Integer.valueOf(isbn);
		this.image=image;
		this.description=description;
	}

	public void setPrice(String price) {
		this.price = Integer.valueOf(price);
	}
	
}
