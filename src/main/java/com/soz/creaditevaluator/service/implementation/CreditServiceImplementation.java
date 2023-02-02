package com.soz.creaditevaluator.service.implementation;

import com.soz.creaditevaluator.models.Credit;
import com.soz.creaditevaluator.service.interfaces.CreditService;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditServiceImplementation implements CreditService //todo implement
{
    BigDecimal investmentAmount = CreditStaticVariables.investmentAmount;
    BigDecimal currentAmount = CreditStaticVariables.currentAmount;
    BigDecimal monthlyInstallment = CreditStaticVariables.monthlyInstallment;
    BigDecimal loanAmount = CreditStaticVariables.loanAmount;
    BigDecimal timePeriod = CreditStaticVariables.timePeriod;
    BigDecimal creditScore = CreditStaticVariables.creditScore;
    BigDecimal creditLimit = CreditStaticVariables.creditLimit;
    BigDecimal debtToIncomeRatio = CreditStaticVariables.debtToIncomeRatio;
    double marketStability = CreditStaticVariables.marketStability;
    double ventureStability = CreditStaticVariables.ventureStability;

    @Override
    public BigDecimal calculateFullScore(Credit credit)
    {
        BigDecimal amountScore = calculateAmountScore(credit);
        BigDecimal capitalScore = calculateCapitalScore(credit);
        BigDecimal installmentScore = calculateInstallmentScore(credit);
        BigDecimal periodScore = calculatePeriodScore(credit);
        BigDecimal creditTypeScore = calculateCreditTypeScore(credit);

        return amountScore.add(capitalScore).add(installmentScore).add(periodScore).add(creditTypeScore);
    }

    public BigDecimal calculateAmountScore(Credit credit)
    {
        return investmentAmount.subtract(currentAmount).abs();
    }

    public BigDecimal calculateCapitalScore(Credit credit)
    {
        BigDecimal marketStabilityBD = BigDecimal.valueOf(marketStability);
        BigDecimal ventureStabilityBD = BigDecimal.valueOf(ventureStability);
        BigDecimal stabilityProduct = marketStabilityBD.multiply(ventureStabilityBD);
        BigDecimal one = BigDecimal.valueOf(1);
        BigDecimal riskFactor = one.subtract(stabilityProduct);
        return credit.getCapital()
                     .multiply(new BigDecimal(-1));

    }

    public BigDecimal calculateInstallmentScore(Credit credit)
    {
        BigDecimal loanTermInMonths = loanAmount.divide(monthlyInstallment, 0, BigDecimal.ROUND_UP);
        BigDecimal monthlyIncomeAfterLoan = investmentAmount.subtract(monthlyInstallment);
        return monthlyIncomeAfterLoan.divide(loanTermInMonths, 2, BigDecimal.ROUND_UP);

    }

    public BigDecimal calculatePeriodScore(Credit credit)
    {
        BigDecimal rateOfReturn = currentAmount.subtract(investmentAmount)
                                               .divide(investmentAmount, 10, BigDecimal.ROUND_HALF_EVEN);
        return rateOfReturn.divide(timePeriod, 10, BigDecimal.ROUND_HALF_EVEN);

    }

    public BigDecimal calculateCreditTypeScore(Credit credit)
    {
        BigDecimal creditScoreWeight = new BigDecimal("0.4");
        BigDecimal creditLimitWeight = new BigDecimal("0.3");
        BigDecimal debtToIncomeWeight = new BigDecimal("0.3");
        return creditScoreWeight.multiply(creditScore)
                                .add(creditLimitWeight.multiply(creditLimit))
                                .add(debtToIncomeWeight.multiply(debtToIncomeRatio))
                                .setScale(2, BigDecimal.ROUND_HALF_EVEN);

    }
}
