package org.vaclavklusacek.exchangerate.repository;

import org.vaclavklusacek.exchangerate.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
}
