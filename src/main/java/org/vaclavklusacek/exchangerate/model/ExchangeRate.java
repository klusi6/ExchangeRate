package org.vaclavklusacek.exchangerate.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
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
    @Column(precision=10, scale=3)
    private BigDecimal move;
    @Column(precision=10, scale=3)
    private BigDecimal amount;
    @Column(precision=10, scale=3)
    private BigDecimal valBuy;
    @Column(precision=10, scale=3)
    private BigDecimal valSell;
    @Column(precision=10, scale=3)
    private BigDecimal valMid;
    @Column(precision=10, scale=3)
    private BigDecimal currBuy;
    @Column(precision=10, scale=3)
    private BigDecimal currSell;
    @Column(precision=10, scale=3)
    private BigDecimal currMid;
    private Integer version;
    @Column(precision=10, scale=3)
    private BigDecimal cnbMid;
    @Column(precision=10, scale=3)
    private BigDecimal ecbMid;

}
