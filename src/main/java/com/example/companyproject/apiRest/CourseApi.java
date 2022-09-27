package com.example.companyproject.apiRest;

import com.example.companyproject.dto.request.CourseRequest;
import com.example.companyproject.dto.response.CourseResponse;
import com.example.companyproject.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/course")
public class CourseApi {

    private final CourseService courseService;

    @PostMapping("{companyId}")
    public CourseResponse createCourse(@PathVariable("companyId") long id,
                                       @RequestBody CourseRequest request){
        return courseService.createCourse(id, request);
    }

    @GetMapping("getAll/{companyId}")
    public List<CourseResponse> getAllCourses(@PathVariable("companyId") long companyId){
        return courseService.getAllCourse(companyId);
    }

    @GetMapping("{id}")
    public CourseResponse getById(@PathVariable long id){
        return courseService.getCourseById(id);
    }


    @PutMapping("{id}")
    public CourseResponse updateCourse(@PathVariable long id,
                                       @RequestBody CourseRequest request){
        return courseService.updateCourse(id, request);
    }

    @DeleteMapping("{id}")
    public CourseResponse deleteCourse(@PathVariable long id){
        return courseService.deleteCourseById(id);
    }


    @PatchMapping("{id}")
    public CourseResponse block(@PathVariable long id){
        return courseService.block(id);
    }
}
