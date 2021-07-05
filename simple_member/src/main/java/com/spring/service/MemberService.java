package com.spring.service;

import com.spring.domain.MemberVO;

public interface MemberService {
	//로그인, 회원가입, 비밀번호수정, 회원탈퇴
	public MemberVO isLogin(String userid, String currentPassword);
	public boolean insert(MemberVO vo);
	public boolean update(String userid, String currentPassword, String changePassword);
	public boolean remove(String userid,String currentPassword);
}
