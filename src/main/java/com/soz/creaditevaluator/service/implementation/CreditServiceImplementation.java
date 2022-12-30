package com.soz.creaditevaluator.service.implementation;

import com.soz.creaditevaluator.models.Credit;
import com.soz.creaditevaluator.service.interfaces.CreditService;

import java.math.BigDecimal;

public class CreditServiceImplementation implements CreditService
{
    @Override
    public BigDecimal calculateFullRisk(Credit credit)
    {
        return null;
    }

    @Override
    public BigDecimal calculateAmountRisk(Credit credit)
    {
        return null;
    }

    @Override
    public BigDecimal calculateCapitalRisk(Credit credit)
    {
        return null;
    }

    @Override
    public BigDecimal calculateInstallmentRisk(Credit credit)
    {
        return null;
    }

    @Override
    public BigDecimal calculatePeriodRisk(Credit credit)
    {
        return null;
    }

    @Override
    public BigDecimal calculateCreditTypeRisk(Credit credit)
    {
        return null;
    }
}
