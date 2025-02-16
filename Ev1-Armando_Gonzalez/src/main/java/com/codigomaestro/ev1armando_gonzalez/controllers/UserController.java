package com.codigomaestro.ev1armando_gonzalez.controllers;

import com.codigomaestro.ev1armando_gonzalez.models.User;

import javax.naming.NamingException;

import java.sql.*;

import static com.codigomaestro.ev1armando_gonzalez.connection.DB.getConnection;

public class UserController {

    private static final String INSERT_USER = "INSERT INTO user (name,age,sex,stature,weight) VALUES (?,?,?,?,?)";
    private static final String SELECT = "SELECT * FROM users";
    private static final String DELETE = "DELETE FROM users WHERE id = ?";
    private static final String UPDATE = "UPDATE users SET name = ?, age = ?,sex = ?,stature = ?,weight = ? WHERE id = ?";

    public int insertUser(User user) {
        String INSERT_USER = "INSERT INTO user (name, age, sex, stature, weight, cadera) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getSex());
            ps.setDouble(4, user.getStature());
            ps.setDouble(5, user.getWeight());
            ps.setInt(6, user.getCadera());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
