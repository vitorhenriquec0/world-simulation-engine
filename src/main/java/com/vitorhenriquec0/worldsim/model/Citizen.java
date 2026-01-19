package com.vitorhenriquec0.worldsim.model;

import java.util.ArrayList;
import java.util.List;

public class Citizen {
    private Long id;
    private String name;
    private int age;
    private Profession profession;
    private double balance; // money in account
    private int happiness; // 0 - 100
    private long motherId = -1;
    private long fatherId = -1;

    private List<Long> childrenIds = new ArrayList<>();

    public void setParents(long motherId, long fatherId) {
        this.motherId = motherId;
        this.fatherId = fatherId;
    }

    public void addChild(long childId) {
        this.childrenIds.add(childId);
    }

    public Citizen(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.profession = Profession.UNEMPLOYED; // default
        this.balance = 0.0; // default
        this.happiness = 50; // default
    }

    public void age() {
        this.age++;
    }

    public void receiveSalary(Economy economy) {
        if (this.profession != Profession.UNEMPLOYED) {
            double grossSalary = this.profession.getBaseSalary();

            double netIncome = economy.collectTax(grossSalary);
            this.balance += netIncome;
        }
    }

    public void changeHappiness(int delta) {
        this.happiness += delta;

        if (this.happiness > 100) this.happiness = 100;
        if (this.happiness < 0) this.happiness = 0;
    }

    public int getHappiness() {
        return happiness;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Profession getProfession() {
        return profession;
    }

    public void receiveDirectDeposit(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return String.format("%s (%d years) - %s | Balance: U$ %.2f", name, age, profession.getLabel(), balance);
    }

}
