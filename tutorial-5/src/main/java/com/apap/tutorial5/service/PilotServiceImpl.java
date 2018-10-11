package com.apap.tutorial5.service;

import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.repository.PilotDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * PilotServiceImpl
 */
@Service
@Transactional
public class PilotServiceImpl implements PilotService{
	@Autowired
	private PilotDb pilotDb;
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public void addPilot(PilotModel pilot) {
		pilotDb.save(pilot);
	}
		
	@Override
	public void deletePilot(String licenseNumber) {
		pilotDb.delete(this.getPilotDetailByLicenseNumber(licenseNumber));
	}
	
	@Override
	public void deletePilotById(long id) {
		pilotDb.deleteById(id);
	}
	@Override
	public void updatePilot(String licenseNumber, PilotModel newPilot) {
		PilotModel pilotLama = this.getPilotDetailByLicenseNumber(licenseNumber);
		pilotLama.setName(newPilot.getName());
		pilotLama.setFlyHour(newPilot.getFlyHour());
	}
}
