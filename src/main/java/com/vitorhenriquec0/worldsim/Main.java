package com.vitorhenriquec0.worldsim;

import com.vitorhenriquec0.worldsim.model.Profession;
import com.vitorhenriquec0.worldsim.model.World;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- World Simulation Engine ---");

        World myWorld = new World();

        // melhorar essa parte futuramente
        System.out.println("Assigning jobs to citizens...");
        myWorld.getCity().getPopulation().get(0).setProfession(Profession.FARMER); // Adam
        myWorld.getCity().getPopulation().get(1).setProfession(Profession.MERCHANT); // Eve

        for (int i = 0; i < 8000; i++) {
            myWorld.advanceTime();

            try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
