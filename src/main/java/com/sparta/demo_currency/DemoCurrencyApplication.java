package com.sparta.demo_currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DemoCurrencyApplication {

    public static void main(String[] args) {SpringApplication.run(DemoCurrencyApplication.class, args);}
}