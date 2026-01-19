package com.vitorhenriquec0.worldsim.model;

import com.vitorhenriquec0.worldsim.engine.SimulationEngine;
import com.vitorhenriquec0.worldsim.engine.SimulationTime;

/*
    Represents the entire simulated world.
    This class acts as the root os the simulation, containing the city,
 population, and managing the time progression.
*/



public class World {
    
    private SimulationTime time;
    private City city;
    private SimulationEngine engine;

    private long idCounter = 1000;

    public World() {
        this.time = new SimulationTime();
        this.city = new City("Techopolis");
        this.engine = new SimulationEngine();

        this.city.addCitizen(new Citizen(1L, "Adam", 20));
        this.city.addCitizen(new Citizen(2L,"Eve", 18));
    }

    public void advanceTime() {
        boolean isNewYear = this.time.advance();

        this.engine.processMonthly(this);

        if (isNewYear) {
            System.out.println("HAPPY NEW YEAR! Simulating aging effects.");

            this.engine.processAnnual(this);

            // System.out.println("CITY TREASURY: $" + this.city.getEconomy().getTreasureBalance());
            // System.out.println(this.city.getPopulationInfo());
            System.out.println();
        }
    }

    public City getCity() {
        return city;
    }

    public SimulationTime getTime() {
        return this.time;
    }

    public long generateId() {
        return ++idCounter;
    }
}
