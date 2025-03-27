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

import javax.naming.NamingException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String role = request.getParameter("role");
        String color = request.getParameter("color");

        UserController userController = new UserController();

        if (userController.registerUser(user, pass, role, color)) {

            response.sendRedirect("admin/users.jsp");

        }
    }


    public void destroy() {
    }
}