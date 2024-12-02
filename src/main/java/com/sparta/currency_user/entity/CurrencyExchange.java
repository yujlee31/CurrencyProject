package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Getter
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

    public CurrencyExchange(User user, Currency toCurrencyById, BigDecimal amountInKrw, BigDecimal exchangedAmount, String status) {
        this.user = user;
        this.toCurrency = toCurrencyById;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = exchangedAmount;
        this.status = status;
    }

    public CurrencyExchange() {}

    public void update(String status) {
        this.status = status;
    }
}
