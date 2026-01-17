package com.vitorhenriquec0.worldsim.model;

public enum Profession {
    
    UNEMPLOYED("Unemployed", 0.0),
    FARMER("Farmer", 1200.0),
    BLACKSMITH("Blacksmith", 1800.0),
    MERCHANT("Merchant", 2500.0);

    private final String label;
    private final double baseSalary;

    Profession(String label, double baseSalary) {
        this.label = label;
        this.baseSalary = baseSalary;
    }

    public String getLabel() {
        return label;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}
