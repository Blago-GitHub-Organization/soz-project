package com.soz.creaditevaluator.service.implementation;

import com.soz.creaditevaluator.models.Credit;
import com.soz.creaditevaluator.models.Customer;
import com.soz.creaditevaluator.service.interfaces.CreditToCustomerService;

import java.math.BigDecimal;

public class CreditToCustomerServiceImplementation implements CreditToCustomerService
{
    @Override
    public BigDecimal calculateFullRisk(Credit credit, Customer customer)
    {
        return null;
    }

    @Override
    public BigDecimal calculateInstallmentPerSalaryRisk(Credit credit, Customer customer)
    {
        return null;
    }

    @Override
    public BigDecimal calculatePeriodPerWorkExperienceRisk(Credit credit, Customer customer)
    {
        return null;
    }

    @Override
    public BigDecimal calculateCapitalPerWorkExperienceRisk(Credit credit, Customer customer)
    {
        return null;
    }
}
