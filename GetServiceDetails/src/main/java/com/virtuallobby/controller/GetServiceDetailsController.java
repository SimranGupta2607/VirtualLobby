package com.virtuallobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.service.GetServiceDetailsService;

@RestController
@CrossOrigin(origins = "*")
public class GetServiceDetailsController {
	@Autowired  
	GetServiceDetailsService getServiceDetailsService;  

	@GetMapping(value = "/getServiceDetails")
	public FinalResponse getServiceDetails() {
		return getServiceDetailsService.getServiceDetails();
	}

}