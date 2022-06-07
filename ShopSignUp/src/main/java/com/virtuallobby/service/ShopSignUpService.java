package com.virtuallobby.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.entity.ShopDetails;
import com.virtuallobby.repository.ShopSignUpRepository;

@Service
public class ShopSignUpService {
	@Autowired
	ShopSignUpRepository signUpRepository;

	public FinalResponse signUpUser(ShopDetails shopDetails) {
		FinalResponse finalResponse = new FinalResponse();
		try {
		ShopDetails shopInfo = signUpRepository.save(shopDetails);
		if(shopInfo != null) {
			finalResponse.setMessage("Shop Registered Successfully");
			finalResponse.setStatus(true);
			return finalResponse;
		}else {
			finalResponse.setMessage("Shop Registration fail");
			finalResponse.setStatus(true);
			return finalResponse;
		}
		}catch(Exception e) {
			finalResponse.setMessage("Shop Registration failed");
			finalResponse.setStatus(false);
			return finalResponse;
		}
	}
}
