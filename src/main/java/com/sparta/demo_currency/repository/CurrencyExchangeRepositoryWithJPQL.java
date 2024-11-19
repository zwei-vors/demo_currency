package com.sparta.demo_currency.repository;

import com.sparta.demo_currency.dto.CurrencyExchangeGroupByResponseDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrencyExchangeRepositoryWithJPQL {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CurrencyExchangeGroupByResponseDto> findExchangeRequestsGroupedByCurrency(Long userId) {
        String jpql = "SELECT " +
                "new com.sparta.demo_currency.dto.CurrencyExchangeGroupByResponseDto(" +
                "e.fromCurrency.currencyName, COUNT(e), SUM(e.amountInKrw)) " +
                "FROM CurrencyExchange e " +
                "WHERE e.user.id = :userId " +
                "GROUP BY e.fromCurrency.id";

        return entityManager.createQuery(jpql, CurrencyExchangeGroupByResponseDto.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
