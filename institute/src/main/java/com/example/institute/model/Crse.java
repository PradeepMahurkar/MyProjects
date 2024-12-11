package com.example.institute.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
//import javax.validation.constraints*;
import java.util.Date;

@Getter
@Setter
class Course {
    private Long id;

    @NotBlank(message = "Course name is required")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Courses name must be alphanumeric")
    private String name;

    private String description;

    @NotNull(message = "Start date is required")
    private Date startDate;

    @NotNull(message = "End date is required")
    private Date endDate;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be at least 1 week")
    private Integer duration;

    private String instructor;
    private String courseMaterial; // URL to uploaded file (optional)
}
