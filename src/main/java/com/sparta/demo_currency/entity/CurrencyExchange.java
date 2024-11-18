package com.sparta.demo_currency.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
public class CurrencyExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fromCurrencyId")
    private Currency fromCurrency;

    @ManyToOne
    @JoinColumn(name = "toCurrencyId")
    private Currency toCurrency;

    private BigDecimal amountInKrw;
    private BigDecimal amountAfterExchange;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CurrencyExchange(User user, Currency fromCurrency, Currency toCurrency, BigDecimal amountInKrw, BigDecimal amountAfterExchange, String status) {
        this.user = user;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.status = status;
    }

    public CurrencyExchange() {}

    public void update(String status) {
        this.status = status;
    }
}
