package com.virtuallobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.entity.UsersDetails;
import com.virtuallobby.service.SignUpService;

@RestController
@CrossOrigin(origins = "*")
public class SignUpController {
	@Autowired  
	SignUpService signUpService;
	

	@PostMapping(value = "/signUp", consumes = "application/json", produces = "application/json")
	public FinalResponse userSignUp(@RequestBody UsersDetails usersDetails) {
		return signUpService.signUpUser(usersDetails);
	}

}