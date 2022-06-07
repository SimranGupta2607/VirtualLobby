package com.virtuallobby.repository;

import org.springframework.data.repository.CrudRepository;

import com.virtuallobby.entity.BookingDetails;

public interface BookingDetailsRepository extends CrudRepository<BookingDetails, Integer> {

}
