package com.sparta.demo_currency.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyExchangeGroupByResponseDto {
    private Long count;
    private BigDecimal totalAmountInKrw;

    public CurrencyExchangeGroupByResponseDto(Long count, BigDecimal totalAmountInKrw) {
        this.count = count;
        this.totalAmountInKrw = totalAmountInKrw;
    }
}
