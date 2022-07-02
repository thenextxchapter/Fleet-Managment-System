package com.nony.fleetmsv2.parameters.services;

import java.util.List;

import com.nony.fleetmsv2.parameters.models.Country;
import com.nony.fleetmsv2.parameters.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> getAll(){ return countryRepository.findAll(); }

	public void save(Country country) { countryRepository.save(country); }

	public void delete(Integer id) { countryRepository.deleteById(id); }

	public Country getById(Integer id) {
		return countryRepository.findById(id).orElse(null);
	}
}
