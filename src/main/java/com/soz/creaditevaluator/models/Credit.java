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

    public void setInstallment()
    {
        this.installment = this.amount.divide(new BigDecimal(period), BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount()
    {
        BigDecimal principal = getCapital();
        BigDecimal interest = getInterest();

        BigDecimal interestPerMonth = interest.divide(new BigDecimal(12), 2, BigDecimal.ROUND_HALF_UP)
                                              .divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal totalSum = principal.add(principal.multiply(interestPerMonth).multiply(new BigDecimal(getPeriod())));

        this.amount = totalSum;
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

    public void setInterest()
    {
        switch (getCreditType())
        {
            case HOME_LOAN -> this.interest = new BigDecimal("6.9");
            case PRODUCT_LOAN -> this.interest = new BigDecimal("8.1");
            case PERSONAL_LOAN -> this.interest = new BigDecimal("11.1");
            case EDUCATIONAL_LOAN -> this.interest = new BigDecimal("3.7");
            default -> this.interest = new BigDecimal("23.1");
        }
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
