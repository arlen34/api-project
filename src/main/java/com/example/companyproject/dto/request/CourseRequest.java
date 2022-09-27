package com.example.companyproject.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CourseRequest {

    private String courseName;
    private LocalDate dateOfStart;
    private int duration;
    private String image;
    private String description;
}
