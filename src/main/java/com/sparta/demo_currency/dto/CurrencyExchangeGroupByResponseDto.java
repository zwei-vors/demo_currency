package com.sparta.demo_currency.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyExchangeGroupByResponseDto {
    private String currencyName;
    private Long count;
    private BigDecimal totalAmountInKrw;

    public CurrencyExchangeGroupByResponseDto(String currencyName, Long count, BigDecimal totalAmountInKrw) {
        this.currencyName = currencyName;
        this.count = count;
        this.totalAmountInKrw = totalAmountInKrw;
    }
}
