package com.codigomaestro.actividad7.models;

import java.util.Objects;

public class UserData {

    private String username;
    private double area, perimetro, lado;

    @Override
    public String toString() {
        return "UserData{" +
                "username='" + username + '\'' +
                ", area=" + area +
                ", perimetro=" + perimetro +
                ", lado=" + lado +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof UserData userData)) return false;

        return Double.compare(area, userData.area) == 0 && Double.compare(perimetro, userData.perimetro) == 0 && Double.compare(lado, userData.lado) == 0 && Objects.equals(username, userData.username);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(username);
        result = 31 * result + Double.hashCode(area);
        result = 31 * result + Double.hashCode(perimetro);
        result = 31 * result + Double.hashCode(lado);
        return result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}
