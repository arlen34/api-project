package com.example.companyproject.service.impl;

import com.example.companyproject.dto.request.InstructorRequest;
import com.example.companyproject.dto.response.InstructorResponse;
import com.example.companyproject.model.Company;
import com.example.companyproject.model.Instructor;
import com.example.companyproject.repository.CompanyRepository;
import com.example.companyproject.repository.InstructorRepository;
import com.example.companyproject.service.InstructorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorsService {

    private final InstructorRepository instructorRepository;
    private final CompanyRepository companyRepository;

    public Instructor mapToEntity(InstructorRequest request){
        return Instructor.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .specialization(request.getSpecialization())
                .created(LocalDateTime.now())
                .isActive(true)
                .build();
    }
    public InstructorResponse mapToResponse(Instructor instructor){
        return InstructorResponse.builder()
                .id(instructor.getId())
                .firstName(instructor.getFirstName())
                .lastName(instructor.getLastName())
                .phoneNumber(instructor.getPhoneNumber())
                .email(instructor.getEmail())
                .specialization(instructor.getSpecialization())
                .isActive(instructor.isActive())
                .created(instructor.getCreated())
                .updated(instructor.getUpdated())
                .build();
    }
    @Override
    public InstructorResponse createInstructor(long id,
                                               InstructorRequest request) {
        Instructor instructor = mapToEntity(request);
        Company company = companyRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException
                        ("with id="+id+"not found"));
        company.addInstructor(instructor);
        instructor.setCompany(company);
        instructorRepository.save(instructor);
        return mapToResponse(instructor);
    }

    @Override
    public List<InstructorResponse> getAllInstructors(long companyId) {
        List<InstructorResponse> instructorResponses = new ArrayList<>();
        for (Instructor instructor : instructorRepository.getAllInstructor(companyId)){
            instructorResponses.add(mapToResponse(instructor));
        }
        return instructorResponses;
    }

    @Override
    public InstructorResponse getInstructorById(long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(()->
                        new EntityNotFoundException
                                ("with id="+id+"not found"));
        return mapToResponse(instructor);
    }

    @Override
    public InstructorResponse updateInstructor(long id,
                                               InstructorRequest request) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(()->
                        new EntityNotFoundException
                                ("with id="+id+"not found"));
        Instructor instructorUpd = update(instructor,request);
        return mapToResponse(instructorRepository.save(instructorUpd));
    }

    public Instructor update(Instructor instructor,
                             InstructorRequest request){
        instructor.setFirstName(request.getFirstName());
        instructor.setLastName(request.getLastName());
        instructor.setEmail(request.getEmail());
        instructor.setPhoneNumber(request.getPhoneNumber());
        instructor.setSpecialization(request.getSpecialization());
        instructor.setUpdated(LocalDateTime.now());
        instructor.setActive(instructor.isActive());
        instructor.setCreated(instructor.getCreated());
        return instructor;
    }
    @Override
    public InstructorResponse deleteInstructorById(long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(()->
                        new EntityNotFoundException
                                ("with id="+id+"not found"));
        instructorRepository.delete(instructor);
        return mapToResponse(instructor);
    }

    @Override
    public InstructorResponse block(long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(()->
                        new EntityNotFoundException
                                ("with id="+id+"not found"));
        instructor.setActive(false);
        return mapToResponse(instructorRepository.save(instructor));
    }


}
