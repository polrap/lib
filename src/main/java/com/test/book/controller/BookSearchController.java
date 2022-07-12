package com.test.book.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.book.dao.LibDAO;
import com.test.book.model.LibVO;
import com.test.book.model.PagingVO;

@Controller
public class BookSearchController {
	
	private LibDAO libDAO;
	
	
	@Autowired
	public void setLibDAO( LibDAO libDAO) {
		this.libDAO=libDAO;
	}
	
	@GetMapping("search")
	public ModelAndView searchBook(Model model,@RequestParam("searchkey") String search,@RequestParam("keyword") String keyword,
			@RequestParam(value="nowPage",required=false) String nowPage,@RequestParam(value="cntPerPage",required=false) String cntPerPage) {
		System.out.println(search);
		search=search.toUpperCase();
		
		System.out.println("181818181818181818181811818181"+keyword);
		PagingVO pvo;
		int polo=3;
		int total = libDAO.count();
		if (nowPage==null && cntPerPage==null) {
			nowPage = "1";
			cntPerPage = "3";
		}
		pvo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		ModelAndView mav= new ModelAndView();
		mav.addObject("polo",polo);
		model.addAttribute("paging", pvo);
		List<LibVO> bookList;//=libDAO.selectListCase(keyword);
		Map<String, String> map= new HashMap<String, String>();
		switch(search) {
		case "DEFAULTSEARCH":
			System.out.println(keyword);
			System.out.println(String.valueOf(pvo.getStart()));
			System.out.println(String.valueOf(pvo.getEnd()));
				map.put("keyword", keyword);
				map.put("start", String.valueOf(pvo.getStart()));
				map.put("end", String.valueOf(pvo.getEnd()));
				bookList=libDAO.selectListCase(map);
				System.out.println(bookList.size());
			//bookList=libDAO.listDefault(keyword);
			mav.addObject("bookList", bookList);
			mav.addObject("keyword",keyword);
			System.out.println("SEARCH"+search);
			mav.addObject("search",search);
			break;
		case "TITLE":
			map.put("search", search);
			map.put("keyword", keyword);
			bookList=libDAO.listColumn(map);
			mav.addObject("bookList", bookList);
			break;
		case "AUTHOR":
			map.put("search", search);
			map.put("keyword", keyword);
			bookList=libDAO.listColumn(map);
			mav.addObject("bookList", bookList);
			break;	
		case "PUBLISHER":
			map.put("search", search);
			map.put("keyword", keyword);
			bookList=libDAO.listColumn(map);
			mav.addObject("bookList", bookList);
			break;		
		case "ISBN":
			map.put("search", search);
			map.put("keyword", keyword);
			bookList=libDAO.listColumn(map);
			mav.addObject("bookList", bookList);
			mav.addObject("keyword",keyword);
			break;	
		}
		mav.setViewName("lib/book_list");
		
		return mav;
		
	}
	
}
