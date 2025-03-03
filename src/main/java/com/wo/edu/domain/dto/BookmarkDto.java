package com.wo.edu.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarkDto extends IdDto {
    private Long courseId;

    private Long userId;
}
