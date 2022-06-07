package com.virtuallobby.repository;

import org.springframework.data.repository.CrudRepository;

import com.virtuallobby.entity.ServiceDetails;

public interface GetServiceDetailsRepository extends CrudRepository<ServiceDetails, Integer> {

}
