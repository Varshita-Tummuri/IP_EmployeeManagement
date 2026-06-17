package com.varshita.resource_allocation_portal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class HoursLog {
    @Id
    private Long logId;

    @JoinColumn(name = "emp_id", nullable = false)
    private Master_Employee employee;

    @JoinColumn(name = "proj_id", nullable = false)
    private Master_Project project;

    private LocalDate startDate;
    private Integer hoursLogged;
}
