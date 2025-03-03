package com.wo.edu.persistence.entity.course;

import com.wo.edu.persistence.entity.Base;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course extends Base {
    @Column(nullable = false)
    private String title;
    private String description;
    @Column(name = "thumb_uri")
    private String thumbUri;
    private Boolean active;

    @ManyToMany(mappedBy = "courses")
    private Set<Topic> topics = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
            name = "course_category",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();
}
