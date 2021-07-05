package com.spring.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User {

	
	private MemberVO memberVO;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomUser(MemberVO memberVO) {
		
		super(memberVO.getUserid(), memberVO.getUserpw(), 
				memberVO.getAuthList()
						.stream() //stream형태로 바꿈
						.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList())); //원하는 상태로 수집
		this.memberVO=memberVO;
	}
	
}
