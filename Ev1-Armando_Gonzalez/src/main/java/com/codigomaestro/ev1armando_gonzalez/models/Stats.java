package com.codigomaestro.ev1armando_gonzalez.models;

public class Stats {

    private int idUser;
    private float IAC,IMC;

    @Override
    public String toString() {
        return "Stats{" +
                "idUser=" + idUser +
                ", IAC=" + IAC +
                ", IMC=" + IMC +
                '}';
    }

    @Override
    public boolean equals(Object o) {


        if (o == null || getClass() != o.getClass()) return false;

        Stats stats = (Stats) o;
        return idUser == stats.idUser && Float.compare(IAC, stats.IAC) == 0 && Float.compare(IMC, stats.IMC) == 0;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + Float.hashCode(IAC);
        result = 31 * result + Float.hashCode(IMC);
        return result;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public float getIAC() {
        return IAC;
    }

    public void setIAC(float IAC) {
        this.IAC = IAC;
    }

    public float getIMC() {
        return IMC;
    }

    public void setIMC(float IMC) {
        this.IMC = IMC;
    }
}
