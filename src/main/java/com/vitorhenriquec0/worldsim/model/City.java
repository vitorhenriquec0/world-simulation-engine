package com.vitorhenriquec0.worldsim.model;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<Citizen> population;

    public  City(String name) {
        this.name = name;
        this.population = new ArrayList<>();
    }

    public void addCitizen(Citizen citizen) {
        this.population.add(citizen);
    }

    public void updateDay() {
        for (Citizen citizen : population) {
            citizen.ageOneYear();
        }
    }

    public String getPopulationInfo() {
        return "City: " + name + " | Population: " + population.size();
    }

    public List<Citizen> getPopulation() {
        return population;
    }
}
