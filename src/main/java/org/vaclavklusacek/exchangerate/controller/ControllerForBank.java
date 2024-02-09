package org.vaclavklusacek.exchangerate.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vaclavklusacek.exchangerate.dto.ExchangeRateDTO;
import org.vaclavklusacek.exchangerate.model.ExchangeRate;
import org.vaclavklusacek.exchangerate.service.ExchangeRateService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/bank")
@AllArgsConstructor
public class ControllerForBank {

    private final ExchangeRateService exchangeRateService;

    @GetMapping("/rates")
    public String getExchangeRates(Model model) {
        List<ExchangeRate> rates = exchangeRateService.getOutsideRates();
        if (!rates.isEmpty()) {
            model.addAttribute("rates", rates.stream()
                    .map(ExchangeRateDTO::new)
                    .collect(Collectors.toList()));
        } else {
            model.addAttribute("message", "No exchange rates found");
        }
        return "indexBank";
    }

    @GetMapping("/rates/{shortName}")
    public String getExchangeRateDetail(Model model, @PathVariable String shortName) {
        ExchangeRate rate = exchangeRateService.getOutsideDetail(shortName);
        if (rate != null) {
            model.addAttribute("rate", new ExchangeRateDTO(rate));
            return "detail";

        } else {
            model.addAttribute("message", "No exchange rate found");
            return "error";
        }
    }
}
