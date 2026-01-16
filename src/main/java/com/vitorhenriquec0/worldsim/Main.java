package com.vitorhenriquec0.worldsim;

import com.vitorhenriquec0.worldsim.model.World;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- World Simulation Engine ---");

        World myWorld = new World();

        for (int i = 0; i < 10; i++) {
            myWorld.advanceTime();

            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
