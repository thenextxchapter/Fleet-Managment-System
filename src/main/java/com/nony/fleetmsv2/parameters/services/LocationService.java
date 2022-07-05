package com.nony.fleetmsv2.parameters.services;

import java.util.List;

import com.nony.fleetmsv2.parameters.models.Location;
import com.nony.fleetmsv2.parameters.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public List<Location> getAll() {
		return (List<Location>) locationRepository.findAll();
	}

	public Location getById(Integer id) {
		return locationRepository.findById(id).orElse(null);
	}

	public void save(Location location) {
		locationRepository.save(location);
	}

	public void delete(Integer id) {
		locationRepository.deleteById(id);
	}

	public List<Location> findByDescriptionContaining(String description) {
		return null;
	}
}
