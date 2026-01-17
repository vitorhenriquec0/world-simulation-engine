package com.vitorhenriquec0.worldsim.rules;

import com.vitorhenriquec0.worldsim.model.World;
import com.vitorhenriquec0.worldsim.model.buildings.BuildingType;

public class ConstructionRule implements SimulationRule {
    
    @Override
    public void apply(World world) {
        var city = world.getCity();
        var economy = city.getEconomy();
        double balance = economy.getTreasuryBalance();

        for (BuildingType building : BuildingType.values()) {

            // It only builds if it doesn't already exist.
            // You only build if you have the money to pay for it and an emergency fund left over.
            if (!city.hasBuilding(building) && balance >= (building.getCost() + 10000)) {

                boolean success = economy.withdraw(building.getCost());

                if (success) {
                    city.constructBuilding(building);

                    System.out.println(">>> CONSTRUCTION: The city built a " + building.getName() + "!");
                    System.out.println(">>> Cost: $" + building.getCost() + " | Benefit: " + building.getDescription());

                    break;
                }
            }
        }
    }
}
