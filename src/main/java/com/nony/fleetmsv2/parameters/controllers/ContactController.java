package com.nony.fleetmsv2.parameters.controllers;

import java.util.List;
import java.util.Optional;

import com.nony.fleetmsv2.parameters.models.Contact;
import com.nony.fleetmsv2.parameters.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/parameters/contacts")
	public String getAll(Model model){
		List<Contact> contacts =   contactService.getAll();
		model.addAttribute("contacts", contacts);
		return "/parameters/contact/contacts";
	}

	@GetMapping("/parameters/add-contact")
	public String contactAdd() { return "/parameters/contact/contacts"; }

	@RequestMapping("contacts/findById")
	@ResponseBody
	public Contact getById(Integer id) { return contactService.getById(id); }

	@PostMapping(value = "contacts/addNew")
	public String addNew(Contact contact){
		contactService.save(contact);
		return "redirect:/parameters/contacts";
	}

	@RequestMapping(
			value = "contacts/delete",
			method = {
					RequestMethod.DELETE,
					RequestMethod.GET
			})
	public String delete(Integer id) {
		contactService.delete(id);
		return "redirect:/parameters/contacts";
	}
}
