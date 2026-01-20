package com.vitorhenriquec0.worldsim.rules;

import com.vitorhenriquec0.worldsim.config.SimulationConfig;
import com.vitorhenriquec0.worldsim.model.Citizen;
import com.vitorhenriquec0.worldsim.model.World;
import com.vitorhenriquec0.worldsim.model.buildings.BuildingType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeathRule implements SimulationRule {
    
    @Override
    public void apply(World world) {
        var population = world.getCity().getPopulation();
        var economy = world.getCity().getEconomy();

        Iterator<Citizen> iterator = population.iterator();

        int deadCount = 0;

        double deathChance = 0.15; // default: 20%

        if (world.getCity().hasBuilding(BuildingType.BHU)) {
            deathChance -= 0.02;
        }

        if (world.getCity().hasBuilding(BuildingType.HOSPITAL)) {
            deathChance -= 0.05;
        }

        System.out.println("DEBUB: Current Death Rate for >75yo is: " + (deathChance * 100) + "%");

        while (iterator.hasNext()) {
            Citizen citizen = iterator.next();
            boolean shouldDie = false;

            if (citizen.getAge() > 100) {
                shouldDie = true;
            }
            else if (citizen.getAge() > 75 && Math.random() < deathChance) {
                shouldDie = true;
            }

            if (shouldDie) {

                double fortune = citizen.getBalance();

                if (fortune > 0) {
                    double taxRate = SimulationConfig.getInheritanceTaxRate();
                    double taxAmount = fortune * taxRate;
                    double netInheritance = fortune - taxAmount;

                    economy.deposit(taxAmount);

                    List<Citizen> heirs = new ArrayList<>();
                    List<Long> childrensIds = citizen.getChildrenIds();

                    if (!childrensIds.isEmpty()) {
                        for (Citizen potencialHeir : population) {
                            if (childrensIds.contains(potencialHeir.getId())) {
                                heirs.add(potencialHeir);
                            }
                        }
                    }

                    if (!heirs.isEmpty()) {
                        double share = netInheritance / heirs.size();
                        for (Citizen heir : heirs) {
                            heir.receiveDirectDeposit(share);
                            System.out.println("INHERITANCE: " + heir.getName() + " received $" + String.format("%,.2f", share) + " from " + citizen.getName());
                        }
                    }
                    else {
                        economy.deposit(netInheritance);
                        System.out.println("NO HEIRS: The State claimed the remaining $" + String.format("%,.2f", netInheritance) + " from " + citizen.getName());
                    }
                }

                iterator.remove();
                deadCount++;
            }
        }

        if (deadCount > 0) {
            System.out.println(">>> Died: " + deadCount);
        }
    }
}
