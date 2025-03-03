package com.wo.edu.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto extends BaseDto {
    private String comment;
    private Long userId;
    private Long teacherId;

    private Long topicId;
}
