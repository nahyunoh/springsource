package com.spring.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	
	private SpUser spUser;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomUser(SpUser spUser) {
		
		super(spUser.getUserid(), spUser.getPassword(), 
				spUser.getAuthorities()
						.stream() //stream형태로 바꿈
						.map(auth -> new SimpleGrantedAuthority(auth.getAuthority())).collect(Collectors.toList())); //원하는 상태로 수집
		this.spUser=spUser;
	}
	
}
