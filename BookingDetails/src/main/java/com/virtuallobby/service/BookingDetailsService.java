package com.virtuallobby.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.entity.BookingDetails;
import com.virtuallobby.repository.BookingDetailsRepository;

@Service
public class BookingDetailsService {
	@Autowired
	BookingDetailsRepository bookingDetailsRepository;

	public FinalResponse bookingDetails(BookingDetails bookingDetails) {
		FinalResponse finalResponse = new FinalResponse();
		try {
		BookingDetails usersInfo = bookingDetailsRepository.save(bookingDetails);
		if(usersInfo != null) {
			finalResponse.setMessage("Booking details submitted Successfully");
			finalResponse.setStatus(true);
			return finalResponse;
		}else {
			finalResponse.setMessage("Unable to submit booking details");
			finalResponse.setStatus(true);
			return finalResponse;
		}
		}catch(Exception e) {
			finalResponse.setMessage("Unable to submit booking details");
			finalResponse.setStatus(false);
			return finalResponse;
		}
	}
}
