package com.soz.creaditevaluator.models;

import com.soz.creaditevaluator.models.creditenums.CreditType;

import java.math.BigDecimal;

public class Credit
{
    private BigDecimal amount;
    private BigDecimal capital;
    private BigDecimal collateral;
    private Integer period;
    private BigDecimal interest;
    private CreditType creditType;
    private BigDecimal installment;

    public BigDecimal getInstallment()
    {
        return installment;
    }

    public void setInstallment(BigDecimal installment)
    {
        this.installment = installment;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getCapital()
    {
        return capital;
    }

    public void setCapital(BigDecimal capital)
    {
        this.capital = capital;
    }

    public BigDecimal getCollateral()
    {
        return collateral;
    }

    public void setCollateral(BigDecimal collateral)
    {
        this.collateral = collateral;
    }

    public Integer getPeriod()
    {
        return period;
    }

    public void setPeriod(Integer period)
    {
        this.period = period;
    }

    public BigDecimal getInterest()
    {
        return interest;
    }

    public void setInterest(BigDecimal interest)
    {
        this.interest = interest;
    }

    public CreditType getCreditType()
    {
        return creditType;
    }

    public void setCreditType(CreditType creditType)
    {
        this.creditType = creditType;
    }
}
