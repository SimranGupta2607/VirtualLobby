package com.virtuallobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.service.GetShopDetailsService;

@RestController
@CrossOrigin(origins = "*")
public class GetShopDetailsController {
	@Autowired  
	GetShopDetailsService getShopDetailsService;  

	@GetMapping(value = "/getShopDetailsByServiceType")
	public FinalResponse getShopDetailsByServiceType(@RequestParam String serviceType) {
		return getShopDetailsService.getShopDetailsByServiceType(serviceType);
	}

}