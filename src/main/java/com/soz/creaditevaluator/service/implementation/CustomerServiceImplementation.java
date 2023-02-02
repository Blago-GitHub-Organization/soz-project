package com.soz.creaditevaluator.service.implementation;

import com.soz.creaditevaluator.models.Customer;
import com.soz.creaditevaluator.models.customerenums.EducationLevel;
import com.soz.creaditevaluator.models.customerenums.EmploymentType;
import com.soz.creaditevaluator.models.customerenums.MaritalStatus;
import com.soz.creaditevaluator.service.interfaces.CustomerService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CustomerServiceImplementation implements CustomerService
{
    @Override
    public BigDecimal calculateFullRisk(Customer customer)
    {
       return calculateAgeRisk(customer)
                .add(calculateEducationRisk(customer))
                .add(calculateMaritalRisk(customer))
                .add(calculateSalaryRisk(customer))
               .add(calculateSalaryRisk(customer))
               .add(calculateCurrentWorkExperienceRisk(customer))
               .add(calculateFullWorkExperienceRisk(customer));
    }

    @Override
    public BigDecimal calculateAgeRisk(Customer customer)
    {
        LocalDate now = LocalDate.now();
        Long age = ChronoUnit.YEARS.between(customer.getBirthDate(), now);

        return new BigDecimal(age).multiply(new BigDecimal("12"));

    }

    @Override
    public BigDecimal calculateEmploymentRisk(Customer customer)
    {
        final EmploymentType type = customer.getEmploymentStatus();
        if(type == EmploymentType.STUDENT){
            return new BigDecimal("120");
        }
        else if(type == EmploymentType.PENSIONER){
            return new BigDecimal("220");
        }
        else if(type == EmploymentType.UNEMPLOYED){
            return new BigDecimal("60");
        }
        else if(type == EmploymentType.EMPLOYMENT_CONTRACT){
            return new BigDecimal("420");
        }
        else {
            return new BigDecimal("320");
        }
    }

    @Override
    public BigDecimal calculateMaritalRisk(Customer customer)
    {
        final MaritalStatus status = customer.getMaritalStatus();

        if(status == MaritalStatus.DIVORCED)
        {
            return new BigDecimal("220");
        }
        else if(status == MaritalStatus.SINGLE)
        {
            return new BigDecimal("320");
        }
        else if(status == MaritalStatus.MARRIED)
        {
            return new BigDecimal("420");
        }
        else if(status == MaritalStatus.WIDOWED)
        {
            return new BigDecimal("520");
        }
        else
        {
            return new BigDecimal("320");
        }
    }

    @Override
    public BigDecimal calculateEducationRisk(Customer customer)
    {
        final EducationLevel level = customer.getEducationLevel();

        if (level == EducationLevel.BACHELOR)
        {
            return new BigDecimal("750");
        }
       else if (level == EducationLevel.PRIMARY_EDUCATION)
        {
            return new BigDecimal("120");
        }
        else if (level == EducationLevel.EARLY_CHILDHOOD_EDUCATION)
        {
            return new BigDecimal("220");
        }
        else if (level == EducationLevel.MASTER)
        {
            return new BigDecimal("1200");
        }
        else
        {
            return new BigDecimal("65");
        }
    }

    @Override
    public BigDecimal calculateSalaryRisk(Customer customer)
    {
        return customer.getSalary().multiply(BigDecimal.TEN);
    }

    @Override
    public BigDecimal calculateRisk(Customer customer)
    {
        return BigDecimal.TEN;
    }

    @Override
    public BigDecimal calculateFullWorkExperienceRisk(Customer customer)
    {
        return new BigDecimal(customer.getFullWorkExperience()).multiply(new BigDecimal(10));
    }

    @Override
    public BigDecimal calculateCurrentWorkExperienceRisk(Customer customer)
    {
        return new BigDecimal(customer.getWorkExperienceWithCurrentEmployer()).multiply(new BigDecimal(20));
    }

    @Override
    public BigDecimal calculateSalaryPerCurrentWorkExperienceRisk(Customer customer)
    {
        return calculateSalaryRisk(customer).multiply(new BigDecimal(customer.getWorkExperienceWithCurrentEmployer()));
    }
}
