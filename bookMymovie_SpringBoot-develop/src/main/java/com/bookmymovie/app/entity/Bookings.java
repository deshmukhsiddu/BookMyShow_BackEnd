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
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingid")
	private Integer bookingid;

	@Column(name = "email")
	private String email;

	@Column(name = "seating_type")
	private String seating_type;

	@Column(name = "seating_no")
	private String  seating_no;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "time")
	private String time;
	
	@Column(name = "duration")
	private Integer duration;
	
	@Column(name = "cost")
	private String cost = "0";
	
	@Column(name = "locationid")
	private Integer locationid;
	
	@Column(name = "slotid")
	private String slotid;

	@Column(name = "paid")
	private Integer paid = 0;
	
	@Column(name = "location_name")
	private String location_name = "";
	
	public Bookings() {

	}
	public Bookings(Integer bookingid, String email, String seating_type, String seating_no, String date, String time,
			Integer duration, String cost, Integer locationid, String slotid, Integer paid,String location_name) {
		super();
		this.bookingid = bookingid;
		this.email = email;
		this.seating_type = seating_type;
		this.seating_no = seating_no;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.cost = cost;
		this.locationid = locationid;
		this.slotid = slotid;
		this.paid = paid;
		this.location_name = location_name;
	}	
}
