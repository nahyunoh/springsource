package com.spring.book;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BookVO;
import com.spring.service.BookService;
import com.spring.service.BookServiceImpl;

public class BookClient {

	public static void main(String[] args) {
//		BookServiceImpl service=new BookServiceImpl();
//		BookVO vo=service.getRow(1000);
//		System.out.println(vo);
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		BookService service=(BookService) ctx.getBean("service");
		
		//입력
		BookVO vo=new BookVO();
		vo.setCode(1005);
		vo.setTitle("스프링웹");
		vo.setWriter("김시호");
		vo.setPrice(25000);
		System.out.println(service.insert(vo)?"성공":"실패");
		
		//수정
		BookVO update=new BookVO();
		update.setCode(1005);
		update.setPrice(35000);
		System.out.println(service.update(update)?"성공":"실패");
	
		
		//삭제
		System.out.println(service.delete(1004)?"성공":"실패");
		
		
		
		//도서정보 하나 가져오기
		System.out.println(service.getRow(1005));
		
		
		//전체 리스트
		List<BookVO> list=service.getList();
		
		for(BookVO vo1:list) {
			System.out.println(vo1);
		}
	}

}
