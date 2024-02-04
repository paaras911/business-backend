package com.mybusiness.backend.stock.adapter.out.rest;

import lombok.*;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class BestMatchesDto {

    List<CompanyDto> bestMatches;
}