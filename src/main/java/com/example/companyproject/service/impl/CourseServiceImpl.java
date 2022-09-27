package com.example.companyproject.service.impl;

import com.example.companyproject.dto.request.CourseRequest;
import com.example.companyproject.dto.response.CourseResponse;
import com.example.companyproject.model.Company;
import com.example.companyproject.model.Course;
import com.example.companyproject.repository.CompanyRepository;
import com.example.companyproject.repository.CourseRepository;
import com.example.companyproject.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;

    public Course mapToEntity(CourseRequest request){
        return Course.builder()
                .courseName(request.getCourseName())
                .dateOfStart(request.getDateOfStart())
                .duration(request.getDuration())
                .image(request.getImage())
                .description(request.getDescription())
                .created(LocalDateTime.now())
                .isActive(true)
                .build();
    }

    public CourseResponse mapToResponse(Course course){
        return CourseResponse.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .dateOfStart(course.getDateOfStart())
                .duration(course.getDuration())
                .description(course.getDescription())
                .image(course.getImage())
                .isActive(course.isActive())
                .created(course.getCreated())
                .updated(course.getUpdated())
                .build();
    }
    @Override
    public CourseResponse createCourse(long id, CourseRequest request) {
        Course course = mapToEntity(request);
        Company company = companyRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException
                        ("bul "+id+" degen id tapkan jok echnerse"));
        company.addCourse(course);
        course.setCompany(company);
        courseRepository.save(course);
        return mapToResponse(course);
    }

    @Override
    public List<CourseResponse> getAllCourse(long companyId) {
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course : courseRepository.getAllCourses(companyId)){
            courseResponses.add(mapToResponse(course));
        }
        return courseResponses;
    }

    @Override
    public CourseResponse getCourseById(long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(()->
                        new EntityNotFoundException
                                ("bul "+id+" degen id tapkan jok echnerse"));
        return mapToResponse(course);
    }

    @Override
    public CourseResponse updateCourse(long id, CourseRequest request) {
        Course course = courseRepository.findById(id)
                .orElseThrow(()->
                new EntityNotFoundException
                        ("bul "+id+" degen id tapkan jok echnerse"));
        Course courseUpdate = update(course,request);
        return mapToResponse(courseRepository.save(courseUpdate));
    }

    public Course update(Course course, CourseRequest request){
        course.setCourseName(request.getCourseName());
        course.setDateOfStart(request.getDateOfStart());
        course.setDuration(request.getDuration());
        course.setImage(request.getImage());
        course.setDescription(request.getDescription());
        course.setActive(course.isActive());
        course.setCreated(course.getCreated());
        course.setUpdated(LocalDateTime.now());
        return course;
    }
    @Override
    public CourseResponse deleteCourseById(long id) {
        Course course = courseRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException
                        ("bul "+id+" degen id tapkan jok echnerse"));
        courseRepository.delete(course);
        return mapToResponse(course);
    }

    @Override
    public CourseResponse block(long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(()->
                        new EntityNotFoundException
                                ("bul "+id+" degen id tapkan jok echnerse"));
        course.setActive(false);
        return mapToResponse(courseRepository.save(course));
    }
}
