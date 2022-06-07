package com.virtuallobby.repository;

import org.springframework.data.repository.CrudRepository;

import com.virtuallobby.entity.UsersDetails;

public interface LoginRepository extends CrudRepository<UsersDetails, Integer> {
	
}
