package com.codigomaestro.ev1armando_gonzalez.controllers;

import com.codigomaestro.ev1armando_gonzalez.models.Stats;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.codigomaestro.ev1armando_gonzalez.connection.DB.getConnection;

public class StatsController {

    private String INSERT_STATS = "INSERT INTO stats (iduser, iac, imc) VALUES (?,?,?)";

    public static double calculateIMC(double weight, double stature) {
        // Stature should be in meters
        return weight / (Math.pow(stature, 2));
    }

    public static double calculateIAC(double cadera, double stature) {
        // Stature should be in meters and cadera in centimeters
        return (cadera / (Math.pow(stature, 1.5))) - 18;
    }

    public boolean insertStats(Stats stats) {
        String CHECK_USER_EXISTS = "SELECT COUNT(*) FROM user WHERE iduser = ?";

        try (Connection conn = getConnection();
             PreparedStatement checkUserStmt = conn.prepareStatement(CHECK_USER_EXISTS);
             PreparedStatement ps = conn.prepareStatement(INSERT_STATS)) {

            // Check if the user exists
            checkUserStmt.setInt(1, stats.getIdUser());
            ResultSet rs = checkUserStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // User exists, proceed with insert
                ps.setInt(1, stats.getIdUser());
                ps.setFloat(2, stats.getIAC());
                ps.setFloat(3, stats.getIMC());
                ps.executeUpdate();
                return true;
            } else {
                // User does not exist
                System.err.println("User with id " + stats.getIdUser() + " does not exist.");
                return false;
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }
}