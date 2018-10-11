package com.apap.tutorial5.repository;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.model.PilotModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

/*
 * FlightDb
 */
@Repository
public interface FlightDb extends JpaRepository<FlightModel, Long> {
	FlightModel findByFlightNumber(String flightNumber);
	FlightModel findById(long id);

}
