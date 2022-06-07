package com.virtuallobby.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtuallobby.dto.BookingDetailsResp;
import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.entity.BookingDetails;
import com.virtuallobby.entity.ShopDetails;
import com.virtuallobby.repository.GetShopDetailsRepository;
import com.virtuallobby.repository.GetbookingDetailsRepository;

@Service
public class GetbookingDetailsService {
	@Autowired
	GetbookingDetailsRepository getbookingDetailsRepository;
	
	@Autowired
	private GetShopDetailsRepository shopDetailsRepository;

	public FinalResponse getbookingDetailsByUserId(Integer userid) {
		FinalResponse finalResponse = new FinalResponse();
		List<BookingDetailsResp> bookingDetailsRespList = new ArrayList<>();
		try {
		List<BookingDetails> bookDetails = (ArrayList<BookingDetails>) getbookingDetailsRepository.findByUserid(userid);
		if(bookDetails != null && !bookDetails.isEmpty()) {
			for(BookingDetails bookingDetails : bookDetails) {
				ShopDetails shopDetails = shopDetailsRepository.findById(bookingDetails.getShopid()).get();
				BookingDetailsResp bookingDetailsResp = new BookingDetailsResp();
				bookingDetailsResp.setBookingid(bookingDetails.getBookingid());
				bookingDetailsResp.setShopid(bookingDetails.getShopid());
				bookingDetailsResp.setUserid(bookingDetails.getUserid());
				bookingDetailsResp.setSlotinterval(bookingDetails.getSlotinterval());
				bookingDetailsResp.setTimeslot(bookingDetails.getTimeslot());
				bookingDetailsResp.setShopname(shopDetails.getShopname());
				bookingDetailsResp.setPincode(shopDetails.getPincode());
				bookingDetailsResp.setEmail(shopDetails.getEmail());
				bookingDetailsResp.setContact(shopDetails.getContact());
				bookingDetailsResp.setAddress(shopDetails.getAddress());
				bookingDetailsResp.setBookingDate(bookingDetails.getBookingdate());
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
