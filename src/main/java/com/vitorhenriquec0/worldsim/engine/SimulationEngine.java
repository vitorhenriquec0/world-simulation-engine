package com.vitorhenriquec0.worldsim.engine;

import com.vitorhenriquec0.worldsim.model.World;
import com.vitorhenriquec0.worldsim.rules.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine {
    
    private List<SimulationRule> monthlyRules;
    private List<SimulationRule> annualRules;

    public SimulationEngine() {
        this.monthlyRules = new ArrayList<>();
        this.annualRules = new ArrayList<>();

        this.monthlyRules.add(new TaxRule());

        this.annualRules.add(new ConstructionRule());
        this.annualRules.add(new AgingRule());
        this.annualRules.add(new JobRule());
        this.annualRules.add(new DeathRule());
        this.annualRules.add(new ReproductionRule());
        this.annualRules.add(new RandomEventRule());

        this.annualRules.add(new StatisticsRule());
    }

    public void processMonthly(World world) {
        for (SimulationRule rule : monthlyRules) {
            rule.apply(world);
        }
    }

    public void processAnnual(World world) {
        for (SimulationRule rule : annualRules) {
            rule.apply(world);
        }
    }
}
