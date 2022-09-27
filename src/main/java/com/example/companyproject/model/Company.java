package com.example.companyproject.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter @Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Company {
    @Id
    @SequenceGenerator(
            name = "companies_sequence",
            allocationSize = 1,
            sequenceName = "companies_id_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "companies_sequence"
    )
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "located_country")
    private String locatedCountry;

    private boolean isActive = true;
    @CreatedDate
    private LocalDateTime created;
    @CreatedDate
    private LocalDateTime updated;
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "company",
            fetch = FetchType.EAGER)
    private List<Course> courses;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    private List<Instructor> instructors;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    private List<Student> students ;

    public void addCourse(Course course){
        if (courses == null){
            courses= new ArrayList<>();
        }
        courses.add(course);
    }


    public void addInstructor(Instructor instructor) {
        if(instructors == null) {
            instructors = new ArrayList<>();
        } else {
            this.instructors.add(instructor);
        }
    }

    public void addStudent(Student student){
        if (students == null){
            students= new ArrayList<>();
        }
        students.add(student);
    }

}
