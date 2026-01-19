package com.vitorhenriquec0.worldsim.rules;

import com.vitorhenriquec0.worldsim.config.SimulationConfig;
import com.vitorhenriquec0.worldsim.model.Citizen;
import com.vitorhenriquec0.worldsim.model.World;

public class RebellionRule implements SimulationRule {
    
    @Override
    public void apply(World world) {
        var population = world.getCity().getPopulation();
        if (population.isEmpty()) return;

        double totalHappy = 0;
        for (Citizen c : population) totalHappy += c.getHappiness();
        double average = totalHappy / population.size();

        if (average < SimulationConfig.getHappinessRiotThreshold()) {
            System.out.println(">>> RIOT! The population is furious.");
            System.out.println(">>> Happiness: " + String.format("%.1f", average) + ")");

            // The government loses 20% of its budget to contain the damage.
            double treasury = world.getCity().getEconomy().getTreasuryBalance();
            double damageCost = treasury * 0.20;

            world.getCity().getEconomy().withdraw(damageCost);

            System.out.println(">>> Rioters destroyed public property. Repairs cost: $" + String.format("%,.2f", damageCost));

            // The violence made everyone even sadder (maybe remove that function).
            for(Citizen c : population) c.changeHappiness(-5);
        }
    }
}
