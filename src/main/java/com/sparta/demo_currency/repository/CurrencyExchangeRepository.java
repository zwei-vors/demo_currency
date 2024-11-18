package com.sparta.demo_currency.repository;

import com.sparta.demo_currency.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    List<CurrencyExchange> findAllByUserId(Long userId);
}
