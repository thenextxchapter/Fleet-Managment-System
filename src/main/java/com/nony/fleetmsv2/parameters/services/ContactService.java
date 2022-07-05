package com.nony.fleetmsv2.parameters.services;

import java.util.List;

import com.nony.fleetmsv2.parameters.models.Contact;
import com.nony.fleetmsv2.parameters.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	//Get All Contacts
	public List<Contact> getAll(){
		return contactRepository.findAll();
	}

	//Get Contact By Id
	public Contact getById(int id) {
		return contactRepository.findById(id).orElse(null);
	}

	//Delete Contact
	public void delete(int id) {
		contactRepository.deleteById(id);
	}

	//Update Contact
	public void save( Contact contact) {
		contactRepository.save(contact);
	}
}
