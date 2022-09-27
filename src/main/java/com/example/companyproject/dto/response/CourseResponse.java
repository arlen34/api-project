package com.example.companyproject.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
public class CourseResponse {
    private Long id;
    private String courseName;
    private LocalDate dateOfStart;
    private int duration;
    private String image;
    private String description;
    private boolean isActive=true;
    private LocalDateTime created;
    private LocalDateTime updated;
}
