package com.vitorhenriquec0.worldsim.events;

import com.vitorhenriquec0.worldsim.model.World;
import com.vitorhenriquec0.worldsim.model.Citizen;

public class EconomicBoom extends WorldEvent {
    
    @Override
    public String getName() {
        return "Technological Boom";
    }

    @Override
    public void apply(World world) {
        System.out.println(">>> PROSPERITY! The economy is booming!");

        double grossBonus = 500.0;
        int count = 0;

        for (Citizen citizen : world.getCity().getPopulation()) {
            // the bonus is also taxed.
            double netBonus = world.getCity().getEconomy().collectTax(grossBonus);

            citizen.receiveDirectDeposit(netBonus);
            count++;
        }

        System.out.println(">>> Market grew. Citizens are richer.");
        System.out.println(">>> " + count + " citizens received a bonus of $" + grossBonus + " (Taxed).");
    }
}
