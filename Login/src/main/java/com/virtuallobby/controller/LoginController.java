package com.virtuallobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.dto.LoginUser;
import com.virtuallobby.service.LoginService;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
	@Autowired  
	LoginService loginService;  

	@PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
	public FinalResponse userLogin(@RequestBody LoginUser loginUser) {
		return loginService.userLogin(loginUser);
	}

}