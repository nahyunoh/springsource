package com.spring.mapper;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.MemberVO;

public interface MemberMapper {
	//로그인
	public MemberVO isLogin(@Param("userid")String userid, @Param("currentPassword")String currentPassword);
	//회원가입
	public int insert(MemberVO vo);
	//비밀번호 수정
	public int update(@Param("userid")String userid, @Param("currentPassword")String currentPassword, @Param("changePassword")String changePassword);
	//회원탈퇴
	public int remove(@Param("userid")String userid,@Param("currentPassword")String currentPassword);
	
}
