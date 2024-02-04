package com.mybusiness.backend.stock.adapter.out.rest;

import com.mybusiness.backend.stock.domain.Company;
import com.mybusiness.backend.stock.port.RetrieveCompaniesPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
@Component
public class CompaniesAdapter implements RetrieveCompaniesPort {

    private final String endpoint = "/query";
    private final String apiKey = "I5UWEEHJ518LIRGF";
    private final WebClient webClient;

    public CompaniesAdapter(WebClient.Builder webClientBuilder) {
        String apiUrl = "https://www.alphavantage.co";
        this.webClient = webClientBuilder.baseUrl(apiUrl).build();
    }

    @Override
    public List<Company> retrieveCompaniesByWildcard(final String wildcard) {
        return webClient
                        .get()
                        .uri(uriBuilder -> uriBuilder.path(endpoint)
                                .queryParam("function", "SYMBOL_SEARCH")
                                .queryParam("keywords", wildcard)
                                .queryParam("apikey", apiKey)
                                .build())
                        .retrieve().bodyToMono(List.class).block();
    }
}
