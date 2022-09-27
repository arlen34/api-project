package com.example.companyproject.service;

import com.example.companyproject.dto.request.InstructorRequest;
import com.example.companyproject.dto.response.InstructorResponse;

import java.util.List;

public interface InstructorsService {

    InstructorResponse createInstructor(long id, InstructorRequest request);

    List<InstructorResponse> getAllInstructors(long companyId);

    InstructorResponse getInstructorById(long id);

    InstructorResponse updateInstructor(long id,InstructorRequest request);

    InstructorResponse deleteInstructorById(long id);

    InstructorResponse  block(long id);
}
