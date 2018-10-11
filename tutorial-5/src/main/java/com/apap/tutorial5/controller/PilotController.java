package com.apap.tutorial5.controller;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.service.PilotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * PilotController
 */
@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add (Model model) {
		model.addAttribute("pilot", new PilotModel());
		model.addAttribute("title", "Tambah");
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot, Model model) {
		pilotService.addPilot(pilot);
		model.addAttribute("title", "Sukses");
		return "add";
	}
	
	@RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
	private String viewPilot(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("title", "View");
		model.addAttribute("pilot", pilot);
		return "view-pilot";
	}
	
//	@RequestMapping(value = "/pilot/delete/{licenseNumber}", method = RequestMethod.GET)
//	private String deletePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
//		PilotModel pilotDelete = pilotService.getPilotDetailByLicenseNumber(licenseNumber); 
//		if(pilotDelete.getPilotFlight().size() ==0) {
//			pilotService.deletePilot(licenseNumber);
//		}else {
//			pilotDelete.getPilotFlight().clear();
//			pilotService.deletePilot(licenseNumber);
//		}
//		
//		return "delete";
//	}
	
	
	@RequestMapping(value = "/pilot/delete/{id}", method= RequestMethod.GET )
	private String deletePilot(@PathVariable(value = "id") long id, Model model) {
		pilotService.deletePilotById(id);
		model.addAttribute("title", "Delete");
		return "delete";
	}
	
	@RequestMapping(value = "/pilot/update{licenseNumber}", method = RequestMethod.GET)
	private String updatePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilotLama = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("title", "Update");
		model.addAttribute("pilotLama", pilotLama);
		model.addAttribute("pilotBaru", new PilotModel());
		return "updatePilot";
	}
	
	@RequestMapping(value = "/pilot/update{licenseNumber}", method = RequestMethod.POST)
	private String updatePilot(@ModelAttribute PilotModel pilotBaru, @PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		model.addAttribute("title", "Update");
		pilotService.updatePilot(licenseNumber, pilotBaru);
		model.addAttribute("title", "update");
		return "update";
	}
	
}
 