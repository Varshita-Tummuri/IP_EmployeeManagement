package com.varshita.resource_allocation_portal.repositories;

import com.varshita.resource_allocation_portal.models.Master_Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Master_Project, Long> {
}
