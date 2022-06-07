package com.virtuallobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.entity.ShopDetails;
import com.virtuallobby.service.ShopSignUpService;

@RestController
@CrossOrigin(origins = "*")
public class ShopSignUpController {
	@Autowired  
	ShopSignUpService signUpService;  

	@PostMapping(value = "/shopSignUp", consumes = "application/json", produces = "application/json")
	public FinalResponse userSignUp(@RequestBody ShopDetails shopDetails) {
		return signUpService.signUpUser(shopDetails);
	}

}