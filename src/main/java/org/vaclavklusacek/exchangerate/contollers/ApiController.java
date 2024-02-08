package org.vaclavklusacek.exchangerate.contollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vaclavklusacek.exchangerate.service.ExchangeRateService;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final ExchangeRateService exchangeRateService;
}
