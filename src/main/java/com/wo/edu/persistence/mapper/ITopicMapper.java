package com.wo.edu.persistence.mapper;

import com.wo.edu.domain.dto.TopicDto;
import com.wo.edu.persistence.entity.course.Topic;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITopicMapper {
    @Mapping(target = "teacherId", ignore = true)
    @Mapping(target = "courseId", ignore = true)
    TopicDto toTopicDto(Topic topic);

    List<TopicDto> toTopicsDto(List<Topic> topics);

    @InheritInverseConfiguration
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "likes", ignore = true)
    @Mapping(target = "courses", ignore = true)
    Topic toTopic(TopicDto topicDto);
}
