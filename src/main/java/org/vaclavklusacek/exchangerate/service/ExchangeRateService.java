package org.vaclavklusacek.exchangerate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.vaclavklusacek.exchangerate.model.ExchangeRate;
import org.vaclavklusacek.exchangerate.repository.ExchangeRateRepository;

import java.util.*;

@Service
@AllArgsConstructor
public class ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    /**
     * Fetches rates from the provided API URL
     */
    private ExchangeRate[] fetchRates() {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e";
        return restTemplate.getForObject(apiUrl, ExchangeRate[].class);
    }

    /**
     * Only For bank api use
     */
    public List<ExchangeRate> getOutsideRates() {
        ExchangeRate[] rates = fetchRates();
        assert rates != null;
        return Arrays.asList(rates);
    }

    public ExchangeRate getOutsideDetail(String shortName) {
        //converts to upper case to be more user-friendly
        String toUpper = shortName.toUpperCase();
        ExchangeRate[] rates = fetchRates();
        assert rates != null;
        return Arrays.stream(rates)
                .filter(rate -> rate.getShortName().equals(toUpper))
                .findFirst().orElse(null);
    }

    public List<ExchangeRate> getLocalRates() {
        return exchangeRateRepository.findAll();
    }

    /**
     * Returns local DB (also empty one),
     * or loads bank api and saves new exchange rates to DB (criteria is in this case ShortName)
     */
    public List<ExchangeRate> getRates(boolean useDb) {
        if (useDb) {
            return exchangeRateRepository.findAll();
        } else {
            ExchangeRate[] rates = fetchRates();
            if (rates != null) {
                for (ExchangeRate rate : rates) {
                    if (!exchangeRateRepository.existsExchangeRateByShortName(rate.getShortName())) {
                        exchangeRateRepository.save(rate);
                    }
                }
            }
            assert rates != null;
            return Arrays.asList(rates);
        }
    }

    public ExchangeRate getLocalDetailByShortName(String shortName) {
        //a little bit more user-friendly - if user writes lower case, it will be auto-converted to upper case
        return exchangeRateRepository.findByShortName(shortName.toUpperCase());
    }
}