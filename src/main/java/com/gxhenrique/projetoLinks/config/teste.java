package com.gxhenrique.projetoLinks.config;

import com.gxhenrique.projetoLinks.security.jwt.JwtUtil;

public class teste {

	public static void main(String[] args) {
		
		JwtUtil jwtUtil = new JwtUtil();
		
		String token = jwtUtil.generateToken("teste@email.com");
		
		System.out.println(token);

	}

}
