package com.vitorhenriquec0.worldsim.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class City {
    private String name;
    private List<Citizen> population;
    private Economy economy;
    private long citizenIdCounter = 0;

    public City(String name) {
        this.name = name;
        this.population = new ArrayList<>();
        this.economy = new Economy();
    }

    public void addCitizen(Citizen citizen) {
        this.population.add(citizen);
    }

    public void performMonthlyUpdate() {
        for (Citizen citizen : population) {
            citizen.receiveSalary(this.economy);
        }
    }

    public void performAnnualUpdate() {
    
        // temporary list of births for the year.
        List<Citizen> newCitizens = new ArrayList<>();
        int deadCount = 0;

        Iterator<Citizen> iterator = population.iterator();

        while (iterator.hasNext()) {
            Citizen citizen = iterator.next();

            citizen.age();

            // unemployed -> job seeker
            if (citizen.getAge() == 18 && citizen.getProfession() == Profession.UNEMPLOYED) {
                Profession newJob = pickRandomProfession();
                citizen.setProfession(newJob);

                if (newJob != Profession.UNEMPLOYED) {
                    System.out.println(citizen.getName() + " is now working as " + newJob.getLabel());
                }
            }

            // logic: If your age is greater than 75, you have a chance of dying.
            // If it's greater than 100, you die instantly
            boolean died = false;

            if (citizen.getAge() > 100 || (citizen.getAge() > 75 && Math.random() < 0.20)) {
                iterator.remove(); // safely remove from list
                deadCount++;
                died = true; // mark the death to avoid having children later.
            }

            if (!died && citizen.getAge() >= 18 && Math.random() < 0.25) {
                long newId = ++citizenIdCounter;
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

    private Profession pickRandomProfession() {
        double chance = Math.random();

        if (chance < 0.10) return Profession.UNEMPLOYED;
        if (chance < 0.50) return Profession.FARMER;
        if (chance < 0.80) return Profession.BLACKSMITH;

        return Profession.MERCHANT;
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
