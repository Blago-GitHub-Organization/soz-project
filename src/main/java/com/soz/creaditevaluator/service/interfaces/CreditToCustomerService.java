package com.soz.creaditevaluator.service.interfaces;

import com.soz.creaditevaluator.models.Credit;
import com.soz.creaditevaluator.models.Customer;

import java.math.BigDecimal;

public interface CreditToCustomerService
{
    public BigDecimal calculateFullRisk(final Credit credit, final Customer customer);  //should use all others methods and return between 0 and 1000 (or 10000, or anything big)

    public BigDecimal calculateInstallmentPerSalaryRisk(final Credit credit, final Customer customer);

    public BigDecimal calculatePeriodPerWorkExperienceRisk(final Credit credit, final Customer customer);

    public BigDecimal calculateCapitalPerWorkExperienceRisk(final Credit credit, final Customer customer);

}
