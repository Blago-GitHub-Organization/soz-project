package com.soz.creaditevaluator.service.implementation;

import com.soz.creaditevaluator.models.Customer;
import com.soz.creaditevaluator.models.customerenums.EducationLevel;
import com.soz.creaditevaluator.models.customerenums.EmploymentType;
import com.soz.creaditevaluator.models.customerenums.MaritalStatus;
import com.soz.creaditevaluator.service.interfaces.CustomerService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class CustomerServiceImplementation implements CustomerService {
    @Override
    public BigDecimal calculateFullRisk(Customer customer) {
        return null;
    }


    @Override
    public BigDecimal calculateAgeRisk(Customer customer) {
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(customer.getBirthDate(), currentDate);
        BigDecimal ageRisk;
        if (age.getYears() < 30) {
            ageRisk = new BigDecimal(0.05);
        } else if (age.getYears() >= 30 && age.getYears() < 40) {
            ageRisk = new BigDecimal(0.03);
        } else if (age.getYears() >= 40 && age.getYears() < 50) {
            ageRisk = new BigDecimal(0.01);
        } else {
            ageRisk = new BigDecimal(0.0);
        }
        return ageRisk;
    }

    @Override
    public BigDecimal calculateEmploymentRisk(Customer customer) {
        EmploymentType employmentStatus = customer.getEmploymentStatus();
        switch (employmentStatus) {
            case UNEMPLOYED:
                return new BigDecimal("0.9");
            case STUDENT:
                return new BigDecimal("0.7");
            case CIVIL_CONTRACT:
                return new BigDecimal("0.8");
            case EMPLOYMENT_CONTRACT:
                return new BigDecimal("0.6");
            case PENSIONER:
                return new BigDecimal("0.4");
            default:
                return new BigDecimal("0.0");
        }
    }

        @Override
        public BigDecimal calculateMaritalRisk (Customer customer)
        {
            MaritalStatus maritalStatus = customer.getMaritalStatus();
            BigDecimal maritalRiskFactor;

            switch (maritalStatus) {
                case SINGLE:
                    maritalRiskFactor = new BigDecimal("0.9");
                    break;
                case MARRIED:
                    maritalRiskFactor = new BigDecimal("0.8");
                    break;
                case DIVORCED:
                    maritalRiskFactor = new BigDecimal("1.1");
                    break;
                case WIDOWED:
                    maritalRiskFactor = new BigDecimal("0.95");
                    break;
                default:
                    maritalRiskFactor = BigDecimal.ONE;
                    break;
            }
        }

            @Override
            public BigDecimal calculateEducationRisk (Customer customer)
            {
                EducationLevel educationLevel = customer.getEducationLevel();
                BigDecimal educationRisk = new BigDecimal("1");

                switch (educationLevel) {
                    case PRIMARY_EDUCATION:
                        educationRisk = new BigDecimal("1.1");
                        break;
                    case BACHELOR:
                        educationRisk = new BigDecimal("1.05");
                        break;
                    case MASTER:
                        educationRisk = new BigDecimal("1.03");
                        break;
                    case SHORT_CYCLE:
                        educationRisk = new BigDecimal("1.01");
                        break;
                    default:
                        educationRisk = new BigDecimal("1.00");
                        break;
                }
                return educationRisk;
            }

            @Override
            public BigDecimal calculateSalaryRisk (Customer customer)
            {
                BigDecimal salaryRisk = BigDecimal.ZERO;

                if (customer.getSalary().compareTo(BigDecimal.valueOf(3000)) < 0) {
                    salaryRisk = salaryRisk.add(BigDecimal.valueOf(0.5));
                } else if (customer.getSalary().compareTo(BigDecimal.valueOf(5000)) < 0) {
                    salaryRisk = salaryRisk.add(BigDecimal.valueOf(0.3));
                } else if (customer.getSalary().compareTo(BigDecimal.valueOf(8000)) < 0) {
                    salaryRisk = salaryRisk.add(BigDecimal.valueOf(0.2));
                }

                return salaryRisk;
            }

            @Override
            public BigDecimal calculateRisk (Customer customer)
            {
                return null;
            }

            @Override
            public BigDecimal calculateFullWorkExperienceRisk (Customer customer)
            {
                BigDecimal fullRisk = BigDecimal.ZERO;

                if (customer.getFullWorkExperience() != null) {
                    if (customer.getFullWorkExperience() < 5) {
                        fullRisk = fullRisk.add(BigDecimal.valueOf(0.05));
                    } else if (customer.getFullWorkExperience() >= 5 && customer.getFullWorkExperience() < 10) {
                        fullRisk = fullRisk.add(BigDecimal.valueOf(0.03));
                    } else if (customer.getFullWorkExperience() >= 10) {
                        fullRisk = fullRisk.add(BigDecimal.valueOf(0.01));
                    }
                }

                return fullRisk;
            }

            @Override
            public BigDecimal calculateCurrentWorkExperienceRisk (Customer customer)
            {
                BigDecimal risk = BigDecimal.ZERO;
                int workExperienceWithCurrentEmployer = 3;
                if (workExperienceWithCurrentEmployer < 2) {
                    risk = risk.add(BigDecimal.valueOf(0.1));
                } else {
                    risk = risk.add(BigDecimal.valueOf(0.3));
                }
                return risk;
            }

            @Override
            public BigDecimal calculateSalaryPerCurrentWorkExperienceRisk (Customer customer)
            {
                BigDecimal risk = BigDecimal.ZERO;
                if (customer.getWorkExperienceWithCurrentEmployer() != null && customer.getSalary() != null) {
                    BigDecimal salaryPerExperience = customer.getSalary().divide(BigDecimal.valueOf(customer.getWorkExperienceWithCurrentEmployer()), 2, RoundingMode.HALF_UP);
                    if (salaryPerExperience.compareTo(BigDecimal.valueOf(100000)) > 0) {
                        risk = risk.add(BigDecimal.valueOf(0.3));
                    } else if (salaryPerExperience.compareTo(BigDecimal.valueOf(50000)) > 0) {
                        risk = risk.add(BigDecimal.valueOf(0.2));
                    } else if (salaryPerExperience.compareTo(BigDecimal.valueOf(20000)) > 0) {
                        risk = risk.add(BigDecimal.valueOf(0.1));
                    }
                }
                return risk;
            }
        }

