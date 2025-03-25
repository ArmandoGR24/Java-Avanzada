package com.codigomaestro.actividad8agr;

import java.io.*;

import com.codigomaestro.actividad8agr.model.UserStore;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "sessionServlet", value = "/session-servlet")
public class SessionServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");

        if (UserStore.userExists(username) && UserStore.getUser(username).getPassword().equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("role", UserStore.getUser(username).getRole());
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}