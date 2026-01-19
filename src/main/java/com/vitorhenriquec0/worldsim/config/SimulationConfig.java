package com.vitorhenriquec0.worldsim.config;

public class SimulationConfig {

    // default

    // economy
    private static final double DEFAULT_TAX_RATE = 0.20;
    private static final double DEFAULT_TREASURY = 10000.0;


    //demography
    private static final int DEFAULT_MIN_WORKING_AGE = 18;
    private static final int DEFAULT_RET_AGE = 65;
    private static final int DEFAULT_MIN_REPRODUCTION_AGE = 18;
    private static final int DEFAULT_MAX_REPRODUCTION_AGE = 60;
    private static final int DEFAULT_MAX_ATTEMPTS_PER_YEAR = 3;

    //happiness
    private static final double DEFAULT_HAPPINESS_RIOT_THRESHOLD = 20.0;
    private static final double DEFAULT_HAPPINESS_BOOM_THRESHOLD = 80.0;

    // others (for a while)
    public static final int HAPPINESS_JOB_BONUS = 2;
    public static final int HAPPINESS_UNEMPLOYED_PENALTY = -5;
    public static final int HAPPINESS_PARK_BONUS = 2;
    public static final int HAPPINESS_TAX_PENALTY = -1;

   
    // actually
    private static double taxRate = DEFAULT_TAX_RATE;
    private static double initialTreasury = DEFAULT_TREASURY;
    
    private static int minWorkingAge = DEFAULT_MIN_WORKING_AGE;
    private static int retirementAge = DEFAULT_RET_AGE;
    
    private static int minReproductionAge = DEFAULT_MIN_REPRODUCTION_AGE;
    private static int maxReproductionAge = DEFAULT_MAX_REPRODUCTION_AGE;
    private static int maxAttemptsPerYear = DEFAULT_MAX_ATTEMPTS_PER_YEAR;

    private static double happinessRiotThreshold = DEFAULT_HAPPINESS_RIOT_THRESHOLD;

    // getters

    public static double getTaxRate() { return taxRate; }
    public static double getInitialTreasury() { return initialTreasury; }

    public static int getMinWorkingAge() { return minWorkingAge; }
    public static int getRetirementAge() { return retirementAge; }
    
    public static int getMinReproductionAge() { return minReproductionAge; }
    public static int getMaxReproductionAge() { return maxReproductionAge; }
    public static int getMaxAttemptsPerYear() { return maxAttemptsPerYear; }

    public static double getHappinessRiotThreshold() { return happinessRiotThreshold; }

    // setters

    public static void setTaxRate(double rate) { 
        if (rate < 0) rate = 0;
        if (rate > 1.0) rate = 1.0;
        taxRate = rate; 
    }

    public static void setMinWorkingAge(int age) {
        minWorkingAge = age;
    }

}
