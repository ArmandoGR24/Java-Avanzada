package com.codigomaestro.ev1armando_gonzalez.controllers;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.codigomaestro.ev1armando_gonzalez.connection.DB.getConnection;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "usercontroller", value = "/usercontroller")
public class UserController extends HttpServlet {

    private static final String INSERT_USER = "INSERT INTO users (name,age,sex,stature,weight) VALUES (?,?,?,?,?)";
    private static final String SELECT = "SELECT * FROM users";
    private static final String DELETE = "DELETE FROM users WHERE id = ?";
    private static final String UPDATE = "UPDATE users SET name = ?, age = ?,sex = ?,stature = ?,weight = ? WHERE id = ?";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Establecer el tipo de contenido de la respuesta
        response.setContentType("text/html");

        // Obtener los parámetros del formulario
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        double stature = Double.parseDouble(request.getParameter("stature"));
        double weight = Double.parseDouble(request.getParameter("weight"));

        response.getWriter().println("Name: " + name);
        response.getWriter().println("Age: " + age);
        response.getWriter().println("sex: " + sex);
        response.getWriter().println("stature: " + stature);
        response.getWriter().println("weight: " + weight);

    }

}