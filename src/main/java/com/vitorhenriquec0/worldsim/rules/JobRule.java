package com.vitorhenriquec0.worldsim.rules;

import com.vitorhenriquec0.worldsim.model.Citizen;
import com.vitorhenriquec0.worldsim.model.Profession;
import com.vitorhenriquec0.worldsim.model.World;

public class JobRule implements SimulationRule {
    
    @Override
    public void apply(World world) {
        var population = world.getCity().getPopulation();

        for (Citizen citizen : population) {

            if (citizen.getAge() == 18 && citizen.getProfession() == Profession.UNEMPLOYED) {
                Profession newJob = pickRandomProfession();
                citizen.setProfession(newJob);

                if (newJob != Profession.UNEMPLOYED) {
                    System.out.println(">>> " + citizen.getName() + " is now working as " + newJob.getLabel());
                }
            }
        }
    }

    private Profession pickRandomProfession() {
        double chance = Math.random();

        if (chance < 0.10) return Profession.UNEMPLOYED;
        if (chance < 0.50) return Profession.FARMER;
        if (chance < 0.80) return Profession.BLACKSMITH;

        return Profession.MERCHANT;
    }
}
