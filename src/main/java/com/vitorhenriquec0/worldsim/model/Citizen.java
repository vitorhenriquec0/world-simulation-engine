package com.vitorhenriquec0.worldsim.model;

public class Citizen {
    private Long id;
    private String name;
    private int age;

    public Citizen(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void ageOneYear() {
        this.age++;
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

    @Override
    public String toString() {
        return name + " (" + age + "years old)";
    }

}
