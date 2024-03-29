package com.soz.creaditevaluator.service.implementation;

import com.soz.creaditevaluator.models.Credit;
import com.soz.creaditevaluator.models.Customer;
import com.soz.creaditevaluator.service.interfaces.CreditToCustomerService;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditToCustomerServiceImplementation implements CreditToCustomerService
{

    @Override
    public BigDecimal calculateCreditToCustomerFullScore(Credit credit, Customer customer)
    {
        BigDecimal installmentPerSalaryScore = calculateInstallmentPerSalaryScore(credit, customer) ;
        BigDecimal periodPerWorkExperienceScore = calculatePeriodPerWorkExperienceScore(credit, customer);
        BigDecimal capitalPerWorkExperienceScore = calculateCapitalPerWorkExperienceScore(credit, customer);
        return installmentPerSalaryScore.add(periodPerWorkExperienceScore).add(capitalPerWorkExperienceScore);

    }

    @Override
    public BigDecimal calculateInstallmentPerSalaryScore(Credit credit, Customer customer)
    {

        BigDecimal installment = credit.getInstallment();
        BigDecimal salary = customer.getSalary();

        if (salary.compareTo(BigDecimal.ZERO) == 0)
        {
            // Return a high risk value if the salary is zero
            return new BigDecimal("10.00");
        } else
        {
            // Calculate the risk by dividing the installment by the salary
            return  installment.divide(salary, 2, RoundingMode.HALF_UP);
        }

    }


    @Override
    public BigDecimal calculatePeriodPerWorkExperienceScore(Credit credit, Customer customer)
    {


        Integer period = credit.getPeriod();
        Integer fullWorkExperience = customer.getFullWorkExperience();

        if (fullWorkExperience == 0)
        {
            // Return a high risk value if the work experience is zero
            return new BigDecimal("10.00");
        } else
        {
            // Calculate the risk by dividing the period by the full work experience
            return new BigDecimal(period)
                    .divide(new BigDecimal(fullWorkExperience), 2, RoundingMode.HALF_UP);
        }
    }

    @Override
    public BigDecimal calculateCapitalPerWorkExperienceScore(Credit credit, Customer customer)
    {

        BigDecimal workExperienceFactor = BigDecimal.valueOf(customer.getFullWorkExperience() / 10.0);
        return credit.getCapital().multiply(workExperienceFactor);

    }
}
