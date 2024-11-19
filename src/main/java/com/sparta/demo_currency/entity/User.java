package com.sparta.demo_currency.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CurrencyExchange> currencyExchange;

    public User(String name, String email, String status) {
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public User() {}
}