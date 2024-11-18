package com.sparta.demo_currency.dto;

import com.sparta.demo_currency.entity.User;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String name;
    private String email;
    private String status;

    public User toEntity() {
        return new User(
                this.name,
                this.email,
                this.status
        );
    }
}
