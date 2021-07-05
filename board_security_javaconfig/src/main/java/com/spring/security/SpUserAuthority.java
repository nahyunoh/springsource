package com.spring.security;

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
public class SpUserAuthority {
	private String userid;
	private String authority;
}
