package com.soz.creaditevaluator.service.interfaces;

import com.soz.creaditevaluator.models.Credit;

import java.math.BigDecimal;

public interface CreditService
{
    public BigDecimal calculateFullScore(final Credit credit); //should use all others methods and return between 0 and 1000 (or 10000, or anything big)

    public BigDecimal calculateAmountScore(final Credit credit);

    public BigDecimal calculateCapitalScore(final Credit credit);

    public BigDecimal calculateInstallmentScore(final Credit credit);

    public BigDecimal calculatePeriodScore(final Credit credit);

    public BigDecimal calculateCreditTypeScore(final Credit credit);

}
