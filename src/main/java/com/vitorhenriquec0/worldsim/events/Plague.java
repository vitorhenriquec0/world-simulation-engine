package com.vitorhenriquec0.worldsim.events;

import com.vitorhenriquec0.worldsim.model.World;
import com.vitorhenriquec0.worldsim.model.Citizen;
import java.util.Iterator;

public class Plague extends WorldEvent {
    
    @Override
    public String getName() {
        return "The Black Plague";
    }

    @Override
    public void apply(World world) {

        // the plague kills 30% of the population, regardless of age. 
        var population = world.getCity().getPopulation();
        Iterator<Citizen> iterator = population.iterator();

        int deaths = 0;
        while (iterator.hasNext()) {
            Citizen c = iterator.next();

            if (Math.random() < 0.30) {
                iterator.remove();
                deaths++;
            }
        }

        System.out.println(">>> TRAGEDY!!! A plague swept through the city.");
        System.out.println(">>> " + deaths + " citizens died.");
    }
}
