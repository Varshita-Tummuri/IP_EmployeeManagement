package com.varshita.resource_allocation_portal.services;

import com.varshita.resource_allocation_portal.dto.EmployeeDTO;
import com.varshita.resource_allocation_portal.dto.ProjectDTO;
import com.varshita.resource_allocation_portal.models.Master_Employee;
import com.varshita.resource_allocation_portal.models.Master_Project;
import com.varshita.resource_allocation_portal.models.SystemConfig;
import com.varshita.resource_allocation_portal.repositories.EmployeeRepository;
import com.varshita.resource_allocation_portal.repositories.ProjectRepository;
import com.varshita.resource_allocation_portal.repositories.SystemConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SystemConfigRepository systemConfigRepository;


    public Master_Employee addEmployee(EmployeeDTO employeeDTO) {
        Master_Employee masterEmployee = Master_Employee.builder()
                .name(employeeDTO.getName())
                .email(employeeDTO.getEmail())
                .password(
                        passwordEncoder.encode(
                                employeeDTO.getPassword()
                        )
                )
                .role(employeeDTO.getRole())
                .skills(employeeDTO.getSkills())
                .availabilityStatus(false)
                .build();

        return employeeRepository.save(masterEmployee);
    }
    public List<Master_Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Master_Employee updateEmployee(Long empId, EmployeeDTO employeeDTO) {
        Master_Employee masterEmployee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        masterEmployee.setName(employeeDTO.getName());
        masterEmployee.setEmail(employeeDTO.getEmail());
        masterEmployee.setRole(employeeDTO.getRole());
        masterEmployee.setSkills(employeeDTO.getSkills());

        return employeeRepository.save(masterEmployee);
    }
    public boolean deleteEmployee(Long empId) {
        Master_Employee masterEmployee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Emnployee not found"));

        employeeRepository.deleteById(empId);
        return true;
    }


    public Master_Project addProject(ProjectDTO projectDTO) {
        Master_Project masterProject = Master_Project.builder()
                .projName(projectDTO.getProjName())
                .startDate(projectDTO.getStartDate())
                .endDate(projectDTO.getEndDate())
                .requiredPpl(projectDTO.getRequiredPpl())
                .status(false)
                .build();

        return projectRepository.save(masterProject);
    }
    public List<Master_Project> getAllProjects() {
        return projectRepository.findAll();
    }
    public Master_Project updateProject(Long projId, ProjectDTO projectDTO) {
        Master_Project masterProject = projectRepository.findById(projId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        masterProject.setProjName(projectDTO.getProjName());
        masterProject.setStartDate(projectDTO.getStartDate());
        masterProject.setEndDate(projectDTO.getEndDate());
        masterProject.setRequiredPpl(projectDTO.getRequiredPpl());

        return projectRepository.save(masterProject);
    }
    public boolean deleteProject(Long projId) {
        Master_Project masterProject = projectRepository.findById(projId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        projectRepository.deleteById(projId);
        return true;
    }


    public SystemConfig getConfigValues(){
        SystemConfig systemConfig = systemConfigRepository.findAll()
                .stream().findFirst()
                .orElseThrow(()->new RuntimeException("No config values set."));

        return systemConfigRepository.save(systemConfig);
    }
    public SystemConfig editConfigValues(SystemConfig systemConfig){
        SystemConfig system = systemConfigRepository.findAll()
                .stream().findFirst()
                .orElseThrow(()-> new RuntimeException("Config not found"));
        system.setHoursThreshold(systemConfig.getHoursThreshold());
        system.setAllocationThreshold(systemConfig.getAllocationThreshold());

        return systemConfigRepository.save(system);
    }
}
