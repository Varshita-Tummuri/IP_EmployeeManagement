package com.varshita.resource_allocation_portal.controllers;

import com.varshita.resource_allocation_portal.dto.AllocationDTO;
import com.varshita.resource_allocation_portal.models.Allocation;
import com.varshita.resource_allocation_portal.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/allocation")
    public List<Allocation> getAllAllocations(){
        return managerService.getAllAllocations();
    }

    @GetMapping("/allocation/{projId}")
    public List<Allocation> getAllocationByProj(@PathVariable Long projId){
        return managerService.getAllocationByProj(projId);
    }

    @PostMapping("/allocation")
    public Allocation allocateEmployee(@RequestBody AllocationDTO allocationDTO){
        return managerService.allocateEmployee(allocationDTO);
    }

    @PutMapping("/allocation/{allocationId}")
    public Allocation editAllocation(@PathVariable Long allocationId ,@RequestBody AllocationDTO allocationDTO){
        return managerService.editAllocation(allocationId, allocationDTO);
    }
}
