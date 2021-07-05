package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.ChangeVO;
import com.spring.domain.LeaveVO;
import com.spring.domain.MemberVO;
import com.spring.service.MemberService;

import lombok.extern.log4j.Log4j2;
@RestController
@Log4j2
public class MemberRestController {
	
	
	@Autowired	
	private MemberService service;
	
	@PutMapping("/changepwd2")
	public ResponseEntity<String> changePwd(@RequestBody ChangeVO vo, HttpSession session){
		log.info("rest ����"+vo);
		
		if(vo.newPasswordEqualConfirmPassword()) {
			if(service.update(vo)) {//��й�ȣ ���� ����
				session.invalidate();
				return new ResponseEntity<String>("success",HttpStatus.OK);
			}else {//���� ��й�ȣ ����'
				//rttr.addFlashAttribute("error","��й�ȣ�� Ȯ���� �ּ���");
				return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
			}
		}else {//�����й�ȣ�� Ȯ�������й�ȣ�� �ٸ� ���
			//rttr.addFlashAttribute("error","���� ��й�ȣ�� �ٸ��ϴ�");
			return new ResponseEntity<String>("not-equal", HttpStatus.BAD_REQUEST);	
		}
		
	}
	
	//leave
	   @DeleteMapping("/leave2")
	   public ResponseEntity<String> leavePost(@RequestBody LeaveVO vo,HttpSession session) {
		   log.info("ȸ��Ż�� ��û" + vo);
		   
		   if(service.leave(vo.getUserid(),vo.getCurrent_password())) {
			   session.invalidate();
			   return new ResponseEntity<String>("success",HttpStatus.OK);
		   }else {
			   return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
		   }
	   }
}