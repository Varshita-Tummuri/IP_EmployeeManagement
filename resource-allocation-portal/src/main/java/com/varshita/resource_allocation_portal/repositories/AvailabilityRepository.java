package com.varshita.resource_allocation_portal.repositories;

import com.varshita.resource_allocation_portal.models.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
}
