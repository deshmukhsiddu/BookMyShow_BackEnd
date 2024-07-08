package com.bookmymovie.app.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Admin {
	
	@Id
    @Column(name = "adminid")	
	private Integer adminid;

    @Column(name = "password")	
	private String password;
	
	public Admin() {

	}
		
}
