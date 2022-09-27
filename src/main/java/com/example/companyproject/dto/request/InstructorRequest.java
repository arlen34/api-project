package com.example.companyproject.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstructorRequest {
    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String email;

    private String specialization;
}
