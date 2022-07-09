package com.nony.fleetmsv2.parameters.repositories;

import com.nony.fleetmsv2.parameters.models.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {

}
