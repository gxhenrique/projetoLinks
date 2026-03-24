package com.gxhenrique.projetoLinks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gxhenrique.projetoLinks.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
	