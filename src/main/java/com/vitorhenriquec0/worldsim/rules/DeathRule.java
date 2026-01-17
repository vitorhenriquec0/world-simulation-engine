package com.vitorhenriquec0.worldsim.rules;

import java.util.Iterator;

import com.vitorhenriquec0.worldsim.model.Citizen;
import com.vitorhenriquec0.worldsim.model.World;

public class DeathRule implements SimulationRule {
    
    @Override
    public void apply(World world) {
        var population = world.getCity().getPopulation();

        Iterator<Citizen> iterator = population.iterator();

        int deadCount = 0;

        while (iterator.hasNext()) {
            Citizen citizen = iterator.next();

            boolean shouldDie = false;

            if (citizen.getAge() > 100) {
                shouldDie = true;
            }
            else if (citizen.getAge() > 75 && Math.random() < 0.20) {
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
