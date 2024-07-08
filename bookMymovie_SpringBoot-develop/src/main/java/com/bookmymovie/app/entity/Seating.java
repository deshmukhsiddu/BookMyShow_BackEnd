package com.bookmymovie.app.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Seating {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seatingid;
	
	@Column(name = "seating_type")
	private String seating_type;
	
	@Column(name = "cost")
	private String cost;
		
	public Seating() {
		
	}
	
	public Seating(Integer seatingid, String seating_type, String cost) {
		super();
		this.seatingid = seatingid;
		this.seating_type = seating_type;
		this.cost = cost;
	}
}
