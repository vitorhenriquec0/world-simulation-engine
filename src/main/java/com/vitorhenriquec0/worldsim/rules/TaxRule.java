package com.vitorhenriquec0.worldsim.rules;

import com.vitorhenriquec0.worldsim.model.World;
import com.vitorhenriquec0.worldsim.model.Citizen;

public class TaxRule implements SimulationRule {
    
    @Override
    public void apply(World world) {
        var population = world.getCity().getPopulation();
        var economy = world.getCity().getEconomy();

        for (Citizen citizen : population) {
            citizen.receiveSalary(economy);
        }
    }
}
