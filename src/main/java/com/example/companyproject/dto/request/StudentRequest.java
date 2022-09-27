package com.example.companyproject.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;
    private Long companyId;
}
