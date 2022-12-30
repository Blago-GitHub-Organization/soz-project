package com.soz.creaditevaluator.service.interfaces;

import com.soz.creaditevaluator.models.Customer;

import java.math.BigDecimal;

public interface CustomerService
{
    public BigDecimal calculateFullRisk(final Customer customer);  //should use all others methods and return between 0 and 1000 (or 10000, or anything big)

    public BigDecimal calculateAgeRisk(final Customer customer);

    public BigDecimal calculateEmploymentRisk(final Customer customer);

    public BigDecimal calculateMaritalRisk(final Customer customer);

    public BigDecimal calculateEducationRisk(final Customer customer);

    public BigDecimal calculateSalaryRisk(final Customer customer);

    public BigDecimal calculateRisk(final Customer customer);

    public BigDecimal calculateFullWorkExperienceRisk(final Customer customer);

    public BigDecimal calculateCurrentWorkExperienceRisk(final Customer customer);

    public BigDecimal calculateSalaryPerCurrentWorkExperienceRisk(final Customer customer);
}
