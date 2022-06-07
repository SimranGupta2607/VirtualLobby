package com.virtuallobby.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.virtuallobby.entity.ShopDetails;
import com.virtuallobby.entity.UsersDetails;

public interface LoginRepository extends CrudRepository<UsersDetails, Integer> {
	@Query(
			  value = "SELECT u FROM UsersDetails u WHERE u.email = :email")
	UsersDetails findByEmail(String email);
	
	@Query(
			  value = "SELECT s FROM ShopDetails s WHERE s.email = :email")
	ShopDetails findByEmailId(String email);
}
