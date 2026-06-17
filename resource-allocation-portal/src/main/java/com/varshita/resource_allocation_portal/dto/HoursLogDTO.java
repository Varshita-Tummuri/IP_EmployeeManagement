package com.varshita.resource_allocation_portal.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HoursLogDTO {
    private Long empId;
    private Long projId;
    private LocalDate startDate;
    private Integer hoursLogged;
}
