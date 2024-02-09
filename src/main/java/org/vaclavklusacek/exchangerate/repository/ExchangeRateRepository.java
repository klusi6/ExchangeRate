package org.vaclavklusacek.exchangerate.repository;

import org.springframework.stereotype.Repository;
import org.vaclavklusacek.exchangerate.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    boolean existsExchangeRateByShortName(String shortName);

    ExchangeRate findByShortName(String shortName);
}
