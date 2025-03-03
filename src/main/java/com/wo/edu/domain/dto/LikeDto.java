package com.wo.edu.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeDto extends IdDto {
    private Long userId;
    private Long teacherId;
    private Long topicId;
}
