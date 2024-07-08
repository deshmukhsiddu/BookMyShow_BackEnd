/**
 * 
 */
package com.bookmymovie.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookmymovie.app.entity.Bookings;
import com.bookmymovie.app.entity.Slots;

/**
 * @author Tanaji.
 *
 */
@Service
public interface SlotsService {
	
	public List<Slots> getAllSlots();
	
	public boolean addSlot(Slots slot);
	
	public List<Slots> getSlotByLocationId(Integer locationid);
	
	public void updateSlot(Bookings booking);
	
	public void rollbackSlot(String slotid);

}
