package com.test.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.book.model.PagingVO;

@Service
public class PagingService {
	
	PagingVO pvo;
	
	public PagingVO paging(String nowPage, String cntPerPage, int total){
		System.out.println("181818181818118");
		if (nowPage==null && cntPerPage==null) {
			nowPage = "1";
			cntPerPage = "3";
		}
		pvo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		return pvo;
	}
}
