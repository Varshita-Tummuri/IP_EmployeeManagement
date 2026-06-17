package com.varshita.resource_allocation_portal.services;

import com.varshita.resource_allocation_portal.dto.AllocationDTO;
import com.varshita.resource_allocation_portal.models.Allocation;
import com.varshita.resource_allocation_portal.models.Master_Employee;
import com.varshita.resource_allocation_portal.repositories.AllocationRepository;
import com.varshita.resource_allocation_portal.repositories.EmployeeRepository;
import com.varshita.resource_allocation_portal.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    private AllocationRepository allocationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public List<Allocation> getAllAllocations(){
        return allocationRepository.findAll();
    }
    public List<Allocation> getAllocationByProj(Long projId){
        return allocationRepository.findByProjectProjId(projId);
    }
    public Allocation allocateEmployee(AllocationDTO allocationDTO){
        Allocation allocation = Allocation.builder()
                .employee(employeeRepository.findById(allocationDTO.getEmpId()).orElseThrow(()->new RuntimeException("Employee not found")))
                .project(projectRepository.findById(allocationDTO.getProjId()).orElseThrow(()->new RuntimeException("Project not Found")))
                .allocationPercent(allocationDTO.getAllocationPercent())
                .startDate(allocationDTO.getStartDate())
                .endDate(allocationDTO.getEndDate())
                .status(allocationDTO.getStatus())
                .build();
        return allocationRepository.save(allocation);
    }
    public Allocation editAllocation(Long allocationId, AllocationDTO allocationDTO){
        Allocation allocation = allocationRepository.findById(allocationId)
                .orElseThrow(()->new RuntimeException("Allocation not found"));
        allocation.setAllocationPercent(allocationDTO.getAllocationPercent());
        allocation.setStartDate(allocationDTO.getStartDate());
        allocation.setEndDate(allocationDTO.getEndDate());
        allocation.setStatus(allocationDTO.getStatus());

        return allocationRepository.save(allocation);
    }

}
