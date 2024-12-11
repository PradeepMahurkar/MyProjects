package com.example.institute.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BatchEntity {
    @NotBlank(message = "Batch Name is required.")
    private String name;

    @NotBlank(message = "Course is required.")
    private String course;

    private String instructor;

    @NotNull(message = "Start Date is required.")
    private String startDate;

    @NotNull(message = "End Date is required.")
    private String endDate;

    @NotNull(message = "Capacity is required.")
    @Min(value = 1, message = "Capacity must be at least 1.")
    private Integer capacity;

    private String timings;

}

