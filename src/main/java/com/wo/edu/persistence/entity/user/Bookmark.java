package com.wo.edu.persistence.entity.user;

import com.wo.edu.persistence.entity.Base;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bookmarks")
@Getter
@Setter
public class Bookmark extends Base {
    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
