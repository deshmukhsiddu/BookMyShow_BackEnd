package com.bookmymovie.app.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Users {
	@Id 
	private String email;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "mobno")
	private String mobno;

	@Column(name = "password")
	private String password;

	public Users() {
	}

	public Users(String email, String fullname, String mobno, String password) {
		super();
		this.email = email;
		this.fullname = fullname;
		this.mobno = mobno;
		this.password = password;
	}
	
}
