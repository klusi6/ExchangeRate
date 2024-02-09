package org.vaclavklusacek.exchangerate.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vaclavklusacek.exchangerate.model.ExchangeRate;
import org.vaclavklusacek.exchangerate.service.ExchangeRateService;
import org.vaclavklusacek.exchangerate.dto.ExchangeRateDTO;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/db")
@AllArgsConstructor
public class ControllerForDB {

    public final ExchangeRateService exchangeRateService;

    @GetMapping("/rates")
    public String getExchangeRates(Model model) {
        List<ExchangeRate> rates = exchangeRateService.getLocalRates();
        if (!rates.isEmpty()) {
            model.addAttribute("rates", rates.stream()
                    .map(ExchangeRateDTO::new)
                    .collect(Collectors.toList()));
            return "indexDb";
        } else {
            model.addAttribute("message", "No exchange rates found, load first");
            return "error";
        }
    }

    @GetMapping("/rates/{shortName}")
    public String getExchangeRateDetail(Model model, @PathVariable String shortName) {
        ExchangeRate rate = exchangeRateService.getLocalDetailByShortName(shortName);
        if (rate != null) {
            model.addAttribute("rate", new ExchangeRateDTO(rate));
            return "detail";
        } else {
            model.addAttribute("message", "No exchange rate found");
            return "error";
        }
    }
}
