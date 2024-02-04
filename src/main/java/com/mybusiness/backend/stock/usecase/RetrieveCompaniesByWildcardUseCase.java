package com.mybusiness.backend.stock.usecase;

import com.mybusiness.backend.stock.domain.Company;
import com.mybusiness.backend.stock.port.RetrieveCompaniesPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RetrieveCompaniesByWildcardUseCase {

    private final RetrieveCompaniesPort retrieveCompaniesPort;
    public List<Company> retrieveCompaniesByWildcard(String wildcard){
        return retrieveCompaniesPort.retrieveCompaniesByWildcard(wildcard);
    }
}
