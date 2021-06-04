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
		
		//�Է�
		BookVO vo=new BookVO();
		vo.setCode(1005);
		vo.setTitle("��������");
		vo.setWriter("���ȣ");
		vo.setPrice(25000);
		System.out.println(service.insert(vo)?"����":"����");
		
		//����
		BookVO update=new BookVO();
		update.setCode(1005);
		update.setPrice(35000);
		System.out.println(service.update(update)?"����":"����");
	
		
		//����
		System.out.println(service.delete(1004)?"����":"����");
		
		
		
		//�������� �ϳ� ��������
		System.out.println(service.getRow(1005));
		
		
		//��ü ����Ʈ
		List<BookVO> list=service.getList();
		
		for(BookVO vo1:list) {
			System.out.println(vo1);
		}
	}

}