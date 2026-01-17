package com.vitorhenriquec0.worldsim.model;

import com.vitorhenriquec0.worldsim.model.buildings.BuildingType;
import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<Citizen> population;
    private Economy economy;
    private long citizenIdCounter = 0;
    private List<BuildingType> buildings;

    public City(String name) {
        this.name = name;
        this.population = new ArrayList<>();
        this.economy = new Economy();
        this.buildings = new ArrayList<>();
    }

    public void addCitizen(Citizen citizen) {
        this.population.add(citizen);
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

    public long generateNextId() {
        return ++this.citizenIdCounter;
    }

    public void addNewCitizens(List<Citizen> newCitizens) {
        this.population.addAll(newCitizens);
    }

    public void constructBuilding(BuildingType building) {
        this.buildings.add(building);
    }

    public boolean hasBuilding(BuildingType type) {
        return this.buildings.contains(type);
    }

    public List<BuildingType> getBuildings() {
        return this.buildings;
    }
}
