package com.vitorhenriquec0.worldsim.rules;

import com.vitorhenriquec0.worldsim.model.Citizen;
import com.vitorhenriquec0.worldsim.model.World;
import java.util.ArrayList;
import java.util.List;

public class ReproductionRule implements SimulationRule {
    
    @Override
    public void apply(World world) {
        var city = world.getCity();
        var population = city.getPopulation();

        List<Citizen> babies = new ArrayList<>();

        for (Citizen citizen : population) {
            if (citizen.getAge() >= 18 && Math.random() < 0.25) {

                long newId = city.generateNextId();

                Citizen baby = new Citizen(newId, "Citizen" + newId, 0);
                babies.add(baby);
            }
        }

        if (!babies.isEmpty()) {
            city.addNewCitizens(babies);
            System.out.println(">>> Babies BORN this year: " + babies.size());
        }
    }
}
