package com.vitorhenriquec0.worldsim.rules;

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
                    citizen.changeHappiness(-5);
                } else {
                    citizen.changeHappiness(2);
                }
            }
            
            // tax, for everyone
            citizen.changeHappiness(-1);

            if (hasPark) {
                citizen.changeHappiness(2);
            }
        }
    }
}
