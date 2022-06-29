package com.nony.fleetmsv2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

	@GetMapping("/index")
	public String home() {
		return "index";
	}

	@GetMapping("/layout")
	public String layout() {
		return "_layout";
	}
}
