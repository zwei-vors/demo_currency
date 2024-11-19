package com.sparta.demo_currency.dto;

import com.sparta.demo_currency.entity.Currency;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyRequestDto {
    @NotNull(message = "통화 이름은 필수입니다.")
    private String currencyName;
    @NotNull(message = "환율 필수입니다.")
    private BigDecimal exchangeRate;
    private String symbol;
    private BigDecimal conversionFactor;

    public Currency toEntity() {
        return new Currency(
                this.currencyName,
                this.exchangeRate,
                this.symbol,
                this.conversionFactor
        );
    }
}
