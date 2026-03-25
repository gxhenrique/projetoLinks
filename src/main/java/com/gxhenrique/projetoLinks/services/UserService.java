package com.gxhenrique.projetoLinks.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxhenrique.projetoLinks.entity.User;
import com.gxhenrique.projetoLinks.exceptions.ResourceNotFoundException;
import com.gxhenrique.projetoLinks.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> fidAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {

		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Usuario não encotrado com o id: " + id));

	}

	public void delete(Long id) {
		findById(id);
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
		entity.setBio(user.getBio());
		entity.setPhotoUrl(user.getPhotoUrl());

	}

	public User patchUser(Long id, User user) {
		User entity = userRepository.findById(id).get();
		patchUpdateData(entity, user);
		return userRepository.save(entity);
	}

	private void patchUpdateData(User entity, User user) {

		if (user.getName() != null) {
			entity.setName(user.getName());
		}

		if (user.getUsername() != null) {
			entity.setUsername(user.getUsername());
		}

		if (user.getEmail() != null) {
			entity.setEmail(user.getEmail());
		}

		if (user.getPassword() != null) {
			entity.setPassword(user.getPassword());
		}

		if (user.getBio() != null) {
			entity.setBio(user.getBio());
		}

		if (user.getPhotoUrl() != null) {
			entity.setPhotoUrl(user.getPhotoUrl());
		}

	}
}
