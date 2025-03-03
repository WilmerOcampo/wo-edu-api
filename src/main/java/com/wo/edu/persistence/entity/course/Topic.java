package com.wo.edu.persistence.entity.course;

import com.wo.edu.persistence.entity.Base;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "topics")
@Getter
@Setter
public class Topic extends Base {
    @Column(nullable = false)
    private String title;
    private String description;
    @Column(name = "video_uri", nullable = false)
    private String videoUri;
    @Column(name = "thumb_uri")
    private String thumbUri;
    private Boolean active;
    @Column(name = "teacher_id", nullable = false)
    private Long teacherId;

    @OneToMany(mappedBy = "topic")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "topic")
    private Set<Like> likes = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "topic_couse",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();
}
