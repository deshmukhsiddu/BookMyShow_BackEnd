/**
 * 
 */
package com.bookmymovie.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookmymovie.app.entity.Seating;

/**
 * @author Tanaji.
 *
 */
@Service
public interface SeatingService {
	
	public List<Seating> listAll();
	
	public Seating add(Seating seating);
	
	public int getSeatingCost(String seating_type);

}
