package com.codigomaestro.evidencia2agr.Controllers;

import static com.codigomaestro.evidencia2agr.DB.DB.getConnection;

import com.codigomaestro.evidencia2agr.Models.Pacient;

import javax.naming.NamingException;
import java.sql.*;

public class PacientController {

    Pacient pacient = new Pacient();


    public static double calculateIMC(double weight, double stature) {
        // Stature should be in meters
        return weight / (Math.pow(stature, 2));
    }

    public static double calculateIAC(double cadera, double stature) {
        // Stature should be in meters and cadera in centimeters
        return (cadera / (Math.pow(stature, 1.5))) - 18;
    }

    public boolean registerPacient(Pacient pacient) {
        String pacientQuery = "INSERT INTO pacients (name, age, sex, stature, weight, cadera) VALUES (?, ?, ?, ?, ?, ?)";
        String statsQuery = "INSERT INTO stats (idpacient, IAC, IMC) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement pacientStatement = connection.prepareStatement(pacientQuery, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement statsStatement = connection.prepareStatement(statsQuery)) {

            // Insert pacient data
            pacientStatement.setString(1, pacient.getName());
            pacientStatement.setInt(2, pacient.getAge());
            pacientStatement.setString(3, pacient.getSex());
            pacientStatement.setDouble(4, pacient.getStature());
            pacientStatement.setDouble(5, pacient.getWeight());
            pacientStatement.setDouble(6, pacient.getCadera());
            pacientStatement.executeUpdate();

            // Get the generated id for the pacient
            ResultSet generatedKeys = pacientStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int pacientId = generatedKeys.getInt(1);

                // Calculate IMC and IAC
                double imc = calculateIMC(pacient.getWeight(), pacient.getStature());
                double iac = calculateIAC(pacient.getCadera(), pacient.getStature());

                // Insert stats data
                // Insert stats data
                statsStatement.setInt(1, pacientId);
                statsStatement.setDouble(2, iac); // Cambiado de imc a iac
                statsStatement.setDouble(3, imc); // Cambiado de iac a imc
                statsStatement.executeUpdate();
            } else {
                throw new SQLException("Failed to retrieve pacient ID.");
            }

            return true;
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }


}
