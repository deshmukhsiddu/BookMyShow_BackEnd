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
public class Locations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locationid;
		
	@Column(name = "location_name")
	private String location_name;
	
	@Column(name = "slots")
    private Integer slots = 0;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "cast")
	private String cast;
	
	@Column(name = "bannerimage")
	private String bannerimage;
	
	public Locations() {
		
	}
	
	public Locations(Integer locationid, String location_name,Integer slots, String area,String cast,String bannerimage) {
		super();
		this.locationid = locationid;
		this.location_name = location_name;
		this.slots = slots;
		this.area = area;
		this.cast = cast;
		this.bannerimage = bannerimage;
		
	}
}
