package com.example.companyproject.service;

import com.example.companyproject.dto.request.CompanyRequest;
import com.example.companyproject.dto.response.CompanyResponse;

import java.util.List;

public interface CompanyService {
    CompanyResponse createCompany(CompanyRequest request);

    List<CompanyResponse> getAllCompanies();

    CompanyResponse getCompanyById(long id);

    CompanyResponse updateCompany(long id,CompanyRequest request);

    CompanyResponse deleteCompanyById(long id);

    CompanyResponse  block(long id);

}
