package com.example.companyproject.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class LessonResponse {
    private Long id;
    private String lessonName;
    private boolean isActive = true;
    private LocalDateTime created;
    private LocalDateTime updated;
}
