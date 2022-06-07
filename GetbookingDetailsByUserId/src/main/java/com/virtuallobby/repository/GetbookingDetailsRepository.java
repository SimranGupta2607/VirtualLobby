package com.virtuallobby.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.virtuallobby.entity.BookingDetails;

public interface GetbookingDetailsRepository extends CrudRepository<BookingDetails, Integer> {

	List<BookingDetails> findByUserid(Integer userid);
}
