package com.virtuallobby.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtuallobby.dto.BookingDetailsResp;
import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.entity.BookingDetails;
import com.virtuallobby.entity.UsersDetails;
import com.virtuallobby.repository.GetbookingDetailsRepository;
import com.virtuallobby.repository.LoginRepository;

@Service
public class GetbookingDetailsService {
	@Autowired
	GetbookingDetailsRepository getbookingDetailsRepository;
	
	@Autowired
	private LoginRepository loginRepository;

	public FinalResponse getbookingDetailsByShopId(Integer shopid) {
		FinalResponse finalResponse = new FinalResponse();
		List<BookingDetailsResp> bookingDetailsRespList = new ArrayList<>();
		try {
		List<BookingDetails> bookDetails = (ArrayList<BookingDetails>) getbookingDetailsRepository.findByShopid(shopid);
		if(bookDetails != null && !bookDetails.isEmpty()) {
			for(BookingDetails bookingDetails : bookDetails) {
				UsersDetails usersDetails = loginRepository.findById(bookingDetails.getUserid()).get();
				BookingDetailsResp bookingDetailsResp = new BookingDetailsResp();
				bookingDetailsResp.setBookingid(bookingDetails.getBookingid());
				bookingDetailsResp.setShopid(bookingDetails.getShopid());
				bookingDetailsResp.setUserid(usersDetails.getUserid());
				bookingDetailsResp.setSlotinterval(bookingDetails.getSlotinterval());
				bookingDetailsResp.setTimeslot(bookingDetails.getTimeslot());
				bookingDetailsResp.setUsername(usersDetails.getUsername());
				bookingDetailsResp.setPincode(usersDetails.getPincode());
				bookingDetailsResp.setEmail(usersDetails.getEmail());
				bookingDetailsResp.setContact(usersDetails.getContact());
				bookingDetailsResp.setComment(bookingDetails.getComment());
				bookingDetailsResp.setAddress(usersDetails.getAddress());
				bookingDetailsRespList.add(bookingDetailsResp);
			}
			finalResponse.setData(bookingDetailsRespList);
			finalResponse.setStatus(true);
			return finalResponse;
		}else {
			finalResponse.setMessage("Booking Details Not Found");
			finalResponse.setStatus(false);
			return finalResponse;
		}
		}catch(Exception e) {
			finalResponse.setMessage("Booking Details Not Found");
			finalResponse.setStatus(false);
			return finalResponse;
		}
	}
}
