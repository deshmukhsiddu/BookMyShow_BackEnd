/**
 * 
 */
package com.bookmymovie.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookmymovie.app.entity.Bookings;

/**
 * @author Tanaji.
 *
 */
@Service
public interface BookingsService {
	
	public List<Bookings> getAllBookings();

	public Bookings addBooking(Bookings booking);
		
	public List<Bookings> getAllUsersByEmail(String email);
	
	public boolean endBooking(Integer bookingid);
}
