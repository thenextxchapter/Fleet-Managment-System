package com.nony.fleetmsv2.parameters.controllers;

import java.util.List;

import com.nony.fleetmsv2.parameters.models.Country;
import com.nony.fleetmsv2.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/countries")
	public String getAll(Model model) {
		List<Country> countries = countryService.getAll();
		model.addAttribute("countries", countries);
		return "parameters/countryList";
	}
}
