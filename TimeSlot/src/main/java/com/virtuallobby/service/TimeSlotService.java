package com.virtuallobby.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtuallobby.dto.FinalResponse;
import com.virtuallobby.dto.TimeSlotResp;
import com.virtuallobby.repository.TimeSlotRepository;

@Service
public class TimeSlotService {
	@Autowired
	private TimeSlotRepository timeSlotRepository;

	public FinalResponse getTimeSlot(Integer shopId) {
		FinalResponse finalResponse = new FinalResponse();
		try {
			List<String> timeslot = timeSlotRepository.getTimeSlotByShopId(shopId);
			List<TimeSlotResp> timeSlotRespList = new ArrayList<>();
			LocalTime startTime = LocalTime.of(8, 0);
			LocalDate today = LocalDate.now();
			LocalDateTime current = LocalDateTime.of(today, startTime);
			LocalDateTime endDateTime = current.plusHours(12);

            String timeSlotBook = current.toLocalTime().toString();
			while (current.isBefore(endDateTime)) {
				TimeSlotResp timeSlotResp = new TimeSlotResp();
				LocalDateTime newCurrent = current.plusMinutes(30);
				String timeSlotFormat = timeSlotBook + " - " + newCurrent.toLocalTime().toString();
				if(timeslot.contains(timeSlotFormat)) {
					timeSlotResp.setTimeslot(timeSlotFormat);
					timeSlotResp.setIsTimeslotEnable("N");
					timeSlotRespList.add(timeSlotResp);
				}else {
					timeSlotResp.setTimeslot(timeSlotFormat);
					timeSlotResp.setIsTimeslotEnable("Y");
					timeSlotRespList.add(timeSlotResp);
				}
				timeSlotBook = newCurrent.toLocalTime().toString();
				current = newCurrent;
			}
			finalResponse.setData(timeSlotRespList);
			finalResponse.setStatus(true);

		} catch (Exception e) {
			finalResponse.setMessage("Time Slot not available.");
			finalResponse.setStatus(false);
			return finalResponse;
		}
		return finalResponse;
	}
}
