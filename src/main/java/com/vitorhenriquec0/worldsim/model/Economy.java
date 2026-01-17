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

    public double getTreasuryBalance() {
        return this.treasuryBalance;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public void deposit(double amount) {
        this.treasuryBalance += amount;
    }

    // Returns true if payment was successful,
    // false if there were insufficient funds.
    public boolean withdraw(double amount) {
        if (this.treasuryBalance >= amount) {
            this.treasuryBalance -= amount;
            return true;
        }
        return false;
    }
}
