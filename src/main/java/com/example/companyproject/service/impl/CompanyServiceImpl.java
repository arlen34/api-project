package com.example.companyproject.service.impl;


import com.example.companyproject.dto.request.CompanyRequest;
import com.example.companyproject.dto.response.CompanyResponse;
import com.example.companyproject.model.Company;
import com.example.companyproject.repository.CompanyRepository;
import com.example.companyproject.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    /**Методы JSON<--->Entity*/
    public Company mapToEntity(CompanyRequest request){
        return Company.builder()
                .companyName(request.getCompanyName())
                .locatedCountry(request.getLocatedCountry())
                .isActive(true)
                .created(LocalDateTime.now())
                .build();
    }
    public CompanyResponse mapToResponse(Company company){
        return CompanyResponse.builder()
                .id(company.getId())
                .companyName(company.getCompanyName())
                .locatedCountry(company.getLocatedCountry())
                .isActive(company.isActive())
                .created(company.getCreated())
                .updated(company.getUpdated())
                .build();
    }
    /**--------------------------------------------------------*/
    /********************CRUD*********************************/
    @Override
    public CompanyResponse createCompany(CompanyRequest request) {
        Company company = mapToEntity(request);
        companyRepository.save(company);
        return mapToResponse(company);
    }


    @Override
    public List<CompanyResponse> getAllCompanies() {
       List<CompanyResponse> companyResponses = new ArrayList<>();
       for (Company company : companyRepository.getAllCompanies()){
           companyResponses.add(mapToResponse(company));
       }
       return companyResponses;
    }
    @Override
    public CompanyResponse getCompanyById(long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(()->
                        new EntityNotFoundException
                                ("Company with id " + id +"not found"));
        return mapToResponse(company);
    }


    @Override
    public CompanyResponse updateCompany(long id, CompanyRequest request) {
        Company company = companyRepository.findById(id).get();
        Company companyUpd = updateCompanyMethod(company,request);
        return mapToResponse(companyRepository.save(companyUpd));
    }
    public Company updateCompanyMethod(Company company,CompanyRequest request){
        company.setCompanyName(request.getCompanyName());
        company.setLocatedCountry(request.getLocatedCountry());
        company.setActive(company.isActive());
        company.setUpdated(LocalDateTime.now());
        company.setCreated(company.getCreated());
        return company;
    }

    @Override
    public CompanyResponse deleteCompanyById(long id) {
        Company company = companyRepository.findById(id).get();
        companyRepository.delete(company);
        return mapToResponse(company);
    }

    @Override
    public CompanyResponse block(long id) {
        Company company = companyRepository.findById(id).get();
        company.setActive(false);
        return mapToResponse(companyRepository.save(company));
    }

}
