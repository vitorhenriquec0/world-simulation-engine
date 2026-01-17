package com.vitorhenriquec0.worldsim.model;

public class Citizen {
    private Long id;
    private String name;
    private int age;
    private Profession profession;
    private double balance; // money in account

    public Citizen(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.profession = Profession.UNEMPLOYED; // default
        this.balance = 0.0; // default
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
