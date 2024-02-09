package org.vaclavklusacek.exchangerate.contollers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.vaclavklusacek.exchangerate.dto.ExchangeRateDTO;
import org.vaclavklusacek.exchangerate.service.ExchangeRateService;

import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class MainController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping("/")
    public String getExchangeRates(Model model, @RequestParam(name = "usedb") boolean useDb){
       model.addAttribute("rates", exchangeRateService.getExchangeRates(useDb).stream()
               .map(ExchangeRateDTO::new)
               .collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/exchangerate/{shortName}")
    public String getExchangeRateDetail(Model model,  @RequestParam(name = "usedb") boolean useDb,
                                             @PathVariable String shortName){
       model.addAttribute("rate", new ExchangeRateDTO(exchangeRateService.getExchangeRateByShortName(shortName, useDb)));
        return "detail";
    }


}
