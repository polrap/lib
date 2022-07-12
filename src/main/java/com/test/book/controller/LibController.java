package com.test.book.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.test.book.exception.AlreadyExistingBookException;
import com.test.book.model.BookRequest;
import com.test.book.service.BookAddService;
import com.test.book.service.FileService;

@Controller
@RequestMapping("/books/add")
public class LibController {
	private BookAddService bookAddService;
	private FileService fileService;

	@Autowired
	public void setBookAddService(BookAddService bookAddService) {
		this.bookAddService = bookAddService;
	}

	@Autowired
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String book(Model model) {
		model.addAttribute("BookRequest", new BookRequest());
		return "lib/book_reg_form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addbook(@ModelAttribute("BookRequest") BookRequest fileReq, Errors errors) {
		String urlPath = "";
		new BookRequestValidator().validate(fileReq, errors);
		if (errors.hasErrors()) {
			System.out.println("error");
			urlPath = "lib/book_reg_form";
		}else{
			System.out.println("else");
			boolean checkIsbn = bookAddService.selectByIsbn(fileReq);
			System.out.println(checkIsbn);
			if (checkIsbn) {
				MultipartFile file = fileReq.getImage();
				String fileName = file.getOriginalFilename();
				String path = fileService.fileUpload(file, fileName);
				if (!path.equals("")) {
					try {
						fileReq.setLink(path);
						bookAddService.addBookService(fileReq);
						System.out.println("upload su");
					} catch (AlreadyExistingBookException e) {
						System.out.println("upload fail");
						errors.rejectValue("isbn", "duplicate");
						urlPath = "lib/book_reg_form";
					}
					urlPath = "redirect:/list";
				}else {
					System.out.println("실패");
					urlPath ="lib/book_reg_form";
				}
			} else {
				System.out.println("isbn error");
				errors.rejectValue("isbn", "duplicate");
				urlPath = "lib/book_reg_form";
			}
			
		}
		System.out.println(urlPath);
		return urlPath;
	}

//	@RequestMapping("/books/read/{index}")
//	public String detail(@PathVariable("index") Long index, Model model) {
//		
//		
//		return "/books/read";
//	}

}
