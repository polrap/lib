package com.test.book.model;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PagingVO {
	private int nowPage, startPage, endPage, total, cntPerPage, lastPage, start, end;
	private int cntPage; //하단의 페이지 갯수
	
	public PagingVO(int total, int nowPage, int cntPerPage) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcCntPage(total,cntPerPage);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
	}
	
	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int) Math.ceil((double)total / (double)cntPerPage)+1);
	}
	
	public void calcStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);
		if (getStartPage() < 1) {
			setStartPage(1);
		}
	}
	
	public void calcStartEnd(int nowPage, int cntPerPage) {
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage + 1);
	}
	public void calcCntPage(int total, int cntPerPage) {
		if(total%cntPerPage<0) {
			setCntPage(total/cntPerPage+1);
		}else {
			setCntPage(total/cntPerPage);
		}
		
	}
}
