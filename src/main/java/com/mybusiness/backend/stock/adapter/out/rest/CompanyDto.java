package com.mybusiness.backend.stock.adapter.out.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Jacksonized
public class CompanyDto {
    @JsonProperty("2. name") String  name;
    @JsonProperty("3. type") String type;
    @JsonProperty("4. region") String region;
    @JsonProperty("9. matchScore") BigDecimal matchScore;
}