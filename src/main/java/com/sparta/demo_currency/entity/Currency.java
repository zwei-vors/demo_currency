package com.sparta.demo_currency.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currencyName;
    private BigDecimal exchangeRate;
    private String symbol;
    private BigDecimal conversionFactor;
    private LocalDateTime createdAt; // TODO: BaseEntity 분리 필요
    private LocalDateTime modifiedAt;

    public Currency(String currencyName, BigDecimal exchangeRate, String symbol, BigDecimal conversionFactor) {
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
        this.conversionFactor = conversionFactor;
    }

    public Currency() {}
}
