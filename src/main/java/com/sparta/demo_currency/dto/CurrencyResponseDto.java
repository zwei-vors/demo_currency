package com.sparta.demo_currency.dto;

import com.sparta.demo_currency.entity.Currency;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class CurrencyResponseDto {
    private Long id;

    private String currencyName;
    private BigDecimal exchangeRate;
    private String symbol;
    private String regionCode;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CurrencyResponseDto(Currency currency) {
        this.id = currency.getId();
        this.currencyName = currency.getCurrencyName();
        this.exchangeRate = currency.getExchangeRate();
        this.symbol = currency.getSymbol();
        this.regionCode = currency.getRegionCode();
        this.createdAt = currency.getCreatedAt();
        this.modifiedAt = currency.getModifiedAt();
    }

    public CurrencyResponseDto(Long id, String currencyName, BigDecimal exchangeRate, String symbol, String regionCode, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
        this.regionCode = regionCode;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static CurrencyResponseDto toDto(Currency currency) {
        return new CurrencyResponseDto(
            currency.getId(),
            currency.getCurrencyName(),
            currency.getExchangeRate(),
            currency.getSymbol(),
            currency.getRegionCode(),
            currency.getCreatedAt(),
            currency.getModifiedAt()
        );
    }
}
