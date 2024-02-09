package org.vaclavklusacek.exchangerate.contollers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vaclavklusacek.exchangerate.dto.ExchangeRateDTO;
import org.vaclavklusacek.exchangerate.service.ExchangeRateService;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/bank")
@AllArgsConstructor
public class ControllerForBank {

    private final ExchangeRateService exchangeRateService;

    @RequestMapping("/rates")
    public String getExchangeRates(Model model){
        model.addAttribute("rates", exchangeRateService.getRatesFromApi()
        .stream()
                .map(ExchangeRateDTO::new)
                .collect(Collectors.toList()));
        return "index";
    }

    @RequestMapping("/detail/{shortName}")
    public String getExchangeRateDetail(Model model, @PathVariable String shortName){
        model.addAttribute("rate", new ExchangeRateDTO(exchangeRateService.getDetailRateFromApiByShortName(shortName)));
        return "detail";
    }

}
