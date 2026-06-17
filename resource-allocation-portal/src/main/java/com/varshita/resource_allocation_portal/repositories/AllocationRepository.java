package com.varshita.resource_allocation_portal.repositories;

import com.varshita.resource_allocation_portal.models.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {
//    List<Allocation> findByProjectId(Long projId);
    List<Allocation> findByProjectProjId(Long projId);
}
