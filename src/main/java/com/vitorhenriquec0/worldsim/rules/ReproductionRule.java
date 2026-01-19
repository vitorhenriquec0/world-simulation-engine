package com.vitorhenriquec0.worldsim.rules;

import com.vitorhenriquec0.worldsim.config.SimulationConfig;
import com.vitorhenriquec0.worldsim.model.Citizen;
import com.vitorhenriquec0.worldsim.model.World;
import java.util.List;
import java.util.stream.Collectors;

public class ReproductionRule implements SimulationRule {
    
    @Override
    public void apply(World world) {
        var city = world.getCity();
        var population = city.getPopulation();

        // filter candidates (18 - 60 years)
        List<Citizen> candidates = population.stream()
            .filter(c -> c.getAge() >= SimulationConfig.getMinWorkingAge() && c.getAge() <= 60)
            .collect(Collectors.toList());

        if (candidates.size() < 2) return;  // there is no possible couple

        // try to create a random couple
        int attempts = SimulationConfig.getMaxAttemptsPerYear();
        while (attempts > 0) {
            Citizen p1 = candidates.get((int) (Math.random() * candidates.size()));
            Citizen p2 = candidates.get((int) (Math.random() * candidates.size()));

            if (p1.getId() != p2.getId()) {

                long babyId = world.generateId();

                Citizen baby = new Citizen(babyId, "Citizen" + babyId, 0);

                baby.setParents(p1.getId(), p2.getId());

                p1.addChild(baby.getId());
                p2.addChild(baby.getId());

                population.add(baby);
                System.out.println("   BABY BORN: " + baby.getName() + 
                                   " (Parents: " + p1.getName() + " & " + p2.getName() + ")");

                break;
            }
            attempts--;
        }

    }
}
