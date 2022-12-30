package com.soz.creaditevaluator.service.interfaces;

import com.soz.creaditevaluator.models.Credit;

import java.math.BigDecimal;

public interface CreditService
{
    public BigDecimal calculateFullRisk(final Credit credit); //should use all others methods and return between 0 and 1000 (or 10000, or anything big)

    public BigDecimal calculateAmountRisk(final Credit credit);

    public BigDecimal calculateCapitalRisk(final Credit credit);

    public BigDecimal calculateInstallmentRisk(final Credit credit);

    public BigDecimal calculatePeriodRisk(final Credit credit);

    public BigDecimal calculateCreditTypeRisk(final Credit credit);

}
