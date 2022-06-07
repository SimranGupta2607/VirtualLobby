package com.virtuallobby.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.dto.LoginUser;
import com.virtuallobby.dto.ShopResp;
import com.virtuallobby.dto.UserResp;
import com.virtuallobby.entity.ShopDetails;
import com.virtuallobby.entity.UsersDetails;
import com.virtuallobby.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;

	@Transactional
	public FinalResponse userLogin(LoginUser loginUser) {
		FinalResponse finalResponse = new FinalResponse();
		if(loginUser.getUtype().equals("U")) {
		UsersDetails user = loginRepository.findByEmail(loginUser.getUsername());
		if(user != null && user.getPassword().equals(loginUser.getPassword())) {
			UserResp userResp = new UserResp();
			userResp.setUserid(user.getUserid());
			userResp.setUsername(user.getUsername());
			userResp.setContact(user.getContact());
			userResp.setEmail(user.getEmail());
			userResp.setPincode(user.getPincode());
			userResp.setUtype(user.getUtype());
			userResp.setLatitude(user.getLatitude());
			userResp.setLongitude(user.getLongitude());
			
			finalResponse.setData(userResp);
			finalResponse.setMessage("User Successfully Login");
			finalResponse.setStatus(true);
			return finalResponse;
		}else {
			finalResponse.setMessage("User Login Failed");
			finalResponse.setStatus(false);
			return finalResponse;
		}
		}if(loginUser.getUtype().equals("S")) {
			ShopDetails shop = loginRepository.findByEmailId(loginUser.getUsername());
			if(shop != null && shop.getPassword().equals(loginUser.getPassword())) {
				ShopResp shopResp = new ShopResp();
				shopResp.setShopid(shop.getShopid());
				shopResp.setUsername(shop.getUsername());
				shopResp.setContact(shop.getContact());
				shopResp.setEmail(shop.getEmail());
				shopResp.setPincode(shop.getPincode());
				shopResp.setUtype(shop.getUtype());
				shopResp.setLatitude(shop.getLatitude());
				shopResp.setLongitude(shop.getLongitude());
				shopResp.setShopclosed(shop.getShopclosed());
				shopResp.setStype(shop.getStype());
				shopResp.setAddress(shop.getAddress());
				
				finalResponse.setData(shopResp);
				finalResponse.setMessage("Shopkeeper Login Successfully");
				finalResponse.setStatus(true);
				return finalResponse;
			}else {
				finalResponse.setMessage("Shopkeeper Login Failed");
				finalResponse.setStatus(false);
				return finalResponse;
			}
		}
		return finalResponse;
	}
}
