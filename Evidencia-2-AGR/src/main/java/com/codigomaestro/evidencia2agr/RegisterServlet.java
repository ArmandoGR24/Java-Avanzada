package com.codigomaestro.evidencia2agr;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.codigomaestro.evidencia2agr.Controllers.UserController;
import com.codigomaestro.evidencia2agr.DB.DB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private String message;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String role = request.getParameter("role");
        String color = request.getParameter("color");

        UserController userController = new UserController();

        if (userController.registerUser(user, pass, role, color)) {
            message = "User registered successfully";
        } else {
            message = "User registration failed";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Databases</h1>");
        out.println("<ul>");

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT datname FROM pg_database WHERE datistemplate = false")) {

            while (resultSet.next()) {
                String databaseName = resultSet.getString("datname");
                out.println("<li>" + databaseName + "</li>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<li>Error retrieving databases: " + e.getMessage() + "</li>");
        }

        out.println("</ul>");
        out.println("</body></html>");
    }


    public void destroy() {
    }
}