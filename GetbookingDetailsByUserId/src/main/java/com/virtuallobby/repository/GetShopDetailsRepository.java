package com.virtuallobby.repository;

import org.springframework.data.repository.CrudRepository;

import com.virtuallobby.entity.ShopDetails;

public interface GetShopDetailsRepository extends CrudRepository<ShopDetails, Integer> {
	
}
