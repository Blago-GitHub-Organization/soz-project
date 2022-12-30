package com.soz.creaditevaluator.service;

import com.soz.creaditevaluator.models.Credit;
import com.soz.creaditevaluator.models.Customer;
import com.soz.creaditevaluator.service.interfaces.CreditService;
import com.soz.creaditevaluator.service.interfaces.CreditToCustomerService;
import com.soz.creaditevaluator.service.interfaces.CustomerService;

import java.math.BigDecimal;

public class RiskCalculator
{
    private final CreditService creditService;
    private final CreditToCustomerService creditToCustomerService;
    private final CustomerService customerService;

    public RiskCalculator(CreditService creditService, CreditToCustomerService creditToCustomerService, CustomerService customerService)
    {
        this.creditService = creditService;
        this.creditToCustomerService = creditToCustomerService;
        this.customerService = customerService;
    }

    public boolean calculateRisk(final Customer customer, final Credit credit)
    {
        final BigDecimal creditRisk = creditService.calculateFullRisk(credit);

        final BigDecimal customerRisk = customerService.calculateFullRisk(customer);

        final BigDecimal creditToCustomerRisk = creditToCustomerService.calculateFullRisk(credit, customer);

        return true; //should be calculated
    }
}
