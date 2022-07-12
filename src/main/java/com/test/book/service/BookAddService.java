package com.test.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.book.dao.LibDAO;
import com.test.book.exception.AlreadyExistingBookException;
import com.test.book.model.BookRequest;
import com.test.book.model.LibVO;

@Service
public class BookAddService {
	private LibDAO libDao;
	
	@Autowired
	public BookAddService(LibDAO libDao) {
		this.libDao=libDao;
	}
	
	public void addBookService(BookRequest fileReq) {
		String realFileName="";
		LibVO lib=libDao.selectByIsbn(Integer.valueOf(fileReq.getIsbn()));
		if(lib != null) {
			System.out.println(lib.getIsbn());
			System.out.println("존재isbn");
			throw new AlreadyExistingBookException("이미 존재하는 ISBN" +fileReq.getIsbn());
		}else {
			realFileName=fileReq.getImage().getOriginalFilename();
			LibVO newlib=new LibVO(fileReq.getTitle(),fileReq.getLink(),realFileName,fileReq.getAuthor(),
					fileReq.getPrice(),fileReq.getPublisher(),fileReq.getIsbn(),fileReq.getDescription());
			libDao.insert(newlib);
		}
		
	}
	public boolean selectByIsbn(BookRequest fileReq) {
		LibVO lib=libDao.selectByIsbn(Integer.valueOf(fileReq.getIsbn()));
		if(lib != null) {
			return false;
		}
		return true;
	}
}
