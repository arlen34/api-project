package com.example.companyproject.repository;

import com.example.companyproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select c from Course c where c.company.id = :companyId and" +
            " c.isActive = true")
    List<Course> getAllCourses (@Param("companyId") long companyId);
}