package com.bookmymovie.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookmymovie.app.entity.Seating;

public interface SeatingRepository extends JpaRepository<Seating, Integer>{

	@Query("Select cost from Seating where seating_type = ?1")
	String getSeatingCost(String seating_type);
	
}
