package com.virtuallobby.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.entity.UsersDetails;
import com.virtuallobby.repository.SignUpRepository;

@Service
public class SignUpService {
	@Autowired
	SignUpRepository signUpRepository;

	public FinalResponse signUpUser(UsersDetails usersDetails) {
		FinalResponse finalResponse = new FinalResponse();
		try {
		UsersDetails usersInfo = signUpRepository.save(usersDetails);
		if(usersInfo != null) {
			finalResponse.setMessage("User Registered Successfully");
			finalResponse.setStatus(true);
			return finalResponse;
		}else {
			finalResponse.setMessage("User Registration failed");
			finalResponse.setStatus(true);
			return finalResponse;
		}
		}catch(Exception e) {
			finalResponse.setMessage("User Registration failed");
			finalResponse.setStatus(false);
			System.out.println(e);
			return finalResponse;
		}
	}
}
