package com.vitorhenriquec0.worldsim.model;

import com.vitorhenriquec0.worldsim.engine.SimulationTime;
import com.vitorhenriquec0.worldsim.events.EconomicBoom;
import com.vitorhenriquec0.worldsim.events.Plague;
import com.vitorhenriquec0.worldsim.events.WorldEvent;

/*
    Represents the entire simulated world.
    This class acts as the root os the simulation, containing the city,
 population, and managing the time progression.
*/



public class World {
    
    private SimulationTime time;
    private City city;

    public World() {
        this.time = new SimulationTime();
        this.city = new City("Techopolis");

        this.city.addCitizen(new Citizen(1L, "Adam", 20));
        this.city.addCitizen(new Citizen(2L,"Eve", 18));
    }

    public void advanceTime() {
        boolean isNewYear = this.time.advance();

        this.city.performMonthlyUpdate();

        if (isNewYear) {
            System.out.println("HAPPY NEW YEAR! Simulating aging effects.");

            this.city.performAnnualUpdate();
            tryTriggerRandomEvent();

            System.out.println("CITY TREASURY: $" + this.city.getEconomy().getTreasureBalance());

            System.out.println(this.city.getPopulationInfo());
            System.out.println();
        }
    }

    public City getCity() {
        return city;
    }

    private void tryTriggerRandomEvent() {
        if (Math.random() < 0.20) {

            WorldEvent event;

            if (Math.random() < 0.50) {
                event = new Plague();
            } else {
                event = new EconomicBoom();
            }
            

            System.out.println(">>> EVENT: " + event.getName() + " triggered!");
            event.apply(this);
        }
    }
}
