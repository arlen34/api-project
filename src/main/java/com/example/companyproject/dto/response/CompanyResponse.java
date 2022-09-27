package com.example.companyproject.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
@Builder
public class CompanyResponse {
    private Long id;
    private String companyName;
    private String locatedCountry;
    private boolean isActive;
    private LocalDateTime created;
    private LocalDateTime updated;
}
