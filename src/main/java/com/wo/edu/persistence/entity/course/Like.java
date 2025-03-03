package com.wo.edu.persistence.entity.course;

import com.wo.edu.persistence.entity.Base;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "likes")
@Getter
@Setter
public class Like extends Base {
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "teacher_id", nullable = false)
    private Long teacherId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;
}
