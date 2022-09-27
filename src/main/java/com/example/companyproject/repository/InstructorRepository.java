package com.example.companyproject.repository;

import com.example.companyproject.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    @Query("select i from Instructor i where i.company.id = :companyId and" +
            " i.isActive = true")
    List<Instructor> getAllInstructor (@Param("companyId") long companyId);
}