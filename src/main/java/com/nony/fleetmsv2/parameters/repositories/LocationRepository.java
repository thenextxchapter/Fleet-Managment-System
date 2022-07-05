package com.nony.fleetmsv2.parameters.repositories;

import com.nony.fleetmsv2.parameters.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
