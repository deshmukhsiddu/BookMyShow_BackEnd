package com.bookmymovie.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmymovie.app.entity.Locations;
import com.bookmymovie.app.repository.LocationsRepository;
import com.bookmymovie.app.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationsRepository locationsRepository;

	public List<Locations> getAllLocations() {
		return locationsRepository.findAll();
	}

	public boolean addLocation(Locations location) {
		Integer count = locationsRepository.findCountOfLocation(location.getLocation_name());
		if (count > 0) {
			return false;
		} else {
			locationsRepository.save(location);
			return true;
		}
	}

	public void updateLocation(Integer locid) {
		locationsRepository.updateLoc(locid);
	}
}
