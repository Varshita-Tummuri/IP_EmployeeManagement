package com.varshita.resource_allocation_portal.repositories;

import com.varshita.resource_allocation_portal.models.SystemConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemConfigRepository extends JpaRepository<SystemConfig, Long>{
}
