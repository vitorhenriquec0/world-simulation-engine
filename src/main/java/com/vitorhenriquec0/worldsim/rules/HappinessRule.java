package com.vitorhenriquec0.worldsim.rules;

import com.vitorhenriquec0.worldsim.config.SimulationConfig;
import com.vitorhenriquec0.worldsim.model.Citizen;
import com.vitorhenriquec0.worldsim.model.Profession;
import com.vitorhenriquec0.worldsim.model.World;
import com.vitorhenriquec0.worldsim.model.buildings.BuildingType;

public class HappinessRule implements SimulationRule {
    
    @Override
    public void apply(World world) {
        var population = world.getCity().getPopulation();
        var city = world.getCity();
        boolean hasPark = city.hasBuilding(BuildingType.PARK);

        for (Citizen citizen : population) {

            if (citizen.getAge() < 18) {
                citizen.changeHappiness(1);
            }
            else {
                if (citizen.getProfession() == Profession.UNEMPLOYED) {
                    citizen.changeHappiness(SimulationConfig.HAPPINESS_UNEMPLOYED_PENALTY);
                } else {
                    citizen.changeHappiness(SimulationConfig.HAPPINESS_JOB_BONUS);
                }
            }
            
            // tax, for everyone
            citizen.changeHappiness(SimulationConfig.HAPPINESS_TAX_PENALTY);

            if (hasPark) {
                citizen.changeHappiness(SimulationConfig.HAPPINESS_PARK_BONUS);
            }
        }
    }
}
