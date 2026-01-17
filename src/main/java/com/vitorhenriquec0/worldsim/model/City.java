package com.vitorhenriquec0.worldsim.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class City {
    private String name;
    private List<Citizen> population;
    private Economy economy;

    public City(String name) {
        this.name = name;
        this.population = new ArrayList<>();
        this.economy = new Economy();
    }

    public void addCitizen(Citizen citizen) {
        this.population.add(citizen);
    }

    public void performAnnualUpdate() {
    
        // temporary list of births for the year.
        List<Citizen> newCitizens = new ArrayList<>();
        int deadCount = 0;

        Iterator<Citizen> iterator = population.iterator();

        while (iterator.hasNext()) {
            Citizen citizen = iterator.next();

            citizen.ageOneYear(this.economy);

            // logic: If your age is greater than 75, you have a chance of dying.
            // If it's greater than 100, you die instantly.

            boolean died = false;

            if (citizen.getAge() > 100 || (citizen.getAge() > 75 && Math.random() < 0.20)) {
                iterator.remove(); // safely remove from list
                deadCount++;
                died = true; // mark the death to avoid having children later.
            }

            if (!died && citizen.getAge() >= 18 && Math.random() < 0.10) {
                long newId = population.size() + newCitizens.size() + deadCount + 1L; // unique ID
                Citizen baby = new Citizen(newId, "Citizen" + newId, 0);
                newCitizens.add(baby);
            }
        }

        // add all the babies after the loop. 
        this.population.addAll(newCitizens);

        if (!newCitizens.isEmpty()) {
            System.out.println(">>> Born: " + newCitizens.size());
        }
        if (deadCount > 0) {
            System.out.println(">>> Died: " + deadCount);
        }
    }

    public Economy getEconomy() {
        return economy;
    }

    public String getPopulationInfo() {
        return "City: " + name + " | Population: " + population.size();
    }

    public List<Citizen> getPopulation() {
        return population;
    }
}
