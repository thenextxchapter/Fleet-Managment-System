package com.nony.fleetmsv2.parameters.controllers;

import java.util.List;

import com.nony.fleetmsv2.parameters.models.State;
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

	@PostMapping("/states")
	public String save(State state) {
		stateService.save(state);
		return "redirect:/states";
	}

	@RequestMapping(
			value = "states/delete/{id}",
			method = {
					RequestMethod.GET,
					RequestMethod.DELETE
			}
	)
	public String delete(@PathVariable Integer id) {
		stateService.delete(id);
		return "redirect:/states";
	}
}
