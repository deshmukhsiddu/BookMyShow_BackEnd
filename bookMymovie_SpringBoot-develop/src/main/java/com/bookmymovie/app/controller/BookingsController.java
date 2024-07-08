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

import com.bookmymovie.app.entity.Bookings;
import com.bookmymovie.app.service.BookingsService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class BookingsController {

	@Autowired
	private BookingsService service;

	@PostMapping("/bookings/add")
	public Bookings add(@RequestBody Bookings booking) {
		return service.addBooking(booking);
	}

	@GetMapping("/bookings")
	public List<Bookings> listAll() {
		return service.getAllBookings();
	}

	@GetMapping("bookings/getByUser/{email}")
	public List<Bookings> listByUsers(@PathVariable String email) {
		return service.getAllUsersByEmail(email);
	}

	@GetMapping("/bookings/endBooking/{bookingid}")
	public boolean endBooking(@PathVariable Integer bookingid) {
		return service.endBooking(bookingid);
	}

	@GetMapping("/bookings/allBookings")
	public List<Bookings> allBookings() {
		return service.getAllBookings();
	}

}
