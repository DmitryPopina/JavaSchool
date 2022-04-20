package com.github.dmitrypopina.javaschool.lesson5_reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class Rabbit {
    private final String name;
    private final int age;
    private int weight;
    private String hidden;

    public Rabbit(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString(){
        return String.format("Name = %s, Age = %d, Weight = %d, H = %s", this.name, this.age, this.weight, this.hidden);
    }
}
