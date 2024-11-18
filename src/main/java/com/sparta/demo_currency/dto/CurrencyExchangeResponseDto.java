package com.sparta.demo_currency.dto;

import com.sparta.demo_currency.entity.CurrencyExchange;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class CurrencyExchangeResponseDto {
    private Long userId;
    private Long fromCurrencyId;
    private Long toCurrencyId;

    private BigDecimal amountInKrw;
    private BigDecimal amountAfterExchange;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CurrencyExchangeResponseDto(CurrencyExchange savedCurrencyExchange) {}

    public CurrencyExchangeResponseDto(Long userId, Long fromCurrencyId, Long toCurrencyId, BigDecimal amountInKrw, BigDecimal amountAfterExchange, String status, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.userId = userId;
        this.fromCurrencyId = fromCurrencyId;
        this.toCurrencyId = toCurrencyId;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.status = status;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static CurrencyExchangeResponseDto toDto(CurrencyExchange currencyExchange) {
        return new CurrencyExchangeResponseDto(
                currencyExchange.getUser().getId(),
                currencyExchange.getFromCurrency().getId(),
                currencyExchange.getToCurrency().getId(),
                currencyExchange.getAmountInKrw(),
                currencyExchange.getAmountAfterExchange(),
                currencyExchange.getStatus(),
                currencyExchange.getCreatedAt(),
                currencyExchange.getModifiedAt()
        );
    }
}
