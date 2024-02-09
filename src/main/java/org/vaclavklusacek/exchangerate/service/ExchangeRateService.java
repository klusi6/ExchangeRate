package org.vaclavklusacek.exchangerate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.vaclavklusacek.exchangerate.model.ExchangeRate;
import org.vaclavklusacek.exchangerate.repository.ExchangeRateRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ExchangeRateService {

   private final ExchangeRateRepository exchangeRateRepository;

   private final String apiUrl = "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e";

   public List<ExchangeRate> getExchangeRates(boolean useDb) {
       if (useDb) {
           return exchangeRateRepository.findAll();
       }  else {
           RestTemplate restTemplate = new RestTemplate();
           ExchangeRate[] rates = restTemplate.getForObject(apiUrl, ExchangeRate[].class);
           if (rates != null) {
               for (ExchangeRate rate : rates) {
                   // Check if the rate already exists in the database
                   if (!exchangeRateRepository.existsExchangeRateByShortName(rate.getShortName())) {
                       // If the rate doesn't exist (by ShortName), save it to the database
                       exchangeRateRepository.save(rate);
                   }
               }
           }
           return Arrays.asList(Objects.requireNonNull(rates));
       }
   }
}
