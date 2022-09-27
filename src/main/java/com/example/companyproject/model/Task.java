package com.example.companyproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter @Setter
@NoArgsConstructor
public class Task {

    @Id
    @SequenceGenerator(
            name = "tasks_sequence",
            allocationSize = 1,
            sequenceName = "tasks_id_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tasks_sequence"
    )
    private Long id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_text")
    private String taskText;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column
    private LocalDate deadline;
    private boolean isActive = true;
    @CreatedDate
    private LocalDateTime created;
    @CreatedDate
    private LocalDateTime updated;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;




}
