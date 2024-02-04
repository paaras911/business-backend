package com.mybusiness.backend.stock.port;

import com.mybusiness.backend.stock.domain.Company;

import java.util.List;

public interface RetrieveCompaniesPort {

    List<Company> retrieveCompaniesByWildcard(final String wildcard);
}
