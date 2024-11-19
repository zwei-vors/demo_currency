package com.sparta.demo_currency.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyExchangeRequestDto {
    private Long userId;
    private Long fromCurrencyId;
    private Long toCurrencyId;

    private BigDecimal amountInKrw;
    private String status;
}
