package com.virtuallobby.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.entity.ServiceDetails;
import com.virtuallobby.repository.GetServiceDetailsRepository;

@Service
public class GetServiceDetailsService {
	@Autowired
	GetServiceDetailsRepository getServiceDetailsRepository;

	public FinalResponse getServiceDetails() {
		FinalResponse finalResponse = new FinalResponse();
		try {
		List<ServiceDetails> serviceDetails = (ArrayList<ServiceDetails>) getServiceDetailsRepository.findAll();
		if(serviceDetails != null) {
			finalResponse.setData(serviceDetails);
			finalResponse.setStatus(true);
			return finalResponse;
		}else {
			finalResponse.setMessage("Service Details Not Found");
			finalResponse.setStatus(false);
			return finalResponse;
		}
		}catch(Exception e) {
			finalResponse.setMessage("Service Details Not Found");
			finalResponse.setStatus(false);
			return finalResponse;
		}
	}
}
