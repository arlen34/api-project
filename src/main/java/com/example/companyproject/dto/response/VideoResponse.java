package com.example.companyproject.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
public class VideoResponse {
    private Long id;
    private String videoName;
    private boolean isActive;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String link;

}
