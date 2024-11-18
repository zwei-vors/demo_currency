package com.sparta.demo_currency.service;

import com.sparta.demo_currency.dto.CurrencyRequestDto;
import com.sparta.demo_currency.dto.CurrencyResponseDto;
import com.sparta.demo_currency.entity.Currency;
import com.sparta.demo_currency.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyResponseDto findById(Long id) {
        Optional<Currency> currency = currencyRepository.findById(id);
        if (currency.isEmpty()) {
            throw new IllegalArgumentException("해당 ID에 대한 데이터가 없습니다. 잘못된 ID 값 입니다.");
        }
        return new CurrencyResponseDto(currency.get());
    }

    public List<CurrencyResponseDto> findAll() {
        return currencyRepository.findAll().stream().map(CurrencyResponseDto::toDto).toList();
    }

    public CurrencyResponseDto save(CurrencyRequestDto currencyRequestDto) {
        Currency savedCurrency = currencyRepository.save(currencyRequestDto.toEntity());
        return new CurrencyResponseDto(savedCurrency);
    }
}
