package com.example.companyproject.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@Getter @Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Instructor {

    @Id
    @SequenceGenerator(
            name = "instructors_sequence",
            allocationSize = 1,
            sequenceName = "instructors_id_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "instructors_sequence"
    )
    private Long id;
    @Column(name = "first_name")

    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column
    private String email;

    @Column
    private String specialization;
    private boolean isActive = true;
    @CreatedDate
    private LocalDateTime created;
    @CreatedDate
    private LocalDateTime updated;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    private Company company;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    private List<Course> courses;

    public void addCourse(Course course) {
        if (courses == null){
            courses = new ArrayList<>();
        }
        courses.add(course);
    }
}
