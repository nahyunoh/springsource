package com.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Criteria {
	private int pageNum;//사용자가 클릭하는 페이지 번호
	private int amount; //하나의 페이지에 보여줄 게시물 갯수
	
	//검색 부분 추가
	private String type; //검색조건 TCW
	private String keyword; //검색어 DATABASE
	
	public Criteria() {
		this(1,10);
	}
	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	public String[] getTypeArr() {
		//type=> return: null이면 빈 배열, 
		//		TCW => 	아니면 string 배열 {"T","C","W"} 개별로 분할시켜줌 (.split)
		return type==null?new String[] {} :type.split("");
	}
}
