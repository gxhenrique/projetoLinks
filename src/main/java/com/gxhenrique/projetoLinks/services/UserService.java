package com.gxhenrique.projetoLinks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxhenrique.projetoLinks.entity.User;
import com.gxhenrique.projetoLinks.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> fidAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		
		Optional<User> obj = userRepository.findById(id);
		
		return obj.get();
	}
	
	public void delete(Long id) {
		
		userRepository.deleteById(id);
	}
	
	public User postUser(User user) {
		return userRepository.save(user);
	}
	
	public User putUser(Long id, User user) {
		User entity = userRepository.findById(id).get();
		updateData(entity, user);
		return userRepository.save(entity);
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setUsername(user.getUsername());
		entity.setEmail(user.getEmail());
		entity.setPassword(user.getPassword());
		entity.setPhotoUrl(user.getPhotoUrl());
		
		
	}
}
