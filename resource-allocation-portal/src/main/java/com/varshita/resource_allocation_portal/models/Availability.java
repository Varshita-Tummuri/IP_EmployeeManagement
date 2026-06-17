package com.varshita.resource_allocation_portal.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long availabilityId;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Master_Employee employee;

    private LocalDate availableFrom;
    private LocalDate availableTo;
}
