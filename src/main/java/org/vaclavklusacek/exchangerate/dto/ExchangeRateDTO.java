package org.vaclavklusacek.exchangerate.dto;

import org.vaclavklusacek.exchangerate.model.ExchangeRate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExchangeRateDTO(
        String shortName,
        LocalDateTime validFrom,
        String name,
        String country,
        BigDecimal move,
        BigDecimal amount,
        BigDecimal valBuy,
        BigDecimal valSell,
        BigDecimal valMid,
        BigDecimal currBuy,
        BigDecimal currSell,
        BigDecimal currMid,
        Integer version,
        BigDecimal cnbMid,
        BigDecimal ecbMid
) {
    public ExchangeRateDTO(ExchangeRate exchangeRate) {
        this(
                exchangeRate.getShortName(),
                exchangeRate.getValidFrom(),
                exchangeRate.getName(),
                exchangeRate.getCountry(),
                exchangeRate.getMove(),
                exchangeRate.getAmount(),
                exchangeRate.getValBuy(),
                exchangeRate.getValSell(),
                exchangeRate.getValMid(),
                exchangeRate.getCurrBuy(),
                exchangeRate.getCurrSell(),
                exchangeRate.getCurrMid(),
                exchangeRate.getVersion(),
                exchangeRate.getCnbMid(),
                exchangeRate.getEcbMid());
    }
}

