package com.vitorhenriquec0.worldsim.rules;

import com.vitorhenriquec0.worldsim.model.Citizen;
import com.vitorhenriquec0.worldsim.model.World;
import com.vitorhenriquec0.worldsim.model.buildings.BuildingType;
import java.util.Iterator;

public class DeathRule implements SimulationRule {
    
    @Override
    public void apply(World world) {
        var population = world.getCity().getPopulation();

        Iterator<Citizen> iterator = population.iterator();

        int deadCount = 0;

        double deathChance = 0.20; // default: 20%

        if (world.getCity().hasBuilding(BuildingType.BHU)) {
            deathChance -= 0.02;
        }

        if (world.getCity().hasBuilding(BuildingType.HOSPITAL)) {
            deathChance -= 0.05;
        }

        System.out.println("DEBUB: Current Death Rate for >75yo is: " + (deathChance * 100) + "%");

        while (iterator.hasNext()) {
            Citizen citizen = iterator.next();
            boolean shouldDie = false;

            if (citizen.getAge() > 100) {
                shouldDie = true;
            }
            else if (citizen.getAge() > 75 && Math.random() < deathChance) {
                shouldDie = true;
            }

            if (shouldDie) {
                iterator.remove();
                deadCount++;
            }
        }

        if (deadCount > 0) {
            System.out.println(">>> Died: " + deadCount);
        }
    }
}
