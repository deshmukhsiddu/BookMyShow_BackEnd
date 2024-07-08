package com.bookmymovie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmymovie.app.entity.Locations;
import com.bookmymovie.app.service.LocationService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class LocationsController {
	
	@Autowired
	private LocationService service;
	
	@GetMapping("/locations")
	public List<Locations> list(){
		return service.getAllLocations();
	}

	@PostMapping("/locations/add")
	public boolean add(@RequestBody Locations location) {
		return service.addLocation(location);
	}
	
}
