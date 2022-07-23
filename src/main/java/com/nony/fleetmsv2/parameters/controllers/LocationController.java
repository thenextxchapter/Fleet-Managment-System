package com.nony.fleetmsv2.parameters.controllers;

import com.nony.fleetmsv2.parameters.models.Location;
import com.nony.fleetmsv2.parameters.models.State;
import com.nony.fleetmsv2.parameters.services.CountryService;
import com.nony.fleetmsv2.parameters.services.LocationService;
import com.nony.fleetmsv2.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LocationController {

	@Autowired
	private LocationService locationService;
	@Autowired
	private StateService stateService;
	@Autowired
	private CountryService countryService;

	public Model addModelAttributes(Model model){
		model.addAttribute("locations", locationService.getAll());
		model.addAttribute("countries", countryService.getAll());
		model.addAttribute("states", stateService.getAll());
		return model;
	}

	@GetMapping("/parameters/locations")
	public String getAll(Model model){
		addModelAttributes(model);
		return "/parameters/location/locations";
	}

	@GetMapping("/parameters/add-location")
	public String addLocation(Model model){
		model.addAttribute("countries", countryService.getAll());
		return "parameters/location/locationAdd";
	}

	@PostMapping("/parameters/locations")
	public String save(Location location) {
		locationService.save(location);
		return "redirect:/parameters/locations";
	}

	@RequestMapping(
			value="/parameters/location/delete/{id}",
			method = {
					RequestMethod.DELETE,
					RequestMethod.GET
			}
	)
	public String delete(@PathVariable Integer id) {
		locationService.delete(id);
		return "redirect:/parameters/locations";
	}

	@GetMapping("/parameters/edit-location/{id}")
	public String editLocation(@PathVariable Integer id, Model model) {
		addModelAttributes(model);
//		model.addAttribute("location", locationService.getById(id));
		return "parameters/locaton/locationEdit";
	}

	@RequestMapping(
			value = "/parameters/locations/update/{id}",
			method = {
					RequestMethod.GET,
					RequestMethod.PUT
			}
	)
	public String update(Location location) {
		locationService.save(location);
		return "redirect:/parameters/locations";
	}
}
