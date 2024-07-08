package com.bookmymovie.app.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Slots {
	@Id
	private String slotid;
	
	@Column(name = "locationid")
	private Integer locationid;

	@Column(name = "slotno")
	private String slotno;
	
	@Column(name = "status")
	private Integer status = 0;
	
	@Column(name = "time")
	private String time = "0";
	
	@Column(name = "duration")
	private Integer duration = 0;
	
	public Slots() {
	}
	
	public Slots(String slotid, Integer locationid, String slotno, Integer status, String time, Integer duration) {
		super();
		this.slotid = slotid;
		this.locationid = locationid;
		this.slotno = slotno;
		this.status = status;
		this.time = time;
		this.duration = duration;
	}
	
}
