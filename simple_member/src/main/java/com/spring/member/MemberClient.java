package com.spring.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.MemberVO;
import com.spring.service.MemberService;

public class MemberClient {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		MemberService service=(MemberService)ctx.getBean("service");

		
		
		//회원가입 insert -1
		System.out.println("-----회원가입-----");
//		MemberVO vo =new MemberVO();
//		vo.setUserid("user1234");
//		vo.setPassword("1234");
//		vo.setName("김유저");
//		vo.setGender("여");
//		vo.setEmail("user1234@gamil.com");
//		
//		boolean insertFlag=service.insert(vo);
//		System.out.println(insertFlag?"성공":"실패");
		
		//회원 가입-2
//		MemberVO vo =new MemberVO();
//		vo.setUserid("user56789");
//		vo.setPassword("5678");
//		vo.setName("박유저");
//		vo.setGender("남");
//		vo.setEmail("user5678@gamil.com");
//		
//		boolean insertFlag=service.insert(vo);
//		System.out.println(insertFlag?"성공":"실패");
		
		//비밀번호 수정
//		System.out.println("-----비밀번호 수정-----");
//		System.out.println(service.update("user1234", "user", "1234")?"성공":"실패");
		
		
		//회원 탈퇴
		System.out.println("-----회원 탈퇴-----");
//		boolean deleteFlag=service.remove("user1234", "1234");
//		System.out.println(deleteFlag?"성공":"실패");
		
		//로그인,,,,,,,오류,,,,,,,,
		System.out.println("-----로그인-----");
		MemberVO vo =new MemberVO();
		vo.setUserid("user1234");
		vo.setPassword("user");
		
		System.out.println(service.isLogin("user1234", "1234") != null?"성공":"실패");
		
	}

}
