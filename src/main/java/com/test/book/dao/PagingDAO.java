package com.test.book.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PagingDAO {
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public PagingDAO(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate=sqlSessionTemplate;
	}
	
	
}
