package org.vaclavklusacek.exchangerate.repository;

import org.vaclavklusacek.exchangerate.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    boolean existsExchangeRateByShortName(String shortName);
}
