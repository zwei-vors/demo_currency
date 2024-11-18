package com.sparta.demo_currency.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String status;
    private LocalDateTime createdAt; // TODO: BaseEntity 분리 필요
    private LocalDateTime modifiedAt;

    public User(String name, String email, String status) {
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public User() {}
}