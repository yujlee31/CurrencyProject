package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class CurrencyResponseDto {
    private Long id;

    private String currencyName;
    private BigDecimal exchangeRate;
    private String symbol;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CurrencyResponseDto(Currency currency) {
        this.id = currency.getId();
        this.currencyName = currency.getCurrencyName();
        this.exchangeRate = currency.getExchangeRate();
        this.symbol = currency.getSymbol();
    }

    public CurrencyResponseDto(Long id, String currencyName, BigDecimal exchangeRate, String symbol) {
        this.id = id;
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
    }

    public CurrencyResponseDto(Long id, String currencyName, BigDecimal exchangeRate, String symbol, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static CurrencyResponseDto toDto(Currency currency) {
        return new CurrencyResponseDto(
                currency.getId(),
                currency.getCurrencyName(),
                currency.getExchangeRate(),
                currency.getSymbol(),
                currency.getCreatedAt(),
                currency.getModifiedAt()
        );
    }

}
