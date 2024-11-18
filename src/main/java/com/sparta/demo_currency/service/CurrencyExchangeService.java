package com.sparta.demo_currency.service;

import com.sparta.demo_currency.dto.CurrencyExchangeRequestDto;
import com.sparta.demo_currency.dto.CurrencyExchangeResponseDto;
import com.sparta.demo_currency.entity.Currency;
import com.sparta.demo_currency.entity.CurrencyExchange;
import com.sparta.demo_currency.entity.User;
import com.sparta.demo_currency.repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeService {
    private final CurrencyExchangeRepository currencyExchangeRepository;
    private final UserService userService;
    private final CurrencyService currencyService;

    @Transactional
    public CurrencyExchangeResponseDto exchangeRequest(CurrencyExchangeRequestDto requestDto) {

        User user = userService.findUserById(requestDto.getUserId());
        Currency fromCurrencyById = currencyService.findCurrencyById(requestDto.getFromCurrencyId());
        Currency toCurrencyById = currencyService.findCurrencyById(requestDto.getToCurrencyId());

        // TODO: 여기서 계산을 하는게 맞는지 고민 필요
        BigDecimal amountAfterExchange = requestDto.getAmountInKrw().divide(toCurrencyById.getExchangeRate(), 2, RoundingMode.HALF_UP);

        CurrencyExchange currencyExchange = new CurrencyExchange(user, fromCurrencyById, toCurrencyById, requestDto.getAmountInKrw(), amountAfterExchange, requestDto.getStatus());
        CurrencyExchange savedCurrencyExchange = currencyExchangeRepository.save(currencyExchange);
        return new CurrencyExchangeResponseDto(savedCurrencyExchange);
    }

    @Transactional
    public CurrencyExchangeResponseDto updateExchangeRequest(Long id, String status) {
        CurrencyExchange currencyExchange = findById(id);

        currencyExchange.update(status);

        return CurrencyExchangeResponseDto.toDto(currencyExchange);
    }

    public CurrencyExchange findById(Long id) {
        return currencyExchangeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("환전 요청 기록을 찾을 수 없습니다."));
    }

    public List<CurrencyExchangeResponseDto> findAll(String email) {
        List<CurrencyExchange> currencyExchanges = currencyExchangeRepository.findAllByEmail(email);

        return currencyExchanges.stream().map(CurrencyExchangeResponseDto::toDto).toList();
    }
}
