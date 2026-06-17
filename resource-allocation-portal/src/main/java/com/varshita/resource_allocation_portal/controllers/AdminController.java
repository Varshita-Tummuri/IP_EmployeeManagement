package com.varshita.resource_allocation_portal.controllers;

import com.varshita.resource_allocation_portal.dto.EmployeeDTO;
import com.varshita.resource_allocation_portal.dto.ProjectDTO;
import com.varshita.resource_allocation_portal.models.Master_Employee;
import com.varshita.resource_allocation_portal.models.Master_Project;
import com.varshita.resource_allocation_portal.models.SystemConfig;
import com.varshita.resource_allocation_portal.repositories.SystemConfigRepository;
import com.varshita.resource_allocation_portal.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private SystemConfigRepository systemConfigRepository;


    @PostMapping("/employees")
    public Master_Employee addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return adminService.addEmployee(employeeDTO);
    }

    @GetMapping("/employees")
    public List<Master_Employee> getAllEmployees(){
        return adminService.getAllEmployees();
    }

    @PutMapping("/employees/{empId}")
    public Master_Employee updateEmployee(@PathVariable Long empId ,@RequestBody EmployeeDTO employeeDTO){
        return adminService.updateEmployee(empId, employeeDTO);
    }

    @DeleteMapping("/employees/{empId}")
    public boolean deleteEmployee(@PathVariable Long empId){
        return adminService.deleteEmployee(empId);
    }


    @PostMapping("/project")
    public Master_Project addProject(@RequestBody ProjectDTO projectDTO){
        return adminService.addProject(projectDTO);
    }

    @GetMapping("/project")
    public List<Master_Project> getAllProjects(){
        return adminService.getAllProjects();
    }

    @PutMapping("/project/{projId}")
    public Master_Project updateProject(@PathVariable Long projId ,@RequestBody ProjectDTO projectDTO){
        return adminService.updateProject(projId, projectDTO);
    }

    @DeleteMapping("/project/{projId}")
    public boolean deleteProject(@PathVariable Long projId){
        return adminService.deleteProject(projId);
    }

    @PutMapping("/config")
    public SystemConfig editConfigValues(@RequestBody SystemConfig systemConfig){
        return adminService.editConfigValues(systemConfig);
    }

    @GetMapping("/config")
    public SystemConfig getConfigValues(){
        return adminService.getConfigValues();
    }
}
