package com.varshita.resource_allocation_portal.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AvailabilityDTO {
    private Long empId;
    private LocalDate availableFrom;
    private LocalDate availableTo;
}
