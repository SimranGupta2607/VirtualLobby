package com.virtuallobby.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.entity.ShopDetails;
import com.virtuallobby.repository.GetShopDetailsRepository;

@Service
public class GetShopDetailsService {
	@Autowired
	GetShopDetailsRepository getShopDetailsRepository;

	public FinalResponse getShopDetailsByServiceType(String serviceType) {
		FinalResponse finalResponse = new FinalResponse();
		try {
		List<ShopDetails> shopDetails = (ArrayList<ShopDetails>) getShopDetailsRepository.findByStype(serviceType);
		if(shopDetails != null) {
			finalResponse.setData(shopDetails);
			finalResponse.setStatus(true);
			return finalResponse;
		}else {
			finalResponse.setMessage("Shop Details Not Found");
			finalResponse.setStatus(false);
			return finalResponse;
		}
		}catch(Exception e) {
			finalResponse.setMessage("Shop Details Not Found");
			finalResponse.setStatus(false);
			return finalResponse;
		}
	}
}
