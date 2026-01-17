package com.vitorhenriquec0.worldsim.model;

public class Economy {
    
    private double treasuryBalance; // government money
    private double taxRate;

    public Economy() {
        this.treasuryBalance = 0.0;
        this.taxRate = 0.20;  // 20% tax at the beginning
    }

    // amount: total value earned by the citizen
    public double collectTax(double amount) {
        double tax = amount * this.taxRate;
        this.treasuryBalance += tax;

        return amount - tax; // salary - tax
    }

    public double getTreasureBalance() {
        return treasuryBalance;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
}
