package com.example.companyproject.apiRest;

import com.example.companyproject.dto.response.CompanyResponse;
import com.example.companyproject.dto.request.CompanyRequest;
import com.example.companyproject.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/company")
@RestController
public class CompanyApi {
    private final CompanyService companyService;

    @PostMapping
    public CompanyResponse create(@RequestBody CompanyRequest request){
        return companyService.createCompany(request);
    }

    @GetMapping("{id}")
    public CompanyResponse getById(@PathVariable long id){
        return companyService.getCompanyById(id);
    }

    @GetMapping
    public List<CompanyResponse> getAll(){
        return companyService.getAllCompanies();
    }

    @PutMapping("{id}")
    public CompanyResponse updateCompany(@PathVariable long id,
                                         @RequestBody CompanyRequest request){
        return companyService.updateCompany(id, request);
    }

    @PatchMapping("{id}")
    public CompanyResponse block(@PathVariable long id){
        return companyService.block(id);
    }

    @DeleteMapping("{id}")
    public CompanyResponse deleteCompany(@PathVariable long id){
        return companyService.deleteCompanyById(id);
    }
}
