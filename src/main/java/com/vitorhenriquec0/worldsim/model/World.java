package com.vitorhenriquec0.worldsim.model;

/*
    Represents the entire simulated world.
    This class acts as the root os the simulation, containing the city,
 population, and managing the time progression.
*/

public class World {
    
    private int day;
    private City city;

    public World() {
        this.day = 0;

        this.city = new City("Techopolis");

        Citizen adam = new Citizen(1L, "Adam", 20);
        Citizen eve = new Citizen(2L,"Eve", 18);

        this.city.addCitizen(adam);
        this.city.addCitizen(eve);
    }

    public void advanceTime() {
        this.day++;
        System.out.println(">>> Simulation Day: " + this.day);

        this.city.updateDay();

        System.out.println(this.city.getPopulationInfo());

        for (Citizen c : this.city.getPopulation()) {
            System.out.println(" - " + c.toString());
        }
        System.out.println("------------------------------");
    }

    public int getDay() {
        return day;
    }
}
