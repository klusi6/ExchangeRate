package org.vaclavklusacek.exchangerate.contollers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vaclavklusacek.exchangerate.dto.ExchangeRateDTO;
import org.vaclavklusacek.exchangerate.service.ExchangeRateService;

import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping("")
    public ResponseEntity<?> getExchangeRates(@RequestParam(name = "usedb") boolean useDb){
        return ResponseEntity.ok(exchangeRateService.getExchangeRates(useDb).stream()
                .map(ExchangeRateDTO::new)
                .collect(Collectors.toList()));
    }
}
