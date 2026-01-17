package com.vitorhenriquec0.worldsim.rules;

import com.vitorhenriquec0.worldsim.model.Citizen;
import com.vitorhenriquec0.worldsim.model.Profession;
import com.vitorhenriquec0.worldsim.model.World;
import com.vitorhenriquec0.worldsim.model.buildings.BuildingType;

public class TaxRule implements SimulationRule {
    
    @Override
    public void apply(World world) {
        var population = world.getCity().getPopulation();
        var economy = world.getCity().getEconomy();
        var city = world.getCity();

        double salesTaxRevenue = 0;
        boolean hasMarket = city.hasBuilding(BuildingType.MARKETPLACE);

        for (Citizen citizen : population) {
            citizen.receiveSalary(economy);

            if (hasMarket && citizen.getProfession() == Profession.MERCHANT) {
                double tradeBonus = 150.0;
                economy.deposit(tradeBonus);
                salesTaxRevenue += tradeBonus;
            }
        }
    }
}
