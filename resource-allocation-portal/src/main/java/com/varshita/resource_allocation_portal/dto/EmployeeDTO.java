package com.varshita.resource_allocation_portal.dto;

import com.varshita.resource_allocation_portal.models.Role;
import lombok.Data;

@Data
public class EmployeeDTO {
    private String name;
    private String email;
    private String password;
    private Role role;
    private String skills;
}
