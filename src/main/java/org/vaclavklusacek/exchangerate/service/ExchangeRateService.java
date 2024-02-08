package org.vaclavklusacek.exchangerate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaclavklusacek.exchangerate.repository.ExchangeRateRepository;

@Service
@AllArgsConstructor
public class ExchangeRateService {
   private final ExchangeRateRepository exchangeRateRepository;
}
