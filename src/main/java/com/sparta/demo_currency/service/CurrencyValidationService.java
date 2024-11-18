package com.sparta.demo_currency.service;

import com.sparta.demo_currency.entity.Currency;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CurrencyValidationService {

    private final CurrencyService currencyService;

    @PostConstruct
    public void validateExchangeRatesOnStartup() {
        List<Currency> currencies = currencyService.findCurrencies();

        for (Currency currency : currencies) {
            if (currency.getExchangeRate() == null || currency.getExchangeRate().compareTo(BigDecimal.ZERO) <= 0) {
                log.error("올바르지 않은 환율 값입니다.: {}", currency.getCurrencyName());
            }
        }
    }
}
