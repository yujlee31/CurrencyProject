package com.sparta.currency_user.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class CurrencyExchange extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "toCurrencyId")
    private Currency toCurrency;

    private BigDecimal amountInKrw;
    private BigDecimal amountAfterExchange;
    private String status;
}
