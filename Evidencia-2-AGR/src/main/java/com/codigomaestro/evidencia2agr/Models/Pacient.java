package com.codigomaestro.evidencia2agr.Models;

import java.util.Objects;

public class Pacient {

    private String name,sex;
    private int age;
    private double stature,weight,cadera;

    @Override
    public String toString() {
        return "Pacient{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", stature=" + stature +
                ", weight=" + weight +
                ", cadera=" + cadera +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Pacient pacient)) return false;

        return age == pacient.age && Double.compare(stature, pacient.stature) == 0 && Double.compare(weight, pacient.weight) == 0 && Double.compare(cadera, pacient.cadera) == 0 && Objects.equals(name, pacient.name) && Objects.equals(sex, pacient.sex);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(sex);
        result = 31 * result + age;
        result = 31 * result + Double.hashCode(stature);
        result = 31 * result + Double.hashCode(weight);
        result = 31 * result + Double.hashCode(cadera);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getStature() {
        return stature;
    }

    public void setStature(double stature) {
        this.stature = stature;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCadera() {
        return cadera;
    }

    public void setCadera(double cadera) {
        this.cadera = cadera;
    }
}
