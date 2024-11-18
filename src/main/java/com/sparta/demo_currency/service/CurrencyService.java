package com.sparta.demo_currency.service;

import com.sparta.demo_currency.dto.CurrencyRequestDto;
import com.sparta.demo_currency.dto.CurrencyResponseDto;
import com.sparta.demo_currency.entity.Currency;
import com.sparta.demo_currency.entity.User;
import com.sparta.demo_currency.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyResponseDto findById(Long id) {

        return new CurrencyResponseDto(findCurrencyById(id));
    }

    // TODO: repo로 옮겨야 함
    public Currency findCurrencyById(Long id) {
        return currencyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("통화를 찾을 수 없습니다."));
    }

    public List<CurrencyResponseDto> findAll() {
        return currencyRepository.findAll().stream().map(CurrencyResponseDto::toDto).toList();
    }

    @Transactional
    public CurrencyResponseDto save(CurrencyRequestDto currencyRequestDto) {
        Currency savedCurrency = currencyRepository.save(currencyRequestDto.toEntity());
        return new CurrencyResponseDto(savedCurrency);
    }
}
