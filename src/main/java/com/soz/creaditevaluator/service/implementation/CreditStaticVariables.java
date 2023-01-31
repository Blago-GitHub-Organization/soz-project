package com.soz.creaditevaluator.service.implementation;

import java.math.BigDecimal;

public class CreditStaticVariables {
    public static final BigDecimal investmentAmount = BigDecimal.valueOf(10000);
    public static final BigDecimal currentAmount = BigDecimal.valueOf(11000);
    public static final BigDecimal monthlyInstallment = BigDecimal.valueOf(500);
    public static final BigDecimal loanAmount = BigDecimal.valueOf(2000);
    public static final BigDecimal timePeriod = BigDecimal.valueOf(3);
    public static final BigDecimal creditScore = BigDecimal.valueOf(690);
    public static final BigDecimal creditLimit = BigDecimal.valueOf(31015);
    public static final BigDecimal debtToIncomeRatio = BigDecimal.valueOf(0.5);
    public static final double marketStability = 0.6;
    public static final double ventureStability = 0.4;
}
