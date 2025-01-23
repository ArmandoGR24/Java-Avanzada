package com.codigomaestro.actividad1;

public class Triangulo {

    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double CalcularArea() {
        double area = (Math.sqrt(3) / 4) * Math.pow(lado, 2);
        return  area;
    }

    public double CalcularPerimetro() {
        double perimetro = 3 * lado;
        return perimetro;
    }
}
