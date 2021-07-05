package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.ChangeVO;
import com.spring.domain.LoginVO;
import com.spring.service.MemberService;

import lombok.extern.log4j.Log4j2;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Log4j2
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService service;
	//login.jsp
	@GetMapping("/login")
	public void loginGet() {
		log.info("login ������ ��û");
	}
	
	//�α��� ���� �������� =>post
	@PostMapping("/login")
	public String loginPost(String userid,@RequestParam("current_password")String password, HttpSession session,RedirectAttributes rttr) {
		log.info("login ��û : "+ userid +" "+ password);
		
		LoginVO login=service.login(userid, password);
		
		if(login==null) {
			rttr.addFlashAttribute("error","���̵� ��й�ȣ�� Ȯ���� �ּ���");
			return "redirect:login";
		}else {
			session.setAttribute("login", login);
			return "redirect:/";
		}
		
	}
	
	// member/change-pwd =>modify.jsp
	@GetMapping("/change-pwd")
	public String changePwd() {
		log.info("��й�ȣ ���� ������ ��û");
		return "/member/modify";
	}
	
	
	@PostMapping("/change-pwd")
	public String changePwdPost(ChangeVO change, HttpSession session,RedirectAttributes rttr) {
		
		log.info("��й�ȣ ����"+change);
		
		if(change.newPasswordEqualConfirmPassword()) {
			if(service.update(change)) {//��й�ȣ ���� ����
				session.invalidate();
				return "redirect:/member/login";
			}else {//���� ��й�ȣ ����'
				rttr.addFlashAttribute("error","��й�ȣ�� Ȯ���� �ּ���");
				return "redirect:/member/change-pwd";
			}
		}else {//�����й�ȣ�� Ȯ�������й�ȣ�� �ٸ� ���
			rttr.addFlashAttribute("error","���� ��й�ȣ�� �ٸ��ϴ�");
			return "redirect:/member/change-pwd";
		}
		
	}
	
	
	//logout => session���� �� index �����ֱ�
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		log.info("�α׾ƿ� ��û");
		session.invalidate();
		//session.removeAttribute("login");
		return "redirect:/";
	}

	//leave
	   @GetMapping("/leave")
	   public void leave() {
	      log.info("ȸ�� Ż�� �� ��û");
	   }
	   
	   @PostMapping("/leave")
	   public String leavePost(String userid,@RequestParam("current_password")String password,HttpSession session) {
		   log.info("ȸ��Ż�� ��û" + userid +" "+password);
		   
		   if(service.leave(userid, password)) {
			   session.invalidate();
			   return "redirect:/";
		   }else {
			   return "/member/leave";
		   }
	   }
	   
	   
}