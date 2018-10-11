package com.apap.tutorial5.service;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.repository.FlightDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDb flightDb;
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}
	
	@Override 
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		return flightDb.findByFlightNumber(flightNumber);
	}
	
	@Override 
	public FlightModel getFlightDetailById(long id) {
		return flightDb.findById(id);
	}
	
	
	@Override
	public void deleteFlight(String flightNumber) {
		flightDb.delete(this.getFlightDetailByFlightNumber(flightNumber));
	}
	
	@Override
	public void deleteFlightById(long id) {
		flightDb.delete(this.getFlightDetailById(id));
	}
	
	@Override
	public void updateFlight(String flightNumber, FlightModel newFlight) {
		FlightModel flightLama = this.getFlightDetailByFlightNumber(flightNumber);
		flightLama.setFlightNumber(newFlight.getFlightNumber());
		flightLama.setOrigin(newFlight.getOrigin());
		flightLama.setDestination(newFlight.getDestination());
		flightLama.setTime(newFlight.getTime());
	}
}
