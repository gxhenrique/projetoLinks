package com.gxhenrique.projetoLinks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gxhenrique.projetoLinks.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {


	Optional<User> findByUsername(String username);
}
	