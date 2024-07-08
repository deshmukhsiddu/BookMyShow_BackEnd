package com.bookmymovie.app.controller;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmymovie.app.entity.Users;
import com.bookmymovie.app.service.EmailService;
import com.bookmymovie.app.service.UsersService;

import freemarker.template.TemplateException;

@CrossOrigin
@RequestMapping(value="/api")
@RestController
public class UsersController {

	@Autowired
	private UsersService service;

	@Autowired
	private EmailService mailservice;

	@GetMapping("/users")
	public List<Users> list() {
		return service.getAllUsers();
	}

	@GetMapping("/users/{email}")
	public ResponseEntity<Users> get(@PathVariable String email) {
		try {
			Users users = service.getUserEmailById(email);
			return new ResponseEntity<Users>(users, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/users/signup")
	public ResponseEntity<Boolean> add(@RequestBody Users users) {
		if (service.checkExistingUser(users.getEmail()) == false) {
			service.saveUser(users);
			try {
				mailservice.signupMail(users);
			} catch (TemplateException | MessagingException | IOException e) {
				e.printStackTrace();
			}
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
	}

	@GetMapping("/users/getname/{email}")
	public String getUser(@PathVariable String email) {
		String mail = service.getUserEmailById(email).getFullname();
		return mail;
	}

	@DeleteMapping("/users/{email}")
	public void delete(@PathVariable String email) {
		service.deleteUser(email);
	}

	@PutMapping("/users/{email}")
	public ResponseEntity<Users> update(@RequestBody Users users, @PathVariable String email) {
		try {
			Users existUser = service.getUserEmailById(email);
			System.out.print(existUser);
			service.saveUser(users);
			return new ResponseEntity<Users>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/users/login")
	public boolean check(@RequestBody Users users) {
		return service.checkUserLogin(users.getEmail(), users.getPassword());

	}

}
