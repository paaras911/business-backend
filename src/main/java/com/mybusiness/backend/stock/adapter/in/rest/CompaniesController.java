package com.mybusiness.backend.stock.adapter.in.rest;

import com.mybusiness.backend.stock.adapter.in.rest.resource.CompanyResponse;
import com.mybusiness.backend.stock.domain.Company;
import com.mybusiness.backend.stock.usecase.RetrieveCompaniesByWildcardUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/companies")
public class CompaniesController {
    private final RetrieveCompaniesByWildcardUseCase retrieveCompaniesByWildcardUseCase;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CompanyResponse>> companyByWildcard(@RequestParam(name = "wildcard") String wildcard) {
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .body(mapToDto(retrieveCompaniesByWildcardUseCase.retrieveCompaniesByWildcard(wildcard)));
    }

    private List<CompanyResponse> mapToDto(final List<Company> companies) {
        return companies.stream().map(company -> new CompanyResponse(company.name(), company.type())).toList();
    }
}
