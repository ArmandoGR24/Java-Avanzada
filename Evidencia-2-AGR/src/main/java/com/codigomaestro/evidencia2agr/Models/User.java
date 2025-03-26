package com.codigomaestro.evidencia2agr.Models;


import java.util.Objects;

public class User {

    private String user,pass,role,color;


    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", role='" + role + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof User user1)) return false;

        return Objects.equals(user, user1.user) && Objects.equals(pass, user1.pass) && Objects.equals(role, user1.role) && Objects.equals(color, user1.color);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(user);
        result = 31 * result + Objects.hashCode(pass);
        result = 31 * result + Objects.hashCode(role);
        result = 31 * result + Objects.hashCode(color);
        return result;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
