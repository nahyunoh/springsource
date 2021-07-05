package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.MemberVO;
import com.spring.mapper.MemberMapper;

@Service("service") //작업
public class MemberServiceImpl implements MemberService {
	
	@Autowired //주입
	private MemberMapper mapper;
	@Override
	public MemberVO isLogin(String userid, String currentPassword) {
		return mapper.isLogin(userid, currentPassword);
	}

	@Override
	public boolean insert(MemberVO vo) {
		return mapper.insert(vo)>0? true:false;
	}

	@Override
	public boolean update(String userid, String currentPassword, String changePassword) {
		return mapper.update(userid, currentPassword, changePassword)>0?true:false;
	}

	@Override
	public boolean remove(String userid, String currentPassword) {
		return mapper.remove(userid, currentPassword)>0?true:false;
	}

}
