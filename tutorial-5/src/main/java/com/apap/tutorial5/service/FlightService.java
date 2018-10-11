package com.apap.tutorial5.service;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.model.PilotModel;

/*
 * FlightService
 */
public interface FlightService {
	void addFlight(FlightModel flight);
	void deleteFlight(String flightNumber);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	FlightModel getFlightDetailById(long id);
	void updateFlight(String flightNumber, FlightModel flight);
	void deleteFlightById(long id);
}
