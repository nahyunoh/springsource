package com.spring.service;

import java.util.List;

import com.spring.domain.BookVO;

public interface BookService {
	
	public boolean insert(BookVO vo);
	public boolean delete(int code);
	public boolean update(int code, int price);
	public List<BookVO> list();
	public List<BookVO> search(String criteria, String keyword);
}
