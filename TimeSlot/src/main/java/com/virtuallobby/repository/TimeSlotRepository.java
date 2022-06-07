package com.virtuallobby.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.virtuallobby.entity.BookingDetails;

public interface TimeSlotRepository extends CrudRepository<BookingDetails, Integer> {
	@Query(
			  value = "SELECT u.timeslot FROM BookingDetails u WHERE u.shopid = :shopid AND u.bookingdate = CURRENT_DATE")
	List<String> getTimeSlotByShopId(int shopid);
	
}
