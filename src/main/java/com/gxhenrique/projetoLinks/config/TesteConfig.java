package com.gxhenrique.projetoLinks.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gxhenrique.projetoLinks.entity.Link;
import com.gxhenrique.projetoLinks.entity.User;
import com.gxhenrique.projetoLinks.enums.UserRole;
import com.gxhenrique.projetoLinks.repository.LinkRepository;
import com.gxhenrique.projetoLinks.repository.UserRepository;


@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner {
	

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LinkRepository linkRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	

	@Override
	public void run(String... args) throws Exception {
		
		
		User user = new User(null, "Bob", "bob2025", "bob@email.com", passwordEncoder.encode("1234556"), "isso é um teste de resquest", "urlDafoto");
		user.setRole(UserRole.USER);
		User user2 = new User(null, "Maria", "maria20", "maria@email.com", passwordEncoder.encode("1234556"), "isso é um teste de resquest", "urlDafoto");
		user2.setRole(UserRole.USER);
		User user3 = new User(null, "Emily", "emily25", "emily@email.com",passwordEncoder.encode("12345678"), "teste de role", "urlDafoto");
		user3.setRole(UserRole.ADMIN);
		
		userRepository.saveAll(Arrays.asList(user, user2,user3));
		
		Link l1 = new Link(null, "Facebook", "https://www.facebook.com", true, 1, user2);
		Link l2 = new Link(null, "Instagram", "https://www.instagram.com", true, 2, user2);
		Link l3 = new Link(null, "Linkedin", "https://www.linkedin.com", true, 1, user);
		
		linkRepository.saveAll(Arrays.asList(l1,l2,l3));
		
	}
}
