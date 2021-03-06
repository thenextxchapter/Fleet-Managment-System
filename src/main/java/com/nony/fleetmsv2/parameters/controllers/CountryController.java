package com.nony.fleetmsv2.parameters.controllers;

import java.util.List;

import com.nony.fleetmsv2.parameters.models.Country;
import com.nony.fleetmsv2.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/parameters/countries")
	public String getAll(Model model) {
		List<Country> countries = countryService.getAll();
		model.addAttribute("countries", countries);
		return "parameters/country/countryList";
	}

	@GetMapping("/parameters/add-country")
	public String addCountry() {
		return "parameters/country/countryAdd";
	}

	@GetMapping("/parameters/edit-country/{id}")
	public String editCountry(@PathVariable Integer id, Model model) {
//		To return anything to the UI, you have to use the Model
		Country country = countryService.getById(id);
		model.addAttribute("country", country);
		return "parameters/country/countryEdit";
	}

	@PostMapping("/parameters/countries")
	public String save(Country country) {
		countryService.save(country);
		return "redirect:/parameters/countries";
//		Returns a new refreshed list
	}

	@RequestMapping(
			value = "/parameters/countries/delete/{id}",
			method = {
					RequestMethod.GET,
					RequestMethod.DELETE
			}
	)
	public String delete(@PathVariable Integer id) {
		countryService.delete(id);
		return "redirect:/parameters/countries";
	}

	@RequestMapping(
			value = "/parameters/countries/update/{id}",
			method = {
					RequestMethod.GET,
					RequestMethod.PUT
			}
	)
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/parameters/countries";
	}

	//Get Country By ID
	@GetMapping("/parameters/country/{id}")
	@ResponseBody
	public Country getCountry(@PathVariable Integer id) {
		return countryService.getById(id);
	}
}
