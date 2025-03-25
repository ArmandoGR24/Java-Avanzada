package com.codigomaestro.actividad8agr;

import com.codigomaestro.actividad8agr.model.User;
import com.codigomaestro.actividad8agr.model.UserStore;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/register-servlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String role = request.getParameter("role");

        User newUser = new User(username, password, role);
        UserStore.addUser(newUser);

        response.sendRedirect("index.jsp");
    }
}