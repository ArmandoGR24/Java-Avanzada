package com.codigomaestro.evidencia2agr.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionController {

    public static void createSession(HttpServletRequest request, String username) {

        UserController userController = new UserController();
        String role = userController.getUserRole(username);
        String color = userController.getUserColor(username);
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("role", role);
        session.setAttribute("color", color);
    }

    public static HttpSession getSession(HttpServletRequest request) {
        return request.getSession(false);
    }

    public static void invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}