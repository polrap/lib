package com.test.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.book.dao.LibDAO;
import com.test.book.model.LibVO;

@Controller
public class BookDetailController {
	private LibDAO libDAO;
	
	@Autowired
	public void setLibDAO( LibDAO libDAO) {
		this.libDAO=libDAO;
	}
	@RequestMapping("/books/read/{index}")
	public String detail(@PathVariable("index") Long index, Model model) {
		LibVO book = libDAO.selectByIndex(index);
		
		model.addAttribute("book", book);
		return "lib/book_detail";
	}

}
