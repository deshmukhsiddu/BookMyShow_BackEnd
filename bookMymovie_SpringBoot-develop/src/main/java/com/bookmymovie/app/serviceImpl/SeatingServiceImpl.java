package com.bookmymovie.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmymovie.app.entity.Seating;
import com.bookmymovie.app.repository.SeatingRepository;
import com.bookmymovie.app.service.SeatingService;

@Service
public class SeatingServiceImpl implements SeatingService {

	@Autowired
	private SeatingRepository seatingRepository;

	public List<Seating> listAll() {
		return seatingRepository.findAll();
	}

	public Seating add(Seating seating) {
		Seating vec = seatingRepository.save(seating);
		return vec;
	}

	public int getSeatingCost(String seating_type) {
		String cost = seatingRepository.getSeatingCost(seating_type);
		return Integer.parseInt(cost);
	}
}
