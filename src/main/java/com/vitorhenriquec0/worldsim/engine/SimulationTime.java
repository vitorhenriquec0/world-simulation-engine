package com.vitorhenriquec0.worldsim.engine;

public class SimulationTime {
    private int month;
    private int year;

    public SimulationTime() {
        this.month = 1;
        this.year = 1;
    }

    public boolean advance() {
        this.month++;
        boolean newYear = false;

        if (this.month > 12) {
            this.year++;
            this.month = 1;
            newYear = true;
        }
            return newYear;
    }

    @Override
    public String toString() {
        return String.format("%02d/%04d", month, year);
    }
}
