package com.virtuallobby.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.virtuallobby.entity.ShopDetails;

public interface GetShopDetailsRepository extends CrudRepository<ShopDetails, Integer> {

	List<ShopDetails> findByStype(String serviceType);
}
