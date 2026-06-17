package com.varshita.resource_allocation_portal.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AllocationDTO {
    private Long empId;
    private Long projId;
    private Integer allocationPercent;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}
