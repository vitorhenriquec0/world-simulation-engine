package com.vitorhenriquec0.worldsim.model;

import com.vitorhenriquec0.worldsim.engine.SimulationTime;

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
        System.out.println(">>> Date: " + this.time.toString());

        if (isNewYear) {
            System.out.println("HAPPY NEW YEAR! Simulating aging effects.");
            this.city.performAnnualUpdate();
        }

        System.out.println(this.city.getPopulationInfo());
        for (Citizen c : this.city.getPopulation()) {
            System.out.println(" - " + c.toString());
        }
        System.out.println("------------------------------");
    }
}
