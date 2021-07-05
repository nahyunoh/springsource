package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.LoginVO;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/member/*")
public class MemberController {

   
   @RequestMapping("/register")
   public void register() {
      log.info("register 요청");  
  }   
   @RequestMapping("/modify")
   public String update() {
      log.info("update 요청");
      
      return "member/member_modify";
   }
   
   //@RequestMapping("/login") => 방식을 지정하지 않아 get/post  둘 다 받음, 둘다 응답
   @GetMapping("/login") //http://localhost:8081/member/login
   public void loginGet() {
	   log.info("login 요청"); // 	member/login jsp를 찾는데 그대로 사용됨
   }
   
   //사용자의 입력값 가져오기 -1) HttpServletRequest req 2) 변수명(폼 필드 이름과 일치) 3)VO
   
   //1)
//   @PostMapping("/login") //http://localhost:8081/member/login +post
//   public void loginPost(HttpServletRequest req) {
//	   log.info("login form 데이터 가져오기"); // 405안뜸	member/login jsp를 찾는데 그대로 사용됨
//	   log.info("userid :" +req.getParameter("userid")); 
//	   log.info("password :" +req.getParameter("password")); 
//   }
   
   //2)
//	   @PostMapping("/login") //http://localhost:8081/member/login +post
//	   public void loginPost(@RequestParam("userid")String userid, String password) {
//		   log.info("login form 데이터 가져오기"); // 405안뜸	member/login jsp를 찾는데 그대로 사용됨
//		   log.info("userid :" +userid);  //login.jsp의 name이 userid, password
//		   log.info("password :" +password); 
//   }
   
   //3)VO
//	   @PostMapping("/login") //http://localhost:8081/member/login +post
//	   public String loginPost(LoginVO vo, Model model) {
//		   log.info("login form 데이터 가져오기"); // 405안뜸	member/login jsp를 찾는데 그대로 사용됨
//		   log.info("userid :" +vo.getUserid());  //login.jsp의 name이 userid, password
//		   log.info("password :" +vo.getPassword()); 
//		   
//		   model.addAttribute("page",1);
//		   
//		   return "result"; //	forward 방식 /	result 페이지 지시 /WEB-INF/views/result.jsp
//}
	   @PostMapping("/login") 
	   public String loginPost(@ModelAttribute("vo")LoginVO vo, Model model) {
		   //LoginVO vo=>이름을 지정하고 싶다면?
		   log.info("login form 데이터 가져오기"); 
		   log.info("userid :" +vo.getUserid());  
		   log.info("password :" +vo.getPassword()); 
		   
		   model.addAttribute("page",1);
		   
		   return "result"; 
	}
   
   
}