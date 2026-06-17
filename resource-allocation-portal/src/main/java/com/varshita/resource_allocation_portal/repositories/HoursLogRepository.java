package com.varshita.resource_allocation_portal.repositories;

import com.varshita.resource_allocation_portal.models.HoursLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoursLogRepository extends JpaRepository<HoursLog, Long> {
}
