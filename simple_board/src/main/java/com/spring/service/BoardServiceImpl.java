package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.domain.BoardVO;
import com.spring.persistance.BoardDAO;

//@Component("service")
@Service("service") //db작업 해주는 애들 = @Service 추가로 좀 더 명확한 뜻 가지고 나옴
public class BoardServiceImpl implements BoardService {
	
	@Autowired //만들어진 것을 주입
	private BoardDAO dao;
	
	@Override
	public boolean insert(BoardVO vo) {
		return dao.insertBoard(vo) > 0?true:false;
	}

	@Override
	public boolean update(BoardVO vo) {
		return dao.updateBoard(vo) > 0?true:false;
	}

	@Override
	public boolean delete(int bno) {
		return dao.deleteBoard(bno) > 0?true:false;
	}

	@Override
	public BoardVO getRow(int bno) {
		return dao.select(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return dao.list();
	}

}
