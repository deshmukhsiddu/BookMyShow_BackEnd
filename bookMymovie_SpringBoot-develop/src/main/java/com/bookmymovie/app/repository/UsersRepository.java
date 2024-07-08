package com.bookmymovie.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmymovie.app.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String>{
	
}
