package com.bookmymovie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookmymovie.app.entity.Seating;
import com.bookmymovie.app.service.SeatingService;


@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class SeatingController {
	
	@Autowired
	private SeatingService service;
	
	@GetMapping("/seating")
	public List<Seating> list(){
		return service.listAll();
	}
	
	@PostMapping("/seating/add")
	public ResponseEntity<Seating> add(@RequestBody Seating seating){
		return new ResponseEntity<Seating>(service.add(seating),HttpStatus.OK);
	}
}
