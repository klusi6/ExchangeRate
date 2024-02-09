package org.vaclavklusacek.exchangerate.contollers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vaclavklusacek.exchangerate.service.ExchangeRateService;

@Controller
@RequestMapping("/db")
@AllArgsConstructor
public class ControllerForDB {

    public final ExchangeRateService exchangeRateService;


}
