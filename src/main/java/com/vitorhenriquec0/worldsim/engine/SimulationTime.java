package com.vitorhenriquec0.worldsim.engine;

public class SimulationTime {
    private int day;
    private int month;
    private int year;

    public SimulationTime() {
        this.day = 1;
        this.month = 1;
        this.year = 1;
    }

    public boolean advance() {
        this.day++;
        boolean newYear = false;

        if (this.day > 30) {
            this.day = 1;
            this.month++;
        }

        if (this.month > 12) {
            this.year++;
            this.month = 1;
            newYear = true;
        }
            return newYear;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}
