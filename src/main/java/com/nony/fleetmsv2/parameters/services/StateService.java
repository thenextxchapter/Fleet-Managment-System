package com.nony.fleetmsv2.parameters.services;

import java.util.List;

import com.nony.fleetmsv2.parameters.models.Country;
import com.nony.fleetmsv2.parameters.models.State;
import com.nony.fleetmsv2.parameters.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	public List<State> getAll() { return stateRepository.findAll(); }

	public void save(State state) { stateRepository.save(state); }

	public void delete(Integer id) { stateRepository.deleteById(id); }

}
