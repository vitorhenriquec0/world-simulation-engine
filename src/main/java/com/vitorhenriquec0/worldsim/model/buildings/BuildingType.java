package com.vitorhenriquec0.worldsim.model.buildings;

public enum BuildingType {
    
    // health
    HOSPITAL("General Hospital", 50000.0, "Reduces death rate by 5%"),
    BHU("Basic Health Unit", 15000.0, "Reduces death rate by 2%"),

    // education
    SCHOOL("Public School", 30000.0, "Reduces unemployment by 3%"),
    UNIVERSITY("State University", 80000.0, "Reduces unemployment by 5%"),

    //others
    MARKETPLACE("Grand Bazaar", 20000.0, "Boosts tax revenue by small amount"),
    PARK("Central Park", 150000.0, "Increases happiness by 2 points per month");

    private final String name;
    private final double cost;
    private final String description;

    BuildingType(String name, double cost, String description) {
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public double getCost() { return cost; }
    public String getName() { return name; }
    public String getDescription() { return description; }
}
