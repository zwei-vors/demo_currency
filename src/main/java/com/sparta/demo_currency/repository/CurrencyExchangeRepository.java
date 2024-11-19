package com.sparta.demo_currency.repository;

import com.sparta.demo_currency.dto.CurrencyExchangeGroupByResponseDto;
import com.sparta.demo_currency.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    List<CurrencyExchange> findAllByUserId(Long userId);

    @Query("SELECT new com.sparta.demo_currency.dto.CurrencyExchangeGroupByResponseDto(" +
            "e.fromCurrency.currencyName, COUNT(e), SUM(e.amountInKrw)) " +
            "FROM CurrencyExchange e " +
            "WHERE e.user.id = :userId " +
            "GROUP BY e.fromCurrency.id")
    List<CurrencyExchangeGroupByResponseDto> findExchangeRequestsGroupedByCurrency(@Param("userId") Long userId);
}
