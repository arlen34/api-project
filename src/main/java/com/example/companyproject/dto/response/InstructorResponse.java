package com.example.companyproject.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class InstructorResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;
    private String specialization;
    private boolean isActive;
    private LocalDateTime created;
    private LocalDateTime updated;
}
