package com.virtuallobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.service.GetbookingDetailsService;

@RestController
@CrossOrigin(origins = "*")
public class GetbookingDetailsController {
	@Autowired  
	GetbookingDetailsService getbookingDetailsService;  

	@GetMapping(value = "/getbookingDetailsByShopId")
	public FinalResponse getbookingDetailsByShopId(@RequestParam Integer shopId) {
		return getbookingDetailsService.getbookingDetailsByShopId(shopId);
	}

}