package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BookVO;
import com.spring.service.BookService;

import lombok.extern.log4j.Log4j2;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Log4j2

public class BookController {
	
	@Autowired
	private BookService service;
	
	//전체도서 목록 가져오기 - list.jsp
	@GetMapping("/list")
	public void getList(Model model) {
		log.info("도서 목록 가져오기");
		
		List<BookVO> list =service.list();
		
		//list 객체에 담긴 값 list.jsp 에서 공유?
		//request.setAttribute + forward 동일한 효과
		model.addAttribute("list",list);
	}
	
	//도서 정보 입력하기 - 성공시 list 보여주기
	//				  실패시 index 보여주기
	@PostMapping("/insert")
	public String insertPost(BookVO vo) {
		log.info("도서 정보 입력"+vo);
		
		
		if(service.insert(vo)) {
			return "redirect:/list";
		}else {
			return "redirect:/";
		}
		
	}
	
	//도서 정보 삭제
	@PostMapping("/delete")
	public String deletePost(int code, RedirectAttributes rttr) {
		log.info("도서 정보 삭제 "+code);
		
		if(service.delete(code)) {
			return "redirect:/list";
		}else {
			rttr.addFlashAttribute("tab","delete");
			return "redirect:/";
		}
	}
	
	//도서 정보 수정
	@PostMapping("/update")
	public String modifyPost(int code, int price, RedirectAttributes rttr) {
		log.info("도서 정보 수정 "+code+" "+price);
		if(service.update(code, price)) {
			return "redirect:/list";
		}else {
			rttr.addFlashAttribute("tab","modify");
			return "redirect:/";
		}
	}
	
	//search+post => search.jsp 보여주기
	   @PostMapping("/search")
	   public void getSearchList(String criteria, String keyword, Model model) {
	      log.info("도서 검색 목록 가져오기");
	      
	      List<BookVO> list = service.search(criteria, keyword);
	      
	      //list객체에 담긴 값 search.jsp에 공유
	      model.addAttribute("list", list);
	   }
	
}
