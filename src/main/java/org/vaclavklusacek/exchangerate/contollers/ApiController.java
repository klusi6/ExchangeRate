package org.vaclavklusacek.exchangerate.contollers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vaclavklusacek.exchangerate.dto.ExchangeRateDTO;
import org.vaclavklusacek.exchangerate.dto.MessageDTO;
import org.vaclavklusacek.exchangerate.model.ExchangeRate;
import org.vaclavklusacek.exchangerate.service.ExchangeRateService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping("/rates")
    public ResponseEntity<?> getExchangeRates(@RequestParam(name = "usedb") boolean useDb) {
        List<ExchangeRate> rates = exchangeRateService.getRates(useDb);
        if (!rates.isEmpty()) {
            return ResponseEntity.ok(exchangeRateService.getRates(useDb).stream()
                    .map(ExchangeRateDTO::new)
                    .collect(Collectors.toList()));
        } else {
            //in case of empty DB, return little help note
            return ResponseEntity.ok(new MessageDTO("no content, load first with /api/rates/?usedb=false"));
        }
    }
}
