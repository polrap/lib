package com.test.book.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.book.model.LibVO;
import com.test.book.model.PagingVO;

@Repository
public class LibDAO {
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public LibDAO(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate=sqlSessionTemplate;
	}
	public void insert(LibVO book) {
		sqlSessionTemplate.insert("insert", book);
	}
	public LibVO selectByIsbn(int isbn) {
		return sqlSessionTemplate.selectOne("selectByIsbn", Integer.valueOf(isbn));
	}
	public LibVO selectByIndex(Long index) {
		return sqlSessionTemplate.selectOne("selectByIndex", index);
	}
	public List<LibVO> allBookList() {
		return sqlSessionTemplate.selectList("list");
	}
	public List<LibVO> list(String keyword) {
		return sqlSessionTemplate.selectList("booklist",keyword);
	}
	public List<LibVO> listColumn(Map map){
		return sqlSessionTemplate.selectList("listColumn", map);
				//selectMap("listDefault",searchkey,keyword);
	}
	public List<LibVO> listDefault(String keyword){
		return sqlSessionTemplate.selectList("listDefault", keyword);
	}
	public int count(){
		return sqlSessionTemplate.selectOne("count");
	}
	public List<LibVO> selectList(PagingVO vo){
		return sqlSessionTemplate.selectList("selectList", vo);
	}
	public List<LibVO> selectListCase(Map map){
		return sqlSessionTemplate.selectList("selectListCase",map);
	}
}
