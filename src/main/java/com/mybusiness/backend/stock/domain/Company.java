package com.mybusiness.backend.stock.domain;

import java.math.BigDecimal;

public record Company(String name, String type, String region, BigDecimal score) {
}
