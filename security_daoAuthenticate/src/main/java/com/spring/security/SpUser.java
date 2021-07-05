package com.spring.security;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SpUser {
	private String userid;
	private String email;
	private boolean enabled;
	private String password;
	
	private List<SpUserAuthority> authorities;
}
