package com.bookmymovie.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmymovie.app.entity.Bookings;
import com.bookmymovie.app.entity.Slots;
import com.bookmymovie.app.repository.LocationsRepository;
import com.bookmymovie.app.repository.SlotsRepository;
import com.bookmymovie.app.service.LocationService;
import com.bookmymovie.app.service.SlotsService;

@Service
public class SlotsServiceImpl implements SlotsService {

	@Autowired
	private SlotsRepository slotsRepository;

	@Autowired
	private LocationService locationservice;

	@Autowired
	private LocationsRepository locationsRepository;

	public List<Slots> getAllSlots() {
		return slotsRepository.findAll();
	}

	public boolean addSlot(Slots slot) {
		if (locationsRepository.existsById(slot.getLocationid())) {
			if (slotsRepository.existsById(slot.getSlotid())) {
				return false;
			} else {
				slotsRepository.save(slot);
				locationservice.updateLocation(slot.getLocationid());
				return true;
			}
		} else {
			return false;
		}

	}

	public List<Slots> getSlotByLocationId(Integer locationid) {
		return slotsRepository.slotById(locationid);
	}

	public void updateSlot(Bookings booking) {
		slotsRepository.updateSlot(1, booking.getTime(), booking.getDuration(), booking.getSlotid());
	}

	public void rollbackSlot(String slotid) {
		slotsRepository.rollbackSlot(slotid);
	}
}
