package org.vaclavklusacek.exchangerate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ExchangeRate {

    @Id
    private String shortName;

    private LocalDateTime validFrom;

    private String name;

    private String country;

    private BigDecimal move;

    private BigDecimal amount;

    private BigDecimal valBuy;

    private BigDecimal valSell;

    private BigDecimal valMid;

    private BigDecimal currBuy;

    private BigDecimal currSell;

    private BigDecimal currMid;

    private Integer version;

    private BigDecimal cnbMid;

    private BigDecimal ecbMid;

}
