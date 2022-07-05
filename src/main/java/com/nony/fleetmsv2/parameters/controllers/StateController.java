package com.nony.fleetmsv2.parameters.controllers;

import java.util.List;

import com.nony.fleetmsv2.parameters.models.State;
import com.nony.fleetmsv2.parameters.services.CountryService;
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
public class StateController {

	@Autowired
	private StateService stateService;

	@Autowired
	private CountryService countryService;

	public Model addModelAttribute(Model model) {
		model.addAttribute("states", stateService.getAll());
		model.addAttribute("countries", countryService.getAll());
		return model;
	}

//	Get All States
	@GetMapping("/parameters/states")
	private String getAll(Model model) {
		addModelAttribute(model);
		return "parameters/state/stateList";
	}

	@GetMapping("/parameters/add-states")
	public String addState(Model model) {
		addModelAttribute(model);
		return "parameters/state/stateAdd";
	}

	@PostMapping("/parameters/states")
	public String save(State state) {
		stateService.save(state);
		return "redirect:/parameters/states";
	}

	@RequestMapping(
			value = "/parameters/states/delete/{id}",
			method = {
					RequestMethod.GET,
					RequestMethod.DELETE
			}
	)
	public String delete(@PathVariable Integer id) {
		stateService.delete(id);
		return "redirect:/parameters/states";
	}

	@GetMapping("/parameters/state/{op}/{id}")
	public String editState(@PathVariable Integer id, @PathVariable String op, Model model) {
		addModelAttribute(model);
		model.addAttribute("state", stateService.getById(id));
		return "parameters/state/stateEdit" + op;
	}

	public String update(State state) {
		stateService.save(state);
		return "redirect:/parameters/states";
	}
}
