package com.example.companyproject.dto.response;

import com.example.companyproject.model.StudyFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;
    private StudyFormat studyFormat;
    private boolean isActive;
    private LocalDateTime created;
    private LocalDateTime updated;
}
