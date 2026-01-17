package com.vitorhenriquec0.worldsim.rules;

import com.vitorhenriquec0.worldsim.model.Citizen;
import com.vitorhenriquec0.worldsim.model.City;
import com.vitorhenriquec0.worldsim.model.Profession;
import com.vitorhenriquec0.worldsim.model.World;
import com.vitorhenriquec0.worldsim.model.buildings.BuildingType;

public class JobRule implements SimulationRule {
    
    @Override
    public void apply(World world) {
        var population = world.getCity().getPopulation();
        var city = world.getCity();

        for (Citizen citizen : population) {

            if (citizen.getAge() >= 18 && citizen.getProfession() == Profession.UNEMPLOYED) {
                Profession newJob = pickRandomProfession(city);
                citizen.setProfession(newJob);

                if (newJob != Profession.UNEMPLOYED) {
                    System.out.println(">>> " + citizen.getName() + " is now working as " + newJob.getLabel());
                }
            }
        }
    }

    private Profession pickRandomProfession(City city) {

        double unemploymentChance = 0.12; // default: 12%

        if (city.hasBuilding(BuildingType.SCHOOL)) { unemploymentChance -= 0.03; }
        if (city.hasBuilding(BuildingType.UNIVERSITY)) { unemploymentChance -= 0.05; }

        // security
        if (unemploymentChance < 0) unemploymentChance = 0;

        double chance = Math.random();
        if (chance < unemploymentChance) return Profession.UNEMPLOYED;

        if (chance < 0.50) return Profession.FARMER;
        if (chance < 0.80) return Profession.BLACKSMITH;

        return Profession.MERCHANT;
    }
}
