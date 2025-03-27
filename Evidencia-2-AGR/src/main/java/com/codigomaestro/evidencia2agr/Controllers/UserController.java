package com.codigomaestro.evidencia2agr.Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.codigomaestro.evidencia2agr.Models.User;

import javax.naming.NamingException;

import static com.codigomaestro.evidencia2agr.DB.DB.getConnection;
public class UserController {

    User user = new User();

    public boolean registerUser(String user, String pass, String role, String color) {
        String hashedPass = hashPassword(pass);
        String query = "INSERT INTO users (user, pass, role, color) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, hashedPass);
            preparedStatement.setString(3, role);
            preparedStatement.setString(4, color);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean loginUser(String user, String pass) {
        String hashedPass = hashPassword(pass);
        String query = "SELECT * FROM users WHERE user = ? AND pass = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, hashedPass);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public String getUserRole(String user) {
        String query = "SELECT role FROM users WHERE user = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("role");
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUserColor(String user) {
        String query = "SELECT color FROM users WHERE user = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("color");
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
