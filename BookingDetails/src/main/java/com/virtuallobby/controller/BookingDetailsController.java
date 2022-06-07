package com.virtuallobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.entity.BookingDetails;
import com.virtuallobby.service.BookingDetailsService;

@RestController
@CrossOrigin(origins = "*")
public class BookingDetailsController {
	@Autowired  
	BookingDetailsService bookingDetailsService;  

	@PostMapping(value = "/bookingDetails", consumes = "application/json", produces = "application/json")
	public FinalResponse bookingDetails(@RequestBody BookingDetails bookingDetails) {
		return bookingDetailsService.bookingDetails(bookingDetails);
	}

}