package com.nony.fleetmsv2.parameters.controllers;

import java.util.List;
import java.util.Optional;

import com.nony.fleetmsv2.parameters.models.Contact;
import com.nony.fleetmsv2.parameters.models.Location;
import com.nony.fleetmsv2.parameters.services.ContactService;
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
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/parameters/contacts")
	public String getAll(Model model){
		List<Contact> contacts =   contactService.getAll();
		model.addAttribute("contacts", contacts);
		return "parameters/contact/contactList";
	}

	@GetMapping("/parameters/contact/{id}")
	@ResponseBody
	public Contact getContact(@PathVariable Integer id) {
		return contactService.getById(id);
	}

	@GetMapping("/parameters/add-contact")
	public String addContact() {
		return "parameters/contact/contactAdd";
	}

	@PostMapping("/parameters/contacts")
	public String save(Contact contact){
		contactService.save(contact);
		return "redirect:/parameters/contacts";
	}

	@GetMapping("/parameters/edit-contact/{id}")
	public String editContact(@PathVariable Integer id, Model model){
		Contact contact = contactService.getById(id);
		model.addAttribute("contact", contact);
		return "parameters/contact/contactEdit";
	}

	@RequestMapping(
			value = "/parameters/contacts/delete/{id}",
			method = {
					RequestMethod.DELETE,
					RequestMethod.GET
			})
	public String delete(@PathVariable Integer id) {
		contactService.delete(id);
		return "redirect:/parameters/contacts";
	}

	@RequestMapping(
			value = "/parameters/contacts/update/{id}",
			method = {
					RequestMethod.GET,
					RequestMethod.PUT
			}
	)
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/parameters/contacts";
	}
}
