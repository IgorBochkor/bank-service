package com.dev.boot.bankservice.service.util;

import com.dev.boot.bankservice.model.Currency;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceExchangeRate {
    @Value(value = "$(service.url)")
    private String url;
    private final HttpClient httpClient;

    public ClientServiceExchangeRate(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public BigDecimal getRate(LocalDate date, Currency from, Currency to) {
        String path = String.format(url + "=%s&to=%s&date=%s", from, to, date);
        return httpClient.getResultFromHttpRequest(path);
    }
}
