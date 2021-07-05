package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookVO;
import com.spring.mapper.BookMapper;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookMapper mapper;
	
	@Override
	public boolean insert(BookVO vo) {
		return mapper.insert(vo)>0?true:false;
	}

	@Override
	public boolean delete(int code) {
		return mapper.delete(code)>0?true:false;
	}

	@Override
	public boolean update(int code, int price) {
		return mapper.update(code, price)>0?true:false;
	}

	@Override
	public List<BookVO> list() {
		return mapper.list();
	}

	@Override
	public List<BookVO> search(String criteria, String keyword) {
		return mapper.search(criteria, keyword);
	}

}
