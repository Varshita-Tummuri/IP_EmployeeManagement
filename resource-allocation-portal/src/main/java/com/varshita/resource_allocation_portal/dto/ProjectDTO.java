package com.varshita.resource_allocation_portal.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectDTO {
    private String projName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer requiredPpl;
    private boolean status;
}
