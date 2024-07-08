package com.bookmymovie.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmymovie.app.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{

}
