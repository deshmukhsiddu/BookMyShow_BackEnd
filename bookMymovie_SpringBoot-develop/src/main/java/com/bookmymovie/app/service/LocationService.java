/**
 * 
 */
package com.bookmymovie.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookmymovie.app.entity.Locations;

/**
 * @author Sidramesh.
 *
 */
@Service
public interface LocationService {
	
	public List<Locations> getAllLocations();
	
	public boolean addLocation(Locations location);
	
	public void updateLocation(Integer locid);

}
