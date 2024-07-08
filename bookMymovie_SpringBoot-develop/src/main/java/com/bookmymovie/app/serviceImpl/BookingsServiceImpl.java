package com.bookmymovie.app.serviceImpl;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmymovie.app.entity.Bookings;
import com.bookmymovie.app.repository.BookingsRepository;
import com.bookmymovie.app.service.BookingsService;
import com.bookmymovie.app.service.EmailService;
import com.bookmymovie.app.service.SlotsService;
import com.bookmymovie.app.service.SeatingService;

@Service
public class BookingsServiceImpl implements BookingsService {

	@Autowired
	private BookingsRepository bookingsRepository;

	@Autowired
	private SlotsService slotservice;

	@Autowired
	private SeatingService seatingService;

	@Autowired
	private EmailService mailservice;

	public Bookings addBooking(Bookings booking) {
		Bookings currentBooking = bookingsRepository.save(booking);
		// mailservice.sendEmail(currentBooking);
		slotservice.updateSlot(booking);
		int duration = currentBooking.getDuration();
		Bookings currBooking = currentBooking;
		currBooking.setDuration(duration);
		int seatingCost = seatingService.getSeatingCost(currBooking.getSeating_type());
		int cost = duration * seatingCost;
		currBooking.setCost(String.valueOf(cost));
		bookingsRepository.save(currBooking);
		return currentBooking;
	}

	public List<Bookings> getAllBookings() {
		return bookingsRepository.findAll();
	}

	public List<Bookings> getAllUsersByEmail(String email) {
		return bookingsRepository.listByUsers(email);
	}

	public boolean endBooking(Integer bookingid) {
		bookingsRepository.endBooking(bookingid);
		int duration = bookingsRepository.findById(bookingid).get().getDuration();
		Bookings currentBooking = bookingsRepository.findById(bookingid).get();
		currentBooking.setDuration(duration);
		int seatingCost = seatingService.getSeatingCost(currentBooking.getSeating_type());
		int cost = duration * seatingCost;
		currentBooking.setCost(String.valueOf(cost));
		bookingsRepository.save(currentBooking);
		slotservice.rollbackSlot(currentBooking.getSlotid());
		return true;
	}

	public String[] getDate() {
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		String time = sd.format(date);
		String[] datearr = time.split("-");
		return (datearr);
	}

	public String[] getTime() {
		SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		String time = sd.format(date);
		String[] timearr = time.split(":");
		return (timearr);
	}

	public String[] splitDate(String date) {
		return date.split("-");
	}

	public String[] splittime(String time) {
		return time.split(":");
	}

	public int getDuration(String[] time1, String[] time2, String[] date1, String[] date2) {
		return 10;
	}
}
