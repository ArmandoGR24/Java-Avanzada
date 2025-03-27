package com.codigomaestro.evidencia2agr;

import com.codigomaestro.evidencia2agr.Controllers.SessionController;
import com.codigomaestro.evidencia2agr.Controllers.UserController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        UserController userController = new UserController();

        if (userController.loginUser(user, pass)) {
            SessionController.createSession(request, user);

            if ("admin".equals(SessionController.getSession(request).getAttribute("role"))) {
                response.sendRedirect("admin/users.jsp");
            } else {
                response.sendRedirect("user/pacient.jsp");
            }

        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}