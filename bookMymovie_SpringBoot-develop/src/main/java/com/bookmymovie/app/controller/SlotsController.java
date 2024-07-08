package com.bookmymovie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmymovie.app.entity.Slots;
import com.bookmymovie.app.service.SlotsService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class SlotsController {

	@Autowired
	private SlotsService service;

	@GetMapping("/slots")
	public List<Slots> listAll() {
		return service.getAllSlots();
	}

	@GetMapping("/slots/getbyid/{locationid}")
	public List<Slots> slotById(@PathVariable("locationid") Integer locationid) {
		return service.getSlotByLocationId(locationid);

	}

	@PostMapping("/slots/add")
	public boolean add(@RequestBody Slots slot) {
		return service.addSlot(slot);
	}
}
