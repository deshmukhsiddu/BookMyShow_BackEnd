package com.bookmymovie.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmymovie.app.entity.Admin;
import com.bookmymovie.app.service.AdminService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService service;

	@PostMapping("/admin")
	public ResponseEntity<Boolean> checkadmin(@RequestBody Admin admin) {
		return new ResponseEntity<Boolean>(service.isAdmin(admin), HttpStatus.OK);
	}
}
