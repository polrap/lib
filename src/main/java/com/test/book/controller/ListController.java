package com.test.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.book.dao.LibDAO;
import com.test.book.model.LibVO;
import com.test.book.model.PagingVO;

@Controller
//@RequestMapping("/list")
public class ListController {
	private LibDAO libDAO;
	private LibVO lib;
	private PagingVO page;

	@Autowired
	public void setLibDAO(LibDAO libDAO) {
		this.libDAO = libDAO;
	}
//	@Autowired
//	public void setLibVO( LibVO lib) {
//		this.lib=lib;
//	}

//	@RequestMapping(method = RequestMethod.GET)
//	public String bookList(Model model, @ModelAttribute("bookList") List<LibVO> libList) {
//		if (lib == null) {
//			List<LibVO> bookList = libDAO.allBookList();
//
//			model.addAttribute("bookList", bookList);
//			return "lib/book_list";
//		}else {
//			List<LibVO>bookList=libList;
//			model.addAttribute("bookList", bookList);
//			return "lib/book_list";
//		}
//
//	}

	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String bookList(Model model,
		@RequestParam(value="nowPage",required=false) String nowPage,@RequestParam(value="cntPerPage",required=false) String cntPerPage) {
		PagingVO pvo;
		System.out.println("nowPage"+nowPage);
		System.out.println("cntPerPage"+cntPerPage);
//		System.out.println(request.getParameter("nowPage"));
//		if (request.getParameter("nowPage")==null||request.getParameter("nowPage").equals("null")) {
//			nowPage = request.getParameter("nowPage");
//			cntPerPage = request.getParameter("nowPage");
//		}else if(request.getParameter("nowPage").equals("")){
//			System.out.println("dkdkdk");
//		}
		//List<LibVO> bookList = libDAO.allBookList();
		
		
		int total = libDAO.count();
		System.out.println(total);
		if (nowPage==null && cntPerPage==null) {
			nowPage = "1";
			cntPerPage = "3";
		}
		System.out.println("nowPage2"+nowPage);
		System.out.println("cntPerPage2"+cntPerPage);
		pvo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
//		else if(nowPage!=null && cntPerPage!=null){
//			nowPage=String.valueOf(Integer.valueOf(nowPage));
//			cntPerPage="5";
//		}
		
//		else if (nowPage.equals("")) {
//			nowPage = "1";
//		} else if (cntPerPage.equals("")) {
//			cntPerPage = "5";
//		}
		//pvo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		List<LibVO> bookList = libDAO.selectList(pvo);
		model.addAttribute("paging", pvo);
		model.addAttribute("bookList", bookList);
		
		return "lib/book_list";
	}
	
	
//	@RequestMapping(value="/list/*",method = RequestMethod.GET)
//	public String bookListPaging(Model model,
//		@RequestParam(value="nowPage",required=false) String nowPage,@RequestParam(value="cntPerPage",required=false) String cntPerPage) {
//		PagingVO pvo;
//		System.out.println("geeee");
//		System.out.println("nowpage"+nowPage);
////		System.out.println(request.getParameter("nowPage"));
////		if (request.getParameter("nowPage")==null||request.getParameter("nowPage").equals("null")) {
////			nowPage = request.getParameter("nowPage");
////			cntPerPage = request.getParameter("nowPage");
////		}else if(request.getParameter("nowPage").equals("")){
////			System.out.println("dkdkdk");
////		}
//		//List<LibVO> bookList = libDAO.allBookList();
//		
//		int total = libDAO.count();
//		if (nowPage==null && cntPerPage==null) {
//			System.out.println("nulllll");
//			nowPage = "1";
//			cntPerPage = "3";
//		}
////		else if(nowPage!=null && cntPerPage!=null){
////			nowPage=String.valueOf(Integer.valueOf(nowPage));
////			cntPerPage="5";
////		}
//		
////		else if (nowPage.equals("")) {
////			nowPage = "1";
////		} else if (cntPerPage.equals("")) {
////			cntPerPage = "5";
////		}
//		pvo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
//		List<LibVO> bookList = libDAO.selectList(pvo);
//		
//		model.addAttribute("paging", pvo);
//		model.addAttribute("bookList", bookList);
//		return "lib/book_list";
//	}
	//리스트 정상 동작
//	@RequestMapping(method = RequestMethod.GET)
//	public String bookList(Model model, HttpServletRequest request) {
//		PagingVO pvo;
//		String nowPage = "";
//		String cntPerPage = "";
//		System.out.println(request.getParameter("nowPage"));
//		if (request.getParameter("nowPage")==null||request.getParameter("nowPage").equals("null")) {
//			nowPage = request.getParameter("nowPage");
//			cntPerPage = request.getParameter("nowPage");
//		}else if(request.getParameter("nowPage").equals("")){
//			System.out.println("dkdkdk");
//		}
//		//List<LibVO> bookList = libDAO.allBookList();
//		
//		int total = libDAO.count();
//		System.out.println(nowPage);
//		System.out.println(cntPerPage);
//		if (nowPage==null && cntPerPage==null) {
//			nowPage = "1";
//			cntPerPage = "5";
//		} else if (nowPage.equals("")) {
//			nowPage = "1";
//		} else if (cntPerPage.equals("")) {
//			cntPerPage = "5";
//		}
//		pvo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
//		List<LibVO> bookList = libDAO.selectList(pvo);
//		model.addAttribute("paging", pvo);
//		model.addAttribute("bookList", bookList);
//		return "lib/book_list";
//	}
	// 페이징 전 정상 작동
//	@RequestMapping(method=RequestMethod.GET)
//	public String bookList(Model model) {
//			List<LibVO> bookList=libDAO.allBookList();
//			//PagingVO pVo=libDAO.count();
//			model.addAttribute("bookList",bookList);
//			return "lib/book_list";
//	}

//	@RequestMapping(method=RequestMethod.GET)
//	public String searchBookList(Model model,@ModelAttribute("bookList") LibVO lib) {
//			
//
////			for(int selectBookCount = 0; selectBookCount<=bookList.size(); selectBookCount++) {
////				bookList.get(selectBookCount).getImage();
////			}
//			
//			model.addAttribute("bookList",lib);
//			return "lib/book_list";
//	}
//	

//	@RequestMapping(method = RequestMethod.GET, params = { "search", "keyword" })
//	public String bookList(Model model, @RequestParam("search") String search,
//			@RequestParam("keyword") String keyword) {
//		List<LibVO> bookList = libDAO.allBookList();
//
////			for(int selectBookCount = 0; selectBookCount<=bookList.size(); selectBookCount++) {
////				bookList.get(selectBookCount).getImage();
////			}
//
//		model.addAttribute("bookList", bookList);
//		return "lib/book_list";
//	}

}
