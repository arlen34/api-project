package com.example.companyproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lessons")
@Getter@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @SequenceGenerator(
            name = "lessons_sequence",
            allocationSize = 1,
            sequenceName = "lessons_id_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lessons_sequence"
    )
    private Long id;

    @Column(name = "lesson_name")
    private String lessonName;
    private boolean isActive = true;
    @CreatedDate
    private LocalDateTime created;
    @CreatedDate
    private LocalDateTime updated;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "lesson")
    private Video video;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "lesson")
    private List<Task> tasks;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "course_id")
    private Course course;

    public void addTasks(Task task) {
        if(tasks == null) {
            tasks = new ArrayList<>();
        } else {
            this.tasks.add(task);
        }
    }
}
