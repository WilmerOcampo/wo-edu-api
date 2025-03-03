package com.wo.edu.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CourseDto extends BaseDto {
    private String title;
    private String description;
    private String thumbUri;
    private Boolean active;

    private Long teacherId;
    private Set<Long> categoryIds = new HashSet<>();
}
