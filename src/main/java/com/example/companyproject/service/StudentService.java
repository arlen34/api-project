package com.example.companyproject.service;

import com.example.companyproject.dto.request.CourseRequest;
import com.example.companyproject.dto.response.CourseResponse;

import java.util.List;

public interface StudentService {
    CourseResponse createCourse(long id, CourseRequest request);

    List<CourseResponse> getAllCourse(long companyId);

    CourseResponse getCourseById(long id);

    CourseResponse updateCourse(long id,CourseRequest request);

    CourseResponse deleteCourseById(long id);

    CourseResponse  block(long id);
}
