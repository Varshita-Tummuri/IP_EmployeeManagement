package com.varshita.resource_allocation_portal.repositories;

import com.varshita.resource_allocation_portal.models.Master_Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Master_Employee, Long> {
}
