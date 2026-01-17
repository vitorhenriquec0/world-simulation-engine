package com.vitorhenriquec0.worldsim.rules;

import com.vitorhenriquec0.worldsim.model.Citizen;
import com.vitorhenriquec0.worldsim.model.Profession;
import com.vitorhenriquec0.worldsim.model.World;
import com.vitorhenriquec0.worldsim.model.buildings.BuildingType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsRule implements SimulationRule {
    
    @Override
    public void apply(World world) {
        var city = world.getCity();
        var population = city.getPopulation();

        System.out.println("========================================");
        System.out.println(" STATISTICS REPORT - " + world.getTime().toString());
        System.out.println("========================================");

        System.out.println(" Population: " + population.size());
        System.out.println(" Treasury:   $" + String.format("%,.2f", city.getEconomy().getTreasuryBalance()));
        
        List<BuildingType> buildings = city.getBuildings();
        
        System.out.println("\n  Infrastructure:");
        if (buildings.isEmpty()) {
            System.out.println("   - None (City is underdeveloped)");
        } else {
            for (BuildingType b : buildings) {
                System.out.println("   [x] " + b.getName());
            }
        }

        System.out.println("\n Workforce Distribution:");

        int children = 0;
        int unemployedAdults = 0;
        Map<String, Integer> jobs = new HashMap<>();
        
        for (Citizen c : population) {
            // 1. Se for menor de 18, é Criança/Estudante
            if (c.getAge() < 18) {
                children++;
            } 
            // 2. Se for adulto e não tem emprego, é Desempregado Real
            else if (c.getProfession() == Profession.UNEMPLOYED) {
                unemployedAdults++;
            } 
            // 3. Se trabalha
            else {
                String jobName = c.getProfession().getLabel();
                jobs.put(jobName, jobs.getOrDefault(jobName, 0) + 1);
            }
        }

        // Imprime separado
        System.out.println("   - Children/Students: " + children);
        System.out.println("   - Unemployed Adults: " + unemployedAdults); // <--- ESSE NÚMERO DEVE SER ZERO (Graças à Universidade)

        for (var entry : jobs.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("========================================\n");
    }
}
