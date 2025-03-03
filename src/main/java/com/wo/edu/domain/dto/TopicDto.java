package com.wo.edu.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicDto extends BaseDto {
    private String title;
    private String description;
    private String videoUri;
    private String thumbUri;
    private Boolean active;
    private Long teacherId;
    private Long courseId;
}
