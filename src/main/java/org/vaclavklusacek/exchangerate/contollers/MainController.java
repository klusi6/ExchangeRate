package org.vaclavklusacek.exchangerate.contollers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.vaclavklusacek.exchangerate.service.ExchangeRateService;

@Controller
@AllArgsConstructor
public class MainController {

    private final ExchangeRateService exchangeRateService;

}
