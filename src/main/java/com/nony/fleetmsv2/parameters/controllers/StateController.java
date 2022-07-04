package com.nony.fleetmsv2.parameters.controllers;

import java.util.List;

import com.nony.fleetmsv2.parameters.models.State;
import com.nony.fleetmsv2.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StateController {

	@Autowired
	private StateService stateService;

	@GetMapping("/states")
	private String getAll(Model model) {
		List<State> states = stateService.getAll();
		model.addAttribute("states", states);
		return "parameters/state/stateList";
	}

	@GetMapping("/stateAdd")
	public String addState() {
		return "parameters/state/stateAdd";
	}

	public String save(State state) {
		stateService.save(state);
		return "redirect:/states";
	}
}
