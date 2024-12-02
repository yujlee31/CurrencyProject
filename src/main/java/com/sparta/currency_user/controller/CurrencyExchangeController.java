package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.CurrencyExchangeRequestDto;
import com.sparta.currency_user.dto.CurrencyExchangeResponseDto;
import com.sparta.currency_user.service.CurrencyExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency-exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {
    private final CurrencyExchangeService currencyExchangeService;

    @PostMapping
    public ResponseEntity<CurrencyExchangeResponseDto> exchangeCurrency(@RequestBody CurrencyExchangeRequestDto currencyExchangeRequestDto) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(currencyExchangeService.exchangeRequest(currencyExchangeRequestDto.getUserId(),
//                currencyExchangeRequestDto.getToCurrencyId(),
//                currencyExchangeRequestDto.getAmountInKrw(),
//                currencyExchangeRequestDto.getStatus())
//        );
        return ResponseEntity.status(HttpStatus.CREATED).body(currencyExchangeService.exchangeRequest(currencyExchangeRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CurrencyExchangeResponseDto> updateExchangeCurrency(@PathVariable Long id, @RequestBody String status) {
        return ResponseEntity.ok().body(currencyExchangeService.updateExchangeRequest(id, status));
    }

    @GetMapping
    public ResponseEntity<List<CurrencyExchangeResponseDto>> getExchangeCurrency(@RequestParam Long userId) {
        return ResponseEntity.ok().body(currencyExchangeService.findAll(userId));
    }
}
