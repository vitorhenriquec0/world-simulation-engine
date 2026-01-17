package com.vitorhenriquec0.worldsim.rules;

import com.vitorhenriquec0.worldsim.model.World;
import com.vitorhenriquec0.worldsim.events.*;

public class RandomEventRule implements SimulationRule {
    
    @Override
    public void apply(World world) {
        if (Math.random() < 0.20) {

            WorldEvent event;

            if (Math.random() < 0.50) {
                event = new Plague();
            } else {
                event = new EconomicBoom();
            }

            System.out.println(">>> EVENT: " + event.getName() + " triggered!");

            event.apply(world);
        }
    }
}
