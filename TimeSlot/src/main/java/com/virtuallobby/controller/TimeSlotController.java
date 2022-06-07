package com.virtuallobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.service.TimeSlotService;

@RestController
@CrossOrigin(origins = "*")
public class TimeSlotController {
	@Autowired  
	TimeSlotService timeSlotService;  

	@GetMapping(value = "/getTimeSlot")
	public FinalResponse getTimeSlot(@RequestParam Integer shopId) {
		return timeSlotService.getTimeSlot(shopId);
	}
}